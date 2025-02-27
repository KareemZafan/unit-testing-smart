package org.iti.app;

public class EmployeeOperations {

    public boolean isValidEmailDomain(String email) {
        return email.endsWith("iti.org");
    }
}
