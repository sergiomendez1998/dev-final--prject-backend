package com.example.finalprojectbackend.lab2you;

public class Lab2YouConstants {

    public static final String _LAB2YOU_REASON_CODE_UNEXPECTED_EXCEPTION = "there was an unexpected exception";
    public enum lab2YouErrorCodes {

        USER_ALREADY_EXISTS("The user already exists"),
        USER_NOT_FOUND("The user was not found"),

        EMAIL_NOT_SENT("The registration email was not sent"),

        USER_NOT_CREATED("The user was not created due to invalid data sent"),

        USER_NOT_UPDATED("The user was not updated"),

        USER_NOT_DELETED("The user was not deleted"),

        USER_NOT_AUTHENTICATED("The user was not authenticated"),
        ACTION_UNSUPPORTED("The action is not supported"),
        INVALID_DATA("The data sent is invalid"),
        EMAIL_ALREADY_EXISTS("The email already exists" +
                " please use another email address "+ " or contact the administrator for more details");

        String description;

        public String getDescription() {
            return this.description;
        }

        lab2YouErrorCodes(String description) {
            this.description = description;
        }
    }

    public enum lab2YouSuccessCodes {
        EMAIL_SENT("user created and the registration email was sent successfully"),
        USER_CREATED("The user was created successfully"),
        REGISTRATION_SUCCESS("User created successfully");

        String description;

        public String getDescription() {
            return this.description;
        }

        lab2YouSuccessCodes(String description) {
            this.description = description;
        }
    }

    public enum lab2YouRoles {
        ADMIN("admin"),
        USER("user"),
        ANALYST("analyst"),
        MEDICAL("medical"),
        TECHNICIAN("technician"),
        CENTRALIZER("centralizer");

        private String role;

        lab2YouRoles(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }

    }

    public enum lab2YouUserTypes {
        CUSTOMER("internal"),
        EMPLOYEE("external");
        private String userType;
        lab2YouUserTypes(String userType) {
            this.userType = userType;
        }

        public String getUserType() {
            return userType;
        }

    }

    public enum operationTypes {
        CREATE("CREATE"),
        UPDATE("UPDATE"),
        DELETE("DELETE"),
        READ("READ");
        private String operation;
        operationTypes(String operation) {
            this.operation = operation;
        }
        public String getOperationType() {
            return operation;
        }

    }

    public enum statusTypes {
        CREATED("Creado");

        String status;

        statusTypes(String status) {
            this.status = status;
        }

        public String getStatusType() {
            return status;
        }

    }

}
