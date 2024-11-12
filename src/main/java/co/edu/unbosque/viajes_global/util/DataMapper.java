package co.edu.unbosque.viajes_global.util;

import co.edu.unbosque.viajes_global.dto.*;
import co.edu.unbosque.viajes_global.exception.*;
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

    @Autowired
    private HotelDetailRepository hotelDetailRepository;

    @Autowired
    private FlightDetailRepository flightDetailRepository;

    @Autowired
    private ExcursionDetailRepository excursionDetailRepository;

    @Autowired
    private UserRepository userRepository;

    public User userDTOToUser(UserDTO dto) {
        String idUser = dto.idUser();
        String userNames = dto.userNames();
        String userLastNames = dto.userLastNames();
        String userEmail = dto.userEmail();
        String userPassword = dto.userPassword();
        String userAddress = dto.userAddress();
        String userPhone = dto.userPhone();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date userBirthday;

        try {
            userBirthday = format.parse(dto.userBirthday());
        } catch (ParseException e) {
            throw new DateException();
        }

        DocumentType userDocumentType = documentTypeRepository.findById(dto.userDocumentType()).isPresent() ? documentTypeRepository.findById(dto.userDocumentType()).get() : null;
        if (userDocumentType == null) {
            throw new DocumentTypeNotFound();
        }

        Gender userGender = genderRepository.findById(dto.userGender()).isPresent() ? genderRepository.findById(dto.userGender()).get() : null;

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
        return new UserDTO(idUser, userNames, userLastNames, userEmail, userPassword, userAddress, userPhone, userBirthday, userDocumentType, userGender, notificationMethods);
    }

    public Set<NotificationMethod> notificationMethodDTOToNotificationMethod(NotificationMethodDTO dto) {
        HashSet<NotificationMethod> notificationMethods = new HashSet<>();

        if (dto.smsNotification())
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.SMS.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.SMS.ordinal() + 1).get() : null);

        if (dto.emailNotification())
            notificationMethods.add(notificationMethodRepository.findById(NotificationMethods.EMAIL.ordinal() + 1).isPresent() ? notificationMethodRepository.findById(NotificationMethods.EMAIL.ordinal() + 1).get() : null);

        if (dto.pushNotification())
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
        FlightType flightType = flightTypeRepository.findById(dto.flightType()).get();
        TouristPlace touristPlaceOrigin = touristPlaceRepository.findById(dto.touristPlaceOrigin()).get();
        TouristPlace touristPlaceDestination = touristPlaceRepository.findById(dto.touristPlaceDestination()).get();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateBegin = format.parse(dto.dateBegin());
        Date dateEnd = format.parse(dto.dateEnd());
        Integer passengerNumber = dto.passengersNumber();
        Airline airline = airlineRepository.findById(dto.airline()).get();
        Double baseFee = dto.baseFee();
        Double taxes = dto.taxes();
        Double charges = dto.charges();
        Double total = dto.total();

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

    public PackageDetail packageDetailDTOToPackageDetail(PackageDetailDTO dto) throws UserNotFoundException {
        User user;
        if (userRepository.findById(dto.user()).isPresent())
            user = userRepository.findById(dto.user()).get();
        else
            throw new UserNotFoundException();

        Double totalPrice = 0.0;
        Set<HotelDetail> hotelDetails = new HashSet<>();
        for (Integer hotel : dto.hotelDetail()) {
            if (hotelDetailRepository.findById(hotel).isPresent()) {
                hotelDetails.add(hotelDetailRepository.findById(hotel).get());
                totalPrice += hotelDetailRepository.findById(hotel).get().getTotalValue();
            } else
                throw new ElementNotPresentException();
        }

        Set<FlightDetail> flightDetails = new HashSet<>();
        for (Integer flight : dto.flightDetail()) {
            if (flightDetailRepository.findById(flight).isPresent()) {
                flightDetails.add(flightDetailRepository.findById(flight).get());
                totalPrice += flightDetailRepository.findById(flight).get().getFlight().getTotal();
            } else
                throw new ElementNotPresentException();
        }


        Set<ExcursionDetail> excursionDetails = new HashSet<>();
        for (Integer excursion : dto.excursionDetail()) {
            if (excursionDetailRepository.findById(excursion).isPresent()) {
                excursionDetails.add(excursionDetailRepository.findById(excursion).get());
                totalPrice += excursionDetailRepository.findById(excursion).get().getTotalValue();
            } else
                throw new ElementNotPresentException();
        }

        PackageDetail packageDetail = new PackageDetail(user);
        packageDetail.setHotelDetail(hotelDetails);
        packageDetail.setFlightDetail(flightDetails);
        packageDetail.setExcursionDetail(excursionDetails);
        packageDetail.setTotalPrice(totalPrice);
        return packageDetail;
    }

    public PackageDetailDTO packageDetailToPackageDetailDTO(PackageDetail packageDetail) {
        return new PackageDetailDTO(packageDetail.getPackageDetailId(), packageDetail.getUser().getIdUser(), packageDetail.getHotelDetail().stream().map(HotelDetail::getHotelDetailId).toList().toArray(new Integer[0]), packageDetail.getFlightDetail().stream().map(FlightDetail::getFlightDetailId).toList().toArray(new Integer[0]), packageDetail.getExcursionDetail().stream().map(ExcursionDetail::getExcursionDetailId).toList().toArray(new Integer[0]), packageDetail.getTotalPrice());
    }

    public HotelDTO hotelToHotelDTO(Hotel entity) {
        return new HotelDTO(entity.getIdHotel(), entity.getTouristPlace().getIdTouristPlace(), entity.getHotelName(), entity.getGuestsNumber(), entity.getTotalValue(), entity.getDetails());
    }

    public Hotel hotelDTOToHotel(HotelDTO dto) {
        if (touristPlaceRepository.existsById(dto.touristPlace())) {
            TouristPlace touristPlace = touristPlaceRepository.findById(dto.touristPlace()).get();
            return new Hotel(touristPlace, dto.hotelName(), dto.guestsNumber(), dto.totalValue(), dto.details());
        }
        throw new ElementNotPresentException();
    }

    public HotelDetailDTO hotelDetailToHotelDetailDTO(HotelDetail hotelDetail) {
        return new HotelDetailDTO(hotelDetail.getHotelDetailId(), hotelToHotelDTO(hotelDetail.getHotel()), hotelDetail.getBeginDate(), hotelDetail.getEndDate(), hotelDetail.getGuestNumber(), hotelDetail.getTotalValue());
    }

    public HotelDetail hotelDetailDTOToHotelDetail(HotelDetailDTO dto) {
        return new HotelDetail(hotelDTOToHotel(dto.hotel()), dto.beginDate(), dto.endDate(), dto.guestNumber(), dto.totalValue());
    }

    public ExcursionDTO excursionToExcursionDTO(Excursion entity) {
        return new ExcursionDTO(entity.getIdExcursion(), entity.getTouristPlace().getIdTouristPlace(), entity.getNameExcursion(), entity.getDescriptionExcursion(), entity.getPassengerPrice());
    }

    public Excursion excursionDTOToExcursion(ExcursionDTO dto) {
        if (touristPlaceRepository.existsById(dto.touristPlace())) {
            TouristPlace touristPlace = touristPlaceRepository.findById(dto.touristPlace()).get();
            return new Excursion(touristPlace, dto.nameExcursion(), dto.descriptionExcursion(), dto.passengerPrice());
        }
        throw new ElementNotPresentException();
    }

    public ExcursionDetailDTO excursionDetailToExcursionDetailDTO(ExcursionDetail entity) {
        return new ExcursionDetailDTO(entity.getExcursionDetailId(), excursionToExcursionDTO(entity.getExcursion()), entity.getGuestNumber(), entity.getTotalValue());
    }

    public ExcursionDetail excursionDetailDTOToExcursionDetail(ExcursionDetailDTO dto) {
        return new ExcursionDetail(excursionDTOToExcursion(dto.excursion()), dto.guestNumber(), dto.totalValue());
    }
}
