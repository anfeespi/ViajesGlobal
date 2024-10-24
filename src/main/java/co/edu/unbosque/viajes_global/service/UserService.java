package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.NotificationMethodDTO;
import co.edu.unbosque.viajes_global.dto.UserDTO;
import co.edu.unbosque.viajes_global.model.*;
import co.edu.unbosque.viajes_global.repository.UserRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import co.edu.unbosque.viajes_global.util.MailSender;
import co.edu.unbosque.viajes_global.util.SMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final DataMapper dataMapper;

    public UserService(){
        dataMapper = new DataMapper();
    }

    public boolean registerUser(UserDTO dto, Integer[] notificationMethod) {
        User entity = dataMapper.userDTOToUser(dto);

        NotificationMethodBuilder builder = new NotificationMethodBuilder();

        if(notificationMethod[NotificationMethods.SMS.ordinal()] == 1){
            builder.setSmsNotification(true);
            SMSSender.sendWelcomeSMS(entity.getUserPhone(), entity.getUserNames(), entity.getUserGender().getIdGender() % 2 == 1);
        }

        if(notificationMethod[NotificationMethods.EMAIL.ordinal()] == 1){
            builder.setEmailNotification(true);
            MailSender.sendWelcomeEmail(entity.getUserEmail(), entity.getUserNames(), entity.getUserGender().getIdGender() % 2 == 1);
        }

        if(notificationMethod[NotificationMethods.PUSH.ordinal()] == 1){
            builder.setPushNotification(true);
        }

        NotificationMethodDTO newNotificationMethod = builder.build();

        Set<NotificationMethod> userNotificationMethods = dataMapper.notificationMethodDTOToNotificationMethod(newNotificationMethod);

        entity.setUserNotificationMethods(userNotificationMethods);

        userRepository.save(entity);
        return true;
    }
}
