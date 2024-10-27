package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.NotificationMethodBuilder;
import co.edu.unbosque.viajes_global.dto.NotificationMethodDTO;
import co.edu.unbosque.viajes_global.dto.NotificationMethods;
import co.edu.unbosque.viajes_global.dto.UserDTO;
import co.edu.unbosque.viajes_global.model.NotificationMethod;
import co.edu.unbosque.viajes_global.model.User;
import co.edu.unbosque.viajes_global.repository.UserRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import co.edu.unbosque.viajes_global.util.MailSender;
import co.edu.unbosque.viajes_global.util.SMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataMapper dataMapper;

    public UserService() {

    }

    public boolean registerUser(UserDTO dto, Integer[] notificationMethod) {
        User entity = dataMapper.userDTOToUser(dto);

        NotificationMethodBuilder builder = new NotificationMethodBuilder();

        if (notificationMethod[NotificationMethods.SMS.ordinal()] == 1) {
            builder.setSmsNotification(true);
            SMSSender.sendWelcomeSMS(entity.getUserPhone(), entity.getUserNames(), entity.getUserGender().getIdGender() % 2 == 1);
        }

        if (notificationMethod[NotificationMethods.EMAIL.ordinal()] == 1) {
            builder.setEmailNotification(true);
            MailSender.sendWelcomeEmail(entity.getUserEmail(), entity.getUserNames(), entity.getUserGender().getIdGender() % 2 == 1);
        }

        if (notificationMethod[NotificationMethods.PUSH.ordinal()] == 1) {
            builder.setPushNotification(true);
        }

        NotificationMethodDTO newNotificationMethod = builder.build();

        Set<NotificationMethod> userNotificationMethods = dataMapper.notificationMethodDTOToNotificationMethod(newNotificationMethod);

        entity.setUserNotificationMethods(userNotificationMethods);

        userRepository.save(entity);
        return true;
    }

    public String login(String email, String password) {
        List<UserDTO> users = ((List<User>) userRepository.findAll()).stream().map(dataMapper::userToUserDTO).toList();
        for (UserDTO user : users) {
            if (user.getUserPassword().equals(password) && user.getUserEmail().equals(email)) {
                return user.getIdUser();
            }
        }
        return "";
    }
}
