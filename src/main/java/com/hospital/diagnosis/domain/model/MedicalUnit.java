package com.hospital.diagnosis.domain.model;

public enum MedicalUnit {

    CARDIOLOGY("Cardiologie"),
    TRAUMATOLOGY("Traumatologie");

    /*
    I added the displayName property to respect the
     specs return value "Cardiologie" and "Traumatologie"
     */
    private final String displayName;

    MedicalUnit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
