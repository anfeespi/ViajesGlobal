package co.edu.unbosque.viajes_global;

import co.edu.unbosque.viajes_global.util.SMSSender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SMSTest {

    @Test
    void sendSMS(){
        System.out.println("SMS Test");
        assertTrue(SMSSender.sendWelcomeSMS("+573115214670", "Andrés", true));
    }
}
