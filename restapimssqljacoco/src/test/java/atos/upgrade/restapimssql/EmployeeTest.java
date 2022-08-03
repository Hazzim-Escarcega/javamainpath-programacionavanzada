package atos.upgrade.restapimssql;

import atos.upgrade.restapimssql.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class EmployeeTest {
   Employee mockEmployee;

    @Test
    @DisplayName("Employee has first name")
    public void getEmployeeFirstName(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        Assertions.assertNotNull(mockEmployee.getFirstName());
        Assertions.assertEquals("Hazzim", mockEmployee.getFirstName());
    }
    @Test
    @DisplayName("Employee has last name")
    public void getEmployeeLastName(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        Assertions.assertNotNull(mockEmployee.getLastName());
        Assertions.assertEquals("Escarcega", mockEmployee.getLastName());
    }
    @Test
    @DisplayName("Employee has email")
    public void getEmployeeEmail(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        Assertions.assertNotNull(mockEmployee.getEmailId());
        Assertions.assertEquals("mail@mail.com", mockEmployee.getEmailId());
    }
    @Test
    @DisplayName("Employee has ID")
    public void getEmployeeID(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        Assertions.assertNotNull(mockEmployee.getId());
        Assertions.assertEquals(224, mockEmployee.getId());
    }
    @Test
    @DisplayName("Set employee email")
    public void setEmployeeEmail(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        mockEmployee.setEmailId("nuevomail@mail.com");
        Assertions.assertNotNull(mockEmployee.getEmailId());
        Assertions.assertEquals("nuevomail@mail.com", mockEmployee.getEmailId());
    }
    @Test
    @DisplayName("Set employee id")
    public void setEmployeeID(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        mockEmployee.setId(225);
        Assertions.assertNotNull(mockEmployee.getId());
        Assertions.assertEquals(225, mockEmployee.getId());

    }
    @Test
    @DisplayName("Set employee first name")
    public void setEmployeeFirstName(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        mockEmployee.setFirstName("Roberto");
        Assertions.assertNotNull(mockEmployee.getFirstName());
        Assertions.assertEquals("Roberto", mockEmployee.getFirstName());
    }
    @Test
    @DisplayName("Set employee last name")
    public void setEmployeeLastName(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        mockEmployee.setLastName("Martinez");
        Assertions.assertNotNull(mockEmployee.getLastName());
        Assertions.assertEquals("Martinez", mockEmployee.getLastName());
    }
    @Test
    @DisplayName("Convert employee to String")
    public void employeeToString(){
        mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        String employees = mockEmployee.toString();
        Assertions.assertFalse(employees.isEmpty());
    }
}
