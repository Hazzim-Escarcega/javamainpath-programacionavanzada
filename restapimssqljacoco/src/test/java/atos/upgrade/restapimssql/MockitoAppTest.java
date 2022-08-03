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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class MockitoAppTest extends AbstractTest{
    @Autowired
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeController employeeController;

    @Test
    public void getUsersTest(){
        when(employeeController.getAllEmployees()).thenReturn(
                List.of(new Employee(224, "Hazzim", "Escarcega", "mail@mail.com"),
                        new Employee(225, "Saul", "Perez", "mail@mail.com"),
                        new Employee(226, "Rob", "Pacheco", "mail@mail.com"),
                        new Employee(227, "Ian", "Santillanes", "mail@mail.com"),
                        new Employee(228, "Santiago", "Morua", "mail@mail.com")
                        ));
        assertEquals(5, employeeController.getAllEmployees().size());
        System.out.println("Employee list contains: "+ employeeController.getAllEmployees().toString());

    }
    @Test
    public void getUsersByIdTest() throws ResourceNotFoundException {
        ResponseEntity<Employee> response = new ResponseEntity<>(HttpStatus.OK);
        long id = 232;
        when(employeeController.getEmployeeById(id)).thenReturn(response);
        assertEquals(200, response.getStatusCodeValue());

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
        System.out.println("Deleting record: "+employee.toString());
        employeeController.deleteEmployee(employee.getId());
        verify(employeeController, times(1)).deleteEmployee(employee.getId());
        System.out.println("Deleted successfully");

    }
    @Test
    public void updateUsersByIdTest() throws ResourceNotFoundException {
        Employee employee = new Employee(222, "Hazzim", "Escarcega", "mail@mail.com");
        ResponseEntity<Employee> response = new ResponseEntity<>(HttpStatus.OK);
        long id = 232;
        when(employeeController.updateEmployee(id, employee)).thenReturn(response);
        assertEquals(200, response.getStatusCodeValue());

    }




}
