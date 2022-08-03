package atos.upgrade.restapimssql;

import atos.upgrade.restapimssql.model.Employee;
import atos.upgrade.restapimssql.repository.EmployeeRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class EmployeeControllerPetitionsTest {

    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    protected MockMvc mvc;

    @Test
    @Ignore
    public void test(){
        Employee employee1 = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
        Employee employee2 = new Employee(225, "Saul", "Perez", "mail@mail.com");
        Employee employee3 = new Employee(226, "Rob", "Pacheco", "mail@mail.com");
        Employee employee4 = new Employee(227, "Ian", "Santillanes", "mail@mail.com");
        Employee employee5 = new Employee(228, "Santiago", "Morua", "mail@mail.com");


        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

    }
}
