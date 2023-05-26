package io.pan.cookbook.validation.api;

import io.pan.cookbook.validation.dto.Period;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeriodController {

    @PostMapping("/period")
    public String period(@RequestBody @Valid Period period) {
        return "Period is valid";
    }

}
