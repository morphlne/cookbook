package io.pan.cookbook.validation.validator;

import io.pan.cookbook.validation.dto.Period;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeriodValidatorTest extends ValidatorTest {

    @Test
    public void consistentPeriod_validate_noErrors() {
        var period = new Period(
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2021, 1, 1)
        );

        var errors = validationResult(period);

        assertTrue(errors.getAllErrors().isEmpty());
    }

    @Test
    public void inconsistentPeriod_validate_expectedError() {
        var period = new Period(
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2020, 1, 1)
        );

        var errors = validationResult(period);

        assertAll(
                () -> assertEquals(1, errors.getAllErrors().size()),
                () -> assertEquals(
                        ConstraintMessage.PERIOD_INCONSISTENCY,
                        errors.getAllErrors().get(0).getDefaultMessage()
                )
        );
    }

}
