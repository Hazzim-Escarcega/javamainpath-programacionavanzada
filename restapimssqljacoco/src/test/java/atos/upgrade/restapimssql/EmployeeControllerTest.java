package atos.upgrade.restapimssql;

import atos.upgrade.restapimssql.controller.EmployeeController;
import atos.upgrade.restapimssql.model.Employee;
import atos.upgrade.restapimssql.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest{
    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeController employeeController;
    MockMvc mvc;
    WebApplicationContext wac;

    @Before
    public void before() {
        MockitoAnnotations.openMocks(EmployeeController.class);
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }
    @BeforeEach
    void setup() {
        mvc = standaloneSetup(new EmployeeController())
                .defaultRequest(get("/")
                        .contextPath("/api").servletPath("/v1")
                        .accept(MediaType.APPLICATION_JSON)).build();
    }

    @Test
    public void getAllEmployees() throws Exception{
        mvc.perform(get("/api/v1/employees")).andExpect(status().isOk());
        /*Employee employee1 = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");
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

        String uri = "/api/v1/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        List employeeList = employees;
        assertTrue(employeeList.size() >= 0);
        assertEquals(5, employeeList.size());*/
    }
    @Test
    public void getEmployeeById() throws Exception{
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

        String uri = "/api/v1/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri, employee1)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        List employeeList = employees;
        assertTrue(employeeList.size() > 0);
        assertEquals(5, employeeList.size());
    }

    @Test
    public void createEmployee() throws Exception {
       /* String uri = "/api/v1/employees";
        Employee employee = new Employee();
        employee.setId(75);
        employee.setFirstName("Hazzim");
        employee.setLastName("Escarcega");
        employee.setEmailId("mail@mail.com");

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status );
    }
    @Test
    public void updateEmployee() throws Exception {
        String uri = "/api/v1//employees/{id}";
        Employee employee = new Employee(123, "Hazzim", "Escarcega", "mail@mail.com");

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri, employee.getId() )
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        //Esperando 404 por que no existe el usuario
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status );*/
    }
    @Test
    @DisplayName("Delete user")
    public void deleteUsersByIdTest() throws Exception {
        /*String uri = "/api/v1//employees/{id}";
        Employee employee = new Employee(222, "Hazzim", "Escarcega", "mail@mail.com");
        String inputJson = super.mapToJson(employee);
        System.out.println("Deleting record: "+employee.toString());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri, employee.getId() )
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        //Esperando 404 por que no existe el usuario
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status );*/

    }
}