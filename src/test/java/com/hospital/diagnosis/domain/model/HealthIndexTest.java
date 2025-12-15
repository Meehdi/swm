package com.hospital.diagnosis.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class HealthIndexTest {

    @Test
    void should_identify_cardiac_pathology_when_multiple_of_three() {
        HealthIndex healthIndex = HealthIndex.of(33);

        Set<Pathology> pathologies = healthIndex.getPathologies();

        assertThat(pathologies)
                .hasSize(1)
                .containsExactly(Pathology.CARDIAC);
    }

    @Test
    void should_identify_fracture_pathology_when_multiple_of_five() {
        HealthIndex healthIndex = HealthIndex.of(55);

        Set<Pathology> pathologies = healthIndex.getPathologies();

        assertThat(pathologies)
                .hasSize(1)
                .containsExactly(Pathology.FRACTURE);
    }

    @Test
    void should_identify_both_pathologies_when_multiple_of_three_and_five() {
        HealthIndex healthIndex = HealthIndex.of(15);

        Set<Pathology> pathologies = healthIndex.getPathologies();

        assertThat(pathologies)
                .hasSize(2)
                .containsExactlyInAnyOrder(Pathology.CARDIAC, Pathology.FRACTURE);
    }
}