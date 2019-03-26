package com.online.store.service.customer;

import com.online.store.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert CustomerDto to Customer
     *
     * @param customerDto a CustomerDto
     * @return a Customer entity
     */
    public Customer toModel(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }

    /**
     * Convert Customer to CustomerDto
     *
     * @param customer a Customer
     * @return a CustomerDto entity
     */
    public CustomerDto toDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }
}
