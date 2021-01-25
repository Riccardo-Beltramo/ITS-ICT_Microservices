package org.example.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.example.customer.controllers.CustomerController;
import org.example.customer.models.Customer;
import org.example.customer.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class CustomerControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomers(){
        try{
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/customers")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerById(){
        try{
            Customer c = new Customer();
            c.setCustomerId(1);
            c.setName("Riccardo");
            c.setSurname("Beltramo");
            c.setCity("Torino");
            c.setTelephoneNumber(2467964678;
            customerRepository.findById(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}