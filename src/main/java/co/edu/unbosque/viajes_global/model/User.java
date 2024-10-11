package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "genero")
public class User {
    @Id
    @Column(name = "id_usuario", nullable = false, unique = true)
    private String idUser;

    @Column(name = "nombres_usuario")
    private String userNames;

    @Column(name = "apellidos_usuario")
    private String userLastNames;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "contrasena")
    private String userPassword;

    @Column(name = "direccion")
    private String userAddress;

    @Column(name = "celular")
    private String userPhone;

    @Column(name = "fecha_nacimiento")
    private Date userBirthday;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    private DocumentType userDocumentType;

    @ManyToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    private Gender userGender;

    @ManyToOne
    @JoinColumn(name = "id_medio_notificacion", referencedColumnName = "id_medio_notificacion")
    private NotificationMethod userNotificationMethod;

    public User() {

    }

    public User(String idUser, String userNames, String userLastNames, String userEmail, String userPassword, String userAddress, String userPhone, Date userBirthday, DocumentType userDocumentType, Gender userGender, NotificationMethod userNotificationMethod) {
        this.idUser = idUser;
        this.userNames = userNames;
        this.userLastNames = userLastNames;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userBirthday = userBirthday;
        this.userDocumentType = userDocumentType;
        this.userGender = userGender;
        this.userNotificationMethod = userNotificationMethod;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public String getUserLastNames() {
        return userLastNames;
    }

    public void setUserLastNames(String userLastNames) {
        this.userLastNames = userLastNames;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public DocumentType getUserDocumentType() {
        return userDocumentType;
    }

    public void setUserDocumentType(DocumentType userDocumentType) {
        this.userDocumentType = userDocumentType;
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public NotificationMethod getUserNotificationMethod() {
        return userNotificationMethod;
    }

    public void setUserNotificationMethod(NotificationMethod userNotificationMethod) {
        this.userNotificationMethod = userNotificationMethod;
    }
}
