package com.example.mobilelele.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.YearMonth;

public class YearInPastOrPresentValidator implements ConstraintValidator<YearInPastOrPresent, Integer> {

    int minYear;

    @Override
    public void initialize(YearInPastOrPresent constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.minYear = constraintAnnotation.minYear();


    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }
        int nowYear = YearMonth.now().getYear();
        return value >= this.minYear && value <= nowYear;
    }
}
