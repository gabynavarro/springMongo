package com.mongoLibreria.libreria.model.Entity;

public enum ListRole {

    USER("USER"),
    ADMIN("ADMIN"),
    PROFESSIONAL("PROFESSIONAL"),
    PATIENT("PATIENT");

    private static final String ROLE_PREFIX = "ROLE_";
    private final String name;

    ListRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullRoleName() {
        return ROLE_PREFIX + name;
    }
}
