package co.edu.unbosque.viajes_global;

import co.edu.unbosque.viajes_global.util.MailSender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MailTest {

    @Test
    void testMail(){
        assertTrue(MailSender.sendWelcomeEmail("aespitiar@unbosque.edu.co", "Andrés", true));
    }

    @Test
    void testMailJohan(){
        assertTrue(MailSender.sendWelcomeEmail("sebasgomezb15@gmail.com", "Johan", true));
    }
}
