package io.pan.cookbook.validation.validator;

import org.junit.jupiter.api.Test;

import static io.pan.cookbook.validation.TestUtil.consistentPeriod;
import static io.pan.cookbook.validation.TestUtil.inconsistentPeriod;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeriodValidatorTest extends ValidatorTest {

    @Test
    public void consistentPeriod_validate_noErrors() {
        var period = consistentPeriod();

        var errors = validationResult(period);

        assertTrue(errors.getAllErrors().isEmpty());
    }

    @Test
    public void inconsistentPeriod_validate_expectedError() {
        var period = inconsistentPeriod();

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
