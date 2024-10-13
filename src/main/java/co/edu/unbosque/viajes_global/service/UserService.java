package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.model.*;
import co.edu.unbosque.viajes_global.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataMapper dataMapper;

    public UserService(){

    }

    public boolean registerUser(UserDTO dto, Integer[] notificationMethod) {
        User entity = dataMapper.userDTOToUser(dto);

        NotificationMethodBuilder builder = new NotificationMethodBuilder();

        if(notificationMethod[0] == 1){
            builder.setSmsNotification(true);
        }

        if(notificationMethod[1] == 1){
            builder.setEmailNotification(true);
        }

        if(notificationMethod[2] == 1){
            builder.setPushNotification(true);
        }

        NotificationMethodDTO newNotificationMethod = builder.build();

        Set<NotificationMethod> userNotificationMethods = dataMapper.notificationMethodDTOToNotificationMethod(newNotificationMethod);

        entity.setUserNotificationMethods(userNotificationMethods);

        userRepository.save(entity);
        return true;
    }
}
