package fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isCustomerFraud(Long customerId) {
        // emulate that some external checks are done and we decided that user is not fraud.
        boolean isCustomerFraud = false;

        FraudCheckHistory newCheck = FraudCheckHistory.builder().
                customerId(customerId).
                isCustomerFraud(isCustomerFraud).
                createdAt(LocalDateTime.now())
                .build();

        fraudCheckHistoryRepository.save(newCheck);

        return isCustomerFraud;
    }



}
