package org.example.customer.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {
    @Id
    private Long customerId;
    private String name;
    private String surname;
    private String city;
    private Long telephone;


}