package com.example.hdiary.validation.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isBlank()) {
            return false;
        }
        return password.length() >= 8
                && password.matches(".*\\d.*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }
}