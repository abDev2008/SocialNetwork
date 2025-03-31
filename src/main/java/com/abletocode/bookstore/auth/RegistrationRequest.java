package com.abletocode.bookstore.auth;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RegistrationRequest {
    @NotEmpty(message = "Firstname is Mandatory")
    @NotBlank(message = "Firstname is Mandatory")
    private String firstname;
    @NotEmpty(message = "Lastname is Mandatory")
    @NotBlank(message = "Lastname is Mandatory")
    private String lastname;
    @NotEmpty(message = "Email is Mandatory")
    @NotBlank(message = "Email is Mandatory")
    @Email(message = "Email is not correctly formatted")
    private String email;
    @NotEmpty(message = "Password is Mandatory")
    @NotBlank(message = "Password is Mandatory")
    @Size(min = 8, max = 20, message = "Password length must be between 8 to 20")
    private String password;
}
