package io.pan.cookbook.validation.dto;

import io.pan.cookbook.validation.validator.ConsistentPeriod;

import java.time.LocalDate;

@ConsistentPeriod
public class Period {

    private LocalDate from;
    private LocalDate to;

    public Period() {}

    public Period(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

}
