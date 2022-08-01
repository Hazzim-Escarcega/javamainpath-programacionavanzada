package atos.upgrade.restapimssql;

import atos.upgrade.restapimssql.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmployeeControllerTest extends AbstractTest {

    @Override
    protected void setUp(WebApplicationContext context) {
        super.setUp(context);
    }

    @Test
    public void getAllEmployees() throws Exception{
        String uri = "/api/v1/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        Employee[] employeeList = super.mapFromJson(content, Employee[].class);
        System.out.println("outpuuuut"+employeeList.length);
        assertTrue(employeeList.length >= 0);
    }

    @Test
    public void createProduct() throws Exception {
        String uri = "/api/v1/employees";
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
}
