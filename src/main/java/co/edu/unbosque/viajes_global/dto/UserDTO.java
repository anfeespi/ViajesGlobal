package co.edu.unbosque.viajes_global.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record UserDTO(@Length(min = 1, max = 10, message = "The document isn't valid") String idUser,
                      @Length(max = 40, message = "The name is too long") String userNames,
                      @Length(max = 40, message = "The lastnames are too long") String userLastNames,
                      @Length(max = 100, message = "") @Email(message = "The email isn't valid") String userEmail,
                      @Length(min = 8, max = 40, message = "Something went wrong with your password") String userPassword,
                      @Length(max = 40, message = "The address is too long") String userAddress,
                      @Length(max = 15, message = "The phone number is too long") String userPhone,
                      @Length(max = 10, message = "The date is malformed, use the format dd/MM/YYYY") String userBirthday,
                      @NotNull(message = "Select your document type") Integer userDocumentType,
                      @NotNull(message = "Select the gender") Integer userGender,
                      @NotNull(message = "Select ur notifications methods")
                      @Size(min = 3, max = 3, message = "The standard of notifications aren't established") Integer[] notificationMethod) {
}
