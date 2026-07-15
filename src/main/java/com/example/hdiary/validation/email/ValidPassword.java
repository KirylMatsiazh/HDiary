package com.example.hdiary.validation.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import java.lang.annotation.*;

@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Invalid password format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
