package org.iti.app_tests;

import org.iti.app.Employee;
import org.iti.app.EmployeeOperations;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeTests {


    @Mock
    Employee employee;

    @Test
    void testEmailDomains() {
        // stubs
        when(employee.getEmail()).thenReturn("ahmed.mohamed@iti.org").thenReturn("kareem.mohamed@iti.org");

        assertTrue(new EmployeeOperations().isValidEmailDomain(employee.getEmail()));

        //Spy
        verify(employee, atLeast(1)).getEmail();
    }

    @Test
    void testName() {
        when(employee.getName()).thenReturn("Abdulallah");
        String name = employee.getName();
        assertNotNull(name);
        assertFalse(name.isBlank());
        assertTrue(name.startsWith("A"));
        verify(employee, times(1)).getName();
    }

}
