package co.edu.unbosque.viajes_global.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class UserDTO {
    @Length(min = 1, max = 10, message = "The document isn't valid")
    private String idUser;

    @Length(max = 40, message = "The name is too long")
    private String userNames;

    @Length(max = 40, message = "The lastnames are too long")
    private String userLastNames;

    @Length(max = 100, message = "")
    @Email(message = "The email isn't valid")
    private String userEmail;

    @Length(min = 8, max = 40, message = "Something went wrong with your password")
    private String userPassword;

    @Length(max = 40, message = "The address is too long")
    private String userAddress;

    @Length(max = 11, message = "The phone number is too long")
    private String userPhone;

    @Length(max = 8, message = "The date is malformed, use the format dd/MM/YYYY")
    private String userBirthday;

    @NotNull(message = "Select your document type")
    private Integer userDocumentType;

    @NotNull(message = "Select the gender")
    private Integer userGender;

    @NotNull(message = "Select ur notifications methods")
    @Size(min = 3, max = 3, message = "The standard of notifications aren't established")
    private Integer[] notificationMethod;

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
