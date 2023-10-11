package com.carwash.model.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

