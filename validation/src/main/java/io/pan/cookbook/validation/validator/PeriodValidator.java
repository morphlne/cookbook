package io.pan.cookbook.validation.validator;

import io.pan.cookbook.validation.dto.Period;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PeriodValidator implements ConstraintValidator<ConsistentPeriod, Period> {

    @Override
    public boolean isValid(Period period, ConstraintValidatorContext context) {
        if (inconsistent(period)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    ConstraintMessage.PERIOD_INCONSISTENCY
            ).addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean inconsistent(Period period) {
        return period.getTo().isBefore(period.getFrom());
    }

}
