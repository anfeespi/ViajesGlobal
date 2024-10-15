package co.edu.unbosque.viajes_global.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class SMSSender {

    public static final String ACCOUNT_SID = "AC74e80a3054cfc43c9292b8034f8882c7";

    public static final String AUTH_TOKEN = "c58fe51bb29a9936242e89a25c5c970b";

    public static boolean sendWelcomeSMS(String phoneNumber, String username, boolean gender) {
        String msg = "¡Hey, "+username+" bienvenid"+ (gender ? 'o' : 'a') +" a Viajes Global! ¡Prepárate para descubrir el mundo!" +
                "\n Has recibido este mensaje por haberte registrado en nuestra aplicación web";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber("+12029198284"),
                        msg)
                .create();

        return true;
    }

}
