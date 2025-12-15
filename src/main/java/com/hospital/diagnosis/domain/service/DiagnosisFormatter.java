package com.hospital.diagnosis.domain.service;

import com.hospital.diagnosis.domain.model.HealthIndex;
import com.hospital.diagnosis.domain.model.MedicalUnit;
import com.hospital.diagnosis.domain.model.Pathology;

import java.util.stream.Collectors;

public class DiagnosisFormatter {

    public String format(HealthIndex healthIndex) {
        return healthIndex.getPathologies().stream()
                .map(Pathology::getMedicalUnit)
                .map(MedicalUnit::getDisplayName)
                .collect(Collectors.joining(", "));
    }
}