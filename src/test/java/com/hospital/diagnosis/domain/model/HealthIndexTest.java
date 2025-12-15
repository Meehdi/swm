package com.hospital.diagnosis.domain.model;

import com.hospital.diagnosis.domain.exception.InvalidHealthIndexException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void should_throw_exception_when_health_index_is_negative(int invalidValue) {
        assertThatThrownBy(() -> HealthIndex.of(invalidValue))
                .isInstanceOf(InvalidHealthIndexException.class)
                .hasMessage("Health index must be positive");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7, 13, 17, 19})
    void should_return_empty_set_when_not_multiple_of_three_or_five(int value) {
        HealthIndex healthIndex = HealthIndex.of(value);

        Set<Pathology> pathologies = healthIndex.getPathologies();

        assertThat(pathologies).isEmpty();
    }

}