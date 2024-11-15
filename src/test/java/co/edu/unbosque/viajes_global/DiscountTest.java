package co.edu.unbosque.viajes_global;

import co.edu.unbosque.viajes_global.dto.HotelDiscountDTO;
import co.edu.unbosque.viajes_global.dto.UserDTO;
import co.edu.unbosque.viajes_global.model.User;
import co.edu.unbosque.viajes_global.service.DiscountService;
import co.edu.unbosque.viajes_global.util.DataMapper;
import co.edu.unbosque.viajes_global.util.EventManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiscountTest {
    @Autowired
    private EventManager eventManager;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private DataMapper dataMapper;

    private User toSubscribe;

    @BeforeEach
    void before() {
        String idUser = "12345678";
        String userNames = "andres";
        String userLastNames = "espitia";
        String userEmail = "aespitiar@unbosque.edu.co";
        String userPassword = "yuca3214.";
        String userAddress = "cra 12";
        String userPhone = "+573115214670";
        String userBirthday = "12/08/2005";
        Integer userDocumentType = 1;
        Integer userGender = 1;
        Integer[] notifications = {1, 1, 1};

        toSubscribe = dataMapper.userDTOToUser(new UserDTO(idUser, userNames, userLastNames, userEmail, userPassword, userAddress, userPhone, userBirthday, userDocumentType, userGender, notifications));

        eventManager.subscribe(toSubscribe);
    }

    @Test
    void testMail() {
        assertEquals(discountService.addHotelDiscount(new HotelDiscountDTO(123, 1, 0.6, true)),
                new HotelDiscountDTO(123, 1, 0.6, true));
    }
}
