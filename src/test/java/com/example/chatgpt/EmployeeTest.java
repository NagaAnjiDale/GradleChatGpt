package com.example.chatgpt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class EmployeeTest {

    @Test
     void testEmployeeObject() {
        Employee emp = new Employee("John", "Doe", "johndoe@example.com");
        Assertions.assertEquals("John", emp.getFirstName());
        Assertions.assertEquals("Doe", emp.getLastName());
        Assertions.assertEquals("johndoe@example.com", emp.getEmail());
    }
}