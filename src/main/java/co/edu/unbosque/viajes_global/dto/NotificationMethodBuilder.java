package co.edu.unbosque.viajes_global.dto;

public class NotificationMethodBuilder {
    private boolean smsNotification;
    private boolean emailNotification;
    private boolean pushNotification;

    public NotificationMethodBuilder() {
        this.smsNotification = false;
        this.emailNotification = false;
        this.pushNotification = false;
    }

    public NotificationMethodBuilder setSmsNotification(boolean smsNotification) {
        this.smsNotification = smsNotification;
        return this;
    }

    public NotificationMethodBuilder setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
        return this;
    }

    public NotificationMethodBuilder setPushNotification(boolean pushNotification) {
        this.pushNotification = pushNotification;
        return this;
    }

    public NotificationMethodDTO build() {
        return new NotificationMethodDTO(smsNotification, emailNotification, pushNotification);
    }
}
