package com.hospital.diagnosis.domain.model;

public enum Pathology {
    CARDIAC(MedicalUnit.CARDIOLOGY),
    FRACTURE(MedicalUnit.TRAUMATOLOGY);

    private final MedicalUnit medicalUnit;

    Pathology(MedicalUnit medicalUnit) {
        this.medicalUnit = medicalUnit;
    }

    public MedicalUnit getMedicalUnit() {
        return medicalUnit;
    }
}