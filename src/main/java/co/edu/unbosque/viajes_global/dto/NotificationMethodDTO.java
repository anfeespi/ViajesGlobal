package co.edu.unbosque.viajes_global.dto;

public class NotificationMethodDTO {
    private final boolean smsNotification;
    private final boolean emailNotification;
    private final boolean pushNotification;

    public NotificationMethodDTO(boolean smsNotification, boolean emailNotification, boolean pushNotification) {
        this.smsNotification = smsNotification;
        this.emailNotification = emailNotification;
        this.pushNotification = pushNotification;
    }

    public boolean isSmsNotification() {
        return smsNotification;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public boolean isPushNotification() {
        return pushNotification;
    }
}
