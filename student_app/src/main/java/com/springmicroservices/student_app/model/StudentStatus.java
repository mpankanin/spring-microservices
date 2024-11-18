package com.springmicroservices.student_app.model;

public enum StudentStatus {
    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    private final String status;

    StudentStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

    public static StudentStatus fromString(String status) {
        for (StudentStatus studentStatus : StudentStatus.values()) {
            if (studentStatus.status.equalsIgnoreCase(status)) {
                return studentStatus;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + status);
    }

}
