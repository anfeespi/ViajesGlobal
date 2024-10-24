package co.edu.unbosque.viajes_global.util;

import co.edu.unbosque.viajes_global.dto.NotificationMethodDTO;
import co.edu.unbosque.viajes_global.dto.TouristPlaceDTO;
import co.edu.unbosque.viajes_global.dto.UserDTO;
import co.edu.unbosque.viajes_global.exception.DateException;
import co.edu.unbosque.viajes_global.exception.DocumentTypeNotFound;
import co.edu.unbosque.viajes_global.exception.GenderNotFound;
import co.edu.unbosque.viajes_global.model.*;
import co.edu.unbosque.viajes_global.repository.DocumentTypeRepository;
import co.edu.unbosque.viajes_global.repository.GenderRepository;
import co.edu.unbosque.viajes_global.repository.NotificationMethodRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        Date userBirthday;

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
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.SMS.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.SMS.ordinal() + 1).get() : null);

        if(dto.isEmailNotification())
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.EMAIL.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.EMAIL.ordinal() + 1).get() : null);

        if(dto.isPushNotification())
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.PUSH.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.PUSH.ordinal() + 1).get() : null);

        return notificationMethods;
    }

    public TouristPlace touristPlaceDTOToTouristPlace(TouristPlaceDTO dto){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(dto, TouristPlace.class);
    }

    public TouristPlaceDTO touristPlaceToTouristPlaceDTO(TouristPlace dto){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(dto, TouristPlaceDTO.class);
    }
}
