package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "medio_notificacion")
public class NotificationMethod {
    @Id
    @Column(name = "id_medio_notificacion", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificationMethod;

    @Column(name = "medio_notificacion")
    private String notificationMethod;

    @ManyToMany(mappedBy = "userNotificationMethods")
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
