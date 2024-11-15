package co.edu.unbosque.viajes_global.util;

import co.edu.unbosque.viajes_global.dto.ExcursionDiscountDTO;
import co.edu.unbosque.viajes_global.dto.FlightDiscountDTO;
import co.edu.unbosque.viajes_global.dto.HotelDiscountDTO;
import co.edu.unbosque.viajes_global.dto.NotificationMethods;
import co.edu.unbosque.viajes_global.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EventManager implements EventObserver {
    private final ArrayList<User> userObserver = new ArrayList<>();

    @Override
    public void newHotelDiscount(HotelDiscountDTO discountDTO) {
        userObserver.forEach(u -> u.getUserNotificationMethods().
                forEach(n -> {
                    if (n.getIdNotificationMethod() == NotificationMethods.SMS.ordinal()) {
                        SMSSender.sendDiscountSMS(u.getUserPhone(), u.getUserNames(), "Hoteles", (discountDTO.discount() * 100) + "");
                    } else if (n.getIdNotificationMethod() == NotificationMethods.EMAIL.ordinal()) {
                        MailSender.sendDiscountEmail(u.getUserEmail(), u.getUserNames(), "Hoteles", (discountDTO.discount() * 100) + "");
                    }
                })
        );
    }

    @Override
    public void newFlightDiscount(FlightDiscountDTO discountDTO) {
        userObserver.forEach(u ->
                u.getUserNotificationMethods().forEach(n -> {
                    if (n.getIdNotificationMethod() == NotificationMethods.SMS.ordinal()) {
                        SMSSender.sendDiscountSMS(u.getUserPhone(), u.getUserNames(), "Vuelos", (discountDTO.discount() * 100) + "");
                    } else if (n.getIdNotificationMethod() == NotificationMethods.EMAIL.ordinal()) {
                        MailSender.sendDiscountEmail(u.getUserEmail(), u.getUserNames(), "Vuelos", (discountDTO.discount() * 100) + "");
                    }
                })
        );
    }

    @Override
    public void newExcursionDiscount(ExcursionDiscountDTO discountDTO) {
        userObserver.forEach(u ->
                u.getUserNotificationMethods().forEach(n -> {
                    if (n.getIdNotificationMethod() == NotificationMethods.SMS.ordinal()) {
                        SMSSender.sendDiscountSMS(u.getUserPhone(), u.getUserNames(), "Excursiones", (discountDTO.discount() * 100) + "");
                    } else if (n.getIdNotificationMethod() == NotificationMethods.EMAIL.ordinal()) {
                        MailSender.sendDiscountEmail(u.getUserEmail(), u.getUserNames(), "Excursiones", (discountDTO.discount() * 100) + "");
                    }
                })
        );
    }

    public void subscribe(User user) {
        userObserver.add(user);
    }

    public void unsubscribe(User user) {
        userObserver.remove(user);
    }
}
