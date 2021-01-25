package org.example.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.example.customer.models.Customer;
import org.example.customer.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerRepositoryUnitTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testEmptyDB(){
        assertEquals(0,customerRepository.findAll().size());
    }

    @Test
    public void testAddOneCustomer(){
        Customer c = new Customer();
        c.setCustomerId(1);
        c.setName("Riccardo");
        c.setSurname("Beltramo");
        c.setCity("Torino");
        c.setTelephoneNumber(3467964678);
        customerRepository.save(c);
        assertEquals(1,customerRepository.findAll().size()  );
    }

    @Test
    public void testDeleteAllCustomer(){
        Customer c = new Customer();
        c.setCustomerId(1);
        c.setName("Riccardo");
        c.setSurname("Beltramo");
        c.setCity("Torino");
        c.setTelephoneNumber(3467964678);
        customerRepository.save(c);

        Customer c2 = new Customer();
        c2.setCustomerId(2);
        c2.setName("Graziella");
        c2.setSurname("Novara");
        c2.setCity("Torino");
        c2.setTelephoneNumber(3478510812);
        customerRepository.save(c2);

        assertEquals(0,customerRepository.findAll().size()  );
    }
}