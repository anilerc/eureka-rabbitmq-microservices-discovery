package notification.service;

import notification.NotificationRequest;
import notification.model.Notification;
import notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(NotificationRequest req) {
        var newNotification = Notification.builder().toCustomerId(req.toCustomerId()).
                toCustomerEmail(req.toCustomerEmail()).
                message(req.message())
                .sentAt(LocalDateTime.now())
                .sender("anilerc").build();

        notificationRepository.save(newNotification);
    }


}
