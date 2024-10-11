package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medio_notificacion")
public class NotificationMethod {
    @Id
    @Column(name = "id_medio_notificacion", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificationMethod;

    @Column(name = "medio_notificacion")
    private String notificationMethod;

    public NotificationMethod() {

    }

    public NotificationMethod(Integer idNotificationMethod, String notificationMethod) {
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
