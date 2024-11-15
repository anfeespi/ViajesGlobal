package co.edu.unbosque.viajes_global.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class SMSSender {

    public static final String ACCOUNT_SID = "AC74e80a3054cfc43c9292b8034f8882c7";

    public static final String AUTH_TOKEN = "5c8884bd53c6e9ed77f20e2668bc4423";

    public static boolean sendWelcomeSMS(String phoneNumber, String username, boolean gender) {
        String msg = "¡Hey, " + username + " bienvenid" + (gender ? 'o' : 'a') + " a Viajes Global! ¡Prepárate para descubrir el mundo!" +
                "\n Has recibido este mensaje por haberte registrado en nuestra aplicación web";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber("+12029198284"),
                        msg)
                .create();

        return true;
    }

    public static boolean sendDiscountSMS(String phoneNumber, String username, String discountType, String info) {
        String msg = "¡Hey, " + username + ", hay un nuevo descuento en " + discountType + " al que deberías echarle un vistazo!\n" +
                info + " DE DESCUENTO!! \nViajes Global Colombia!";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber("+12029198284"),
                        msg)
                .create();

        return true;
    }

}
