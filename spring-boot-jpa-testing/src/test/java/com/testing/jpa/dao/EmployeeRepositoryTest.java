package com.testing.jpa.dao;

import com.testing.jpa.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee(1L, "admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee2 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

    @Test
    public void testGetEmployee() {
        Employee employee = new Employee(2L, "admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee2 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee(22L, "admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        employeeRepository.delete(employee);
    }

    @Test
    public void findAllEmployees() {
        Employee employee = new Employee(11L, "admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        assertNotNull(employeeRepository.findAll());
    }

    @Test
    public void deleteByEmployeeIdTest() {
        Employee employee = new Employee(23L, "admin", "admin", "admin@gmail.com");
        Employee emp = employeeRepository.save(employee);
        employeeRepository.deleteById(emp.getId());
    }

}
