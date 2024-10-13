package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.exception.DateException;
import co.edu.unbosque.viajes_global.exception.DocumentTypeNotFound;
import co.edu.unbosque.viajes_global.exception.GenderNotFound;
import co.edu.unbosque.viajes_global.model.*;
import co.edu.unbosque.viajes_global.repository.DocumentTypeRepository;
import co.edu.unbosque.viajes_global.repository.GenderRepository;
import co.edu.unbosque.viajes_global.repository.NotificationMethodRepository;
import co.edu.unbosque.viajes_global.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class DataMapper {
    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private NotificationMethodRepository notificationMethodRepository;

    public User userDTOToUser(UserDTO dto){
        String idUser = dto.getIdUser();
        String userNames = dto.getUserNames();
        String userLastNames = dto.getUserLastNames();
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userAddress = dto.getUserAddress();
        String userPhone = dto.getUserPhone();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date userBirthday = null;

        try {
            userBirthday = format.parse(dto.getUserBirthday());
        } catch (ParseException e) {
            throw new DateException();
        }

        DocumentType userDocumentType = documentTypeRepository.findById(dto.getUserDocumentType()).isPresent() ? documentTypeRepository.findById(dto.getUserDocumentType()).get() : null;
        if(userDocumentType == null){
            throw new DocumentTypeNotFound();
        }

        Gender userGender = genderRepository.findById(dto.getUserGender()).isPresent() ? genderRepository.findById(dto.getUserGender()).get() : null;

        if(userGender == null){
            throw new GenderNotFound();
        }

        return new User(idUser, userNames, userLastNames, userEmail, userPassword, userAddress, userPhone, userBirthday, userDocumentType, userGender);
    }

    public Set<NotificationMethod> notificationMethodDTOToNotificationMethod(NotificationMethodDTO dto){
        HashSet<NotificationMethod> notificationMethods = new HashSet<>();

        if(dto.isSmsNotification())
            notificationMethods.add(notificationMethodRepository.findById(1).get());

        if(dto.isEmailNotification())
            notificationMethods.add(notificationMethodRepository.findById(2).get());

        if(dto.isPushNotification())
            notificationMethods.add(notificationMethodRepository.findById(3).get());

        return notificationMethods;
    }
}
