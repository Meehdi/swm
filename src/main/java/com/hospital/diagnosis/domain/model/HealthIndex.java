package com.hospital.diagnosis.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class HealthIndex {

    private final int value;

    private HealthIndex(int value) {
        this.value = value;
    }

    public static HealthIndex of(int value) {
        return new HealthIndex(value);
    }

    public Set<Pathology> getPathologies() {
        Set<Pathology> pathologies = new HashSet<>();

        if (value % 3 == 0 && value != 0) {
            pathologies.add(Pathology.CARDIAC);
        }

        if (value % 5 == 0 && value != 0) {
            pathologies.add(Pathology.FRACTURE);
        }

        return pathologies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthIndex that = (HealthIndex) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}