package com.example.educationalinstitutions.domain;

public enum Wait {
    confirmation("confirmation"), waiting("waiting");

    private String convertString;

    public String getConvertString() {
        return convertString;
    }

    public void setConvertString(String convertString) {
        this.convertString = convertString;
    }

    Wait(String convertString) {
        this.convertString = convertString;
    }
}
