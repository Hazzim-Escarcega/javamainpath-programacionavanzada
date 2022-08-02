package atos.upgrade.restapimssql;

import atos.upgrade.restapimssql.controller.EmployeeController;
import atos.upgrade.restapimssql.exception.ResourceNotFoundException;
import atos.upgrade.restapimssql.model.Employee;
import atos.upgrade.restapimssql.repository.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoAppTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeController employeeController;

    @Test
    public void getUsersTest(){
        when(employeeController.getAllEmployees()).thenReturn(List.of(new Employee(224, "Hazzim", "Escarcega", "mail@mail.com")));
        assertEquals(1, employeeController.getAllEmployees().size());

    }
    @Test
    public void getUsersByIdTest() throws ResourceNotFoundException {

    }
    @Test
    public void addUserTest(){
        Employee employee = new Employee(222, "Hazzim", "Escarcega", "mail@mail.com");
        when(employeeController.createEmployee(employee)).thenReturn(employee);
        assertEquals(employee, employeeController.createEmployee(employee));

    }
    @Test
    @DisplayName("Delete user")
    public void deleteUsersByIdTest() throws ResourceNotFoundException {
        Employee employee = new Employee(222, "Hazzim", "Escarcega", "mail@mail.com");
        employeeController.deleteEmployee(employee.getId());
        verify(employeeController, times(1)).deleteEmployee(employee.getId());

    }




}
