package com.example.chatgpt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");

        employeeRepository.save(employee);

        Assertions.assertNotNull(employee.getId(), "Employee ID should not be null");
    }


    @Test
    public void testFindAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Doe");

        Employee employee2 = new Employee();
        employee2.setFirstName("Jane");
        employee2.setLastName("Doe");

        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.flush();

        List<Employee> employees = employeeRepository.findAll();

        Assertions.assertEquals(2, employees.size());
        Assertions.assertTrue(employees.contains(employee1));
        Assertions.assertTrue(employees.contains(employee2));
    }
}
