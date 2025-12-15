package com.hospital.diagnosis.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PathologyTest {

    @Test
    void cardiac_pathology_should_map_to_cardiology_unit() {
        MedicalUnit unit = Pathology.CARDIAC.getMedicalUnit();

        assertThat(unit).isEqualTo(MedicalUnit.CARDIOLOGY);
    }

    @Test
    void fracture_pathology_should_map_to_traumatology_unit() {
        MedicalUnit unit = Pathology.FRACTURE.getMedicalUnit();

        assertThat(unit).isEqualTo(MedicalUnit.TRAUMATOLOGY);
    }
}