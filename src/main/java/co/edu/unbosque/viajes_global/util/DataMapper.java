package co.edu.unbosque.viajes_global.util;

import co.edu.unbosque.viajes_global.dto.*;
import co.edu.unbosque.viajes_global.exception.DateException;
import co.edu.unbosque.viajes_global.exception.DocumentTypeNotFound;
import co.edu.unbosque.viajes_global.exception.GenderNotFound;
import co.edu.unbosque.viajes_global.model.*;
import co.edu.unbosque.viajes_global.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

    @Autowired
    private FlightTypeRepository flightTypeRepository;

    @Autowired
    private TouristPlaceRepository touristPlaceRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    public User userDTOToUser(UserDTO dto) {
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
        if (userDocumentType == null) {
            throw new DocumentTypeNotFound();
        }

        Gender userGender = genderRepository.findById(dto.getUserGender()).isPresent() ? genderRepository.findById(dto.getUserGender()).get() : null;

        if (userGender == null) {
            throw new GenderNotFound();
        }

        return new User(idUser, userNames, userLastNames, userEmail, userPassword, userAddress, userPhone, userBirthday, userDocumentType, userGender);
    }

    public UserDTO userToUserDTO(User user) {
        String idUser = user.getIdUser();
        String userNames = user.getUserNames();
        String userLastNames = user.getUserLastNames();
        String userEmail = user.getUserEmail();
        String userPassword = user.getUserPassword();
        String userAddress = user.getUserAddress();
        String userPhone = user.getUserPhone();
        String userBirthday = user.getUserBirthday().toString();
        Integer userDocumentType = user.getUserDocumentType().getIdDocumentType();
        Integer userGender = user.getUserGender().getIdGender();
        Integer[] notificationMethods = notificationMethodToNotificationMethodDTO(user.getUserNotificationMethods());
        UserDTO mapped = new UserDTO(idUser, userNames, userLastNames, userEmail, userPassword, userAddress, userPhone, userBirthday, userDocumentType, userGender);
        mapped.setNotificationMethod(notificationMethods);
        return mapped;
    }

    public Set<NotificationMethod> notificationMethodDTOToNotificationMethod(NotificationMethodDTO dto) {
        HashSet<NotificationMethod> notificationMethods = new HashSet<>();

        if (dto.isSmsNotification())
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.SMS.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.SMS.ordinal() + 1).get() : null);

        if (dto.isEmailNotification())
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.EMAIL.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.EMAIL.ordinal() + 1).get() : null);

        if (dto.isPushNotification())
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.PUSH.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.PUSH.ordinal() + 1).get() : null);

        return notificationMethods;
    }

    public Integer[] notificationMethodToNotificationMethodDTO(Set<NotificationMethod> notificationMethods) {
        Integer[] notificationMethodDTO = new Integer[3];
        Arrays.fill(notificationMethodDTO, 0);
        notificationMethods.forEach(e -> notificationMethodDTO[e.getIdNotificationMethod() - 1] = 1);
        return notificationMethodDTO;
    }

    public TouristPlaceDTO touristPlaceToTouristPlaceDTO(TouristPlace dto) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(dto, TouristPlaceDTO.class);
    }

    public Flight flightDTOToFlight(FlightDTO dto) throws ParseException {
        FlightType flightType = flightTypeRepository.findById(dto.getFlightType()).get();
        TouristPlace touristPlaceOrigin = touristPlaceRepository.findById(dto.getTouristPlaceOrigin()).get();
        TouristPlace touristPlaceDestination = touristPlaceRepository.findById(dto.getTouristPlaceDestination()).get();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateBegin = format.parse(dto.getDateBegin());
        Date dateEnd = format.parse(dto.getDateEnd());
        Integer passengerNumber = dto.getPassengersNumber();
        Airline airline = airlineRepository.findById(dto.getAirline()).get();
        Double baseFee = dto.getBaseFee();
        Double taxes = dto.getTaxes();
        Double charges = dto.getCharges();
        Double total = dto.getTotal();

        return new Flight(flightType, touristPlaceOrigin, touristPlaceDestination, dateBegin, dateEnd, passengerNumber, airline, baseFee, taxes, charges, total);
    }

    public FlightDTO flightToFlightDTO(Flight entity) {
        Integer idFlight = entity.getIdFlight();
        Integer flightType = entity.getFlightType().getIdFlightType();
        Integer touristPlaceOrigin = entity.getTouristPlaceOrigin().getIdTouristPlace();
        Integer touristPlaceDestination = entity.getTouristPlaceDestination().getIdTouristPlace();
        String dateBegin = entity.getDateBegin().toString();
        String dateEnd = entity.getDateEnd().toString();
        Integer passengersNumber = entity.getPassengersNumber();
        Integer airline = entity.getAirline().getIdAirline();
        Double baseFee = entity.getBaseFee();
        Double taxes = entity.getTaxes();
        Double charges = entity.getCharges();
        Double total = entity.getTotal();

        return new FlightDTO(idFlight, flightType, touristPlaceOrigin, touristPlaceDestination, dateBegin, dateEnd, passengersNumber, airline, baseFee, taxes, charges, total);
    }
}
