package io.pan.cookbook.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.pan.cookbook.validation.dto.Period;

import java.time.LocalDate;

public class TestUtil {

    public static Period consistentPeriod() {
        return new Period(
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2021, 1, 1)
        );
    }

    public static Period inconsistentPeriod() {
        return new Period(
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2020, 1, 1)
        );
    }

    public static String asJson(Object object) {
        try {
            return new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
