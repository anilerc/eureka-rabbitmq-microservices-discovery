package customer.service;

import customer.controller.CustomerRegistrationRequest;
import customer.model.Customer;
import customer.repository.CustomerRepository;
import fraud.FraudClient;
import lombok.AllArgsConstructor;
import notification.NotificationClient;
import notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder().
                            firstName(customerRegistrationRequest.firstName()).
                            lastName(customerRegistrationRequest.lastName()).
                            email(customerRegistrationRequest.email()).
                            build();


        customerRepository.saveAndFlush(customer);

        var fraudCheckResult = fraudClient.getFraudCheckHistory(customer.getId()).getBody().isFraudster();

        if (fraudCheckResult) {
            throw new IllegalStateException("Fraud");
        }


        // TODO: Make it ASYNC using Kafka or RabbitMQ!
        notificationClient.sendNotification(new NotificationRequest(customer.getId(),
                                            customer.getEmail(),
                                            String.format("Hello %s, welcome to the app!", customer.getFirstName())
                ));

    }
}
