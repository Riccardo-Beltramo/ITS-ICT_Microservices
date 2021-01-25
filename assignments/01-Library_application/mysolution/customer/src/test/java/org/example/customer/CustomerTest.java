package org.example.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.example.customer.models.Customer;
import org.example.customer.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
public class CustomerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomer() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/customers")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerByID(){
        try{
            Customer c = new Customer();
            c.setCustomerId(1);
            c.setName("Riccardo");
            c.setSurname("Beltramo");
            c.setCity("Torino");
            c.setTelephoneNumber(3467964678);
            customerRepository.save(c);

            Customer c2 = new Customer();
            c2.setCustomerId(2);
            c2.setName("Riccardo");
            c2.setSurname("Beltramo");
            c2.setCity("Torino");
            c2.setTelephoneNumber(3478510812);
            customerRepository.save(c2);

            customerRepository.findById(1);
        }
        catch (Exception e){
            e.printStackTrace();;
        }
    }

}