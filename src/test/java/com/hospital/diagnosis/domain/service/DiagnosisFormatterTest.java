package com.hospital.diagnosis.domain.service;

import com.hospital.diagnosis.domain.model.HealthIndex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiagnosisFormatterTest {

    private DiagnosisFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new DiagnosisFormatter();
    }

    @Test
    void should_format_single_cardiology_unit() {
        HealthIndex healthIndex = HealthIndex.of(33);

        String result = formatter.format(healthIndex);

        assertThat(result).isEqualTo("Cardiologie");
    }

    @Test
    void should_format_single_traumatology_unit() {
        HealthIndex healthIndex = HealthIndex.of(55);

        String result = formatter.format(healthIndex);

        assertThat(result).isEqualTo("Traumatologie");
    }

    @Test
    void should_format_multiple_units_with_comma() {
        HealthIndex healthIndex = HealthIndex.of(15);

        String result = formatter.format(healthIndex);

        assertThat(result).contains("Cardiologie").contains("Traumatologie");
    }

    @Test
    void should_return_empty_string_when_no_pathology() {
        HealthIndex healthIndex = HealthIndex.of(7);

        String result = formatter.format(healthIndex);

        assertThat(result).isEmpty();
    }
}