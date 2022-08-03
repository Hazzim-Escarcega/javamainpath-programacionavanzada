package atos.upgrade.restapimssql;


import atos.upgrade.restapimssql.controller.EmployeeController;
import atos.upgrade.restapimssql.model.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeController employeeController;

    Employee mockEmployee = new Employee(224, "Hazzim", "Escarcega", "mail@mail.com");

    List<Employee> mockEmployeeList = new ArrayList<>();


    @Test
    public void getAllEmployeesTest() throws Exception {
        mockEmployeeList.add(mockEmployee);
        Mockito.when(employeeController.getAllEmployees()).thenReturn(mockEmployeeList);

        RequestBuilder rb = MockMvcRequestBuilders.get("/api/v1/employees")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(rb).andReturn();

        String expectedReturn = "[{\"id\":224,\"firstName\":\"Hazzim\",\"lastName\":\"Escarcega\",\"emailId\":\"mail@mail.com\"}]";
        int httpResponse = result.getResponse().getStatus();
        Assertions.assertEquals(200, httpResponse);
        System.out.println("Expected http response: 200\nActual http response: "+httpResponse);
        JSONAssert.assertEquals(expectedReturn, result.getResponse().getContentAsString(), false);
        System.out.println("Expected JSON content: "+expectedReturn+"\nActual JSON content"+result.getResponse().getContentAsString());
    }
    @Test
    public void createEmployeeTest() throws Exception {
        mockEmployeeList.add(mockEmployee);
        Mockito.when(employeeController.createEmployee(mockEmployee)).thenReturn(mockEmployee);
        Mapper mapper = new Mapper();
        String jsonInput = mapper.mapToJson(mockEmployee);
        System.out.println(jsonInput);
        RequestBuilder rb = MockMvcRequestBuilders.post("/api/v1/employees")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonInput);

        MvcResult result = mockMvc.perform(rb).andReturn();

        String expectedReturn = "{\"id\":224,\"firstName\":\"Hazzim\",\"lastName\":\"Escarcega\",\"emailId\":\"mail@mail.com\"}";
        System.out.println(expectedReturn +"\n"+ result.getResponse());
        int httpResponse = result.getResponse().getStatus();
        Assertions.assertEquals(200, httpResponse);
        System.out.println("Expected http response: 200\nActual http response: "+httpResponse);
        Assertions.assertEquals(expectedReturn, jsonInput);
        System.out.println("Expected JSON content: "+expectedReturn+"\nActual JSON content"+jsonInput);

    }
    @Test
    public void updateEmployeeTest() throws Exception {
        ResponseEntity<Employee> response = new ResponseEntity<>(HttpStatus.OK);
        mockEmployee.setFirstName("Pedro");
        Mockito.when(employeeController.updateEmployee(mockEmployee.getId(), mockEmployee)).thenReturn(response);
        Mapper mapper = new Mapper();
        String jsonInput = mapper.mapToJson(mockEmployee);
        RequestBuilder rb = MockMvcRequestBuilders.put("/api/v1/employees/"+mockEmployee.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonInput);

        MvcResult result = mockMvc.perform(rb).andReturn();

        String expectedReturn = "{\"id\":224,\"firstName\":\"Pedro\",\"lastName\":\"Escarcega\",\"emailId\":\"mail@mail.com\"}";
        System.out.println(expectedReturn +"\n"+ result.getResponse());
        int httpResponse = result.getResponse().getStatus();
        Assertions.assertEquals(response.getStatusCodeValue(), httpResponse);
        System.out.println("Expected http response: 200\nActual http response: "+httpResponse);
        Assertions.assertEquals(expectedReturn, jsonInput);
        System.out.println("Expected JSON content: "+expectedReturn+"\nActual JSON content"+jsonInput);

    }
    @Test
    public void deleteEmployeeTest() throws Exception {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        Mockito.when(employeeController.deleteEmployee(mockEmployee.getId())).thenReturn(response);
        Mapper mapper = new Mapper();
        String jsonInput = mapper.mapToJson(mockEmployee);
        RequestBuilder rb = MockMvcRequestBuilders.delete("/api/v1/employees/"+mockEmployee.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonInput);

        MvcResult result = mockMvc.perform(rb).andReturn();
        int httpResponse = result.getResponse().getStatus();
        String expectedResponse = "{\"deleted\":true}";
        Assertions.assertEquals(200, httpResponse);
        System.out.println("Expected http response: 200\nActual http response: "+httpResponse);
        System.out.println(response.get("deleted"));
        Assertions.assertEquals(expectedResponse, result.getResponse().getContentAsString());


    }


}