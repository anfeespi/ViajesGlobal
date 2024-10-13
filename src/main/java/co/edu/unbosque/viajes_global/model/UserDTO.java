package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class UserDTO {
    private String idUser;

    private String userNames;

    private String userLastNames;

    private String userEmail;

    private String userPassword;

    private String userAddress;

    private String userPhone;

    private String userBirthday;

    private Integer userDocumentType;

    private Integer userGender;

    private Integer[] notificationMethod;

    public UserDTO() {

    }

    public UserDTO(String idUser, String userNames, String userLastNames, String userEmail, String userPassword, String userAddress, String userPhone, String userBirthday, Integer userDocumentType, Integer userGender) {
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

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserDocumentType() {
        return userDocumentType;
    }

    public void setUserDocumentType(Integer userDocumentType) {
        this.userDocumentType = userDocumentType;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer[] getNotificationMethod() {
        return notificationMethod;
    }

    public void setNotificationMethod(Integer[] notificationMethod) {
        this.notificationMethod = notificationMethod;
    }
}
