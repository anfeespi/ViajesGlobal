package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class NotificationMethodDTO {
    private Integer idNotificationMethod;

    private String notificationMethod;

    public NotificationMethodDTO() {

    }

    public NotificationMethodDTO(Integer idNotificationMethod, String notificationMethod) {
        this.idNotificationMethod = idNotificationMethod;
        this.notificationMethod = notificationMethod;
    }

    public Integer getIdNotificationMethod() {
        return idNotificationMethod;
    }

    public void setIdNotificationMethod(Integer idNotificationMethod) {
        this.idNotificationMethod = idNotificationMethod;
    }

    public String getNotificationMethod() {
        return notificationMethod;
    }

    public void setNotificationMethod(String notificationMethod) {
        this.notificationMethod = notificationMethod;
    }
}
