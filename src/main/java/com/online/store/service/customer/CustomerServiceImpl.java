package com.online.store.service.customer;

import com.online.store.models.Customer;
import com.online.store.reporsitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public Page<CustomerDto> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable).map(customerConverter::toDto);
    }

    @Override
    public CustomerDto createEntity(CustomerDto customerDto) {
        Customer customer = customerRepository.save(customerConverter.toModel(customerDto));
        return customerConverter.toDto(customer);
    }

    @Override
    public CustomerDto updateEntity(CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerRepository.findById(customerDto.getId());
        if (!customerOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Customer with %d not exist.", customerDto.getId()));
        }
        customerRepository.save(customerConverter.toModel(customerDto));
        return customerDto;
    }

    @Override
    public CustomerDto deleteEntity(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Customer with %d not exist.", id));
        }
        customerRepository.delete(customerOptional.get());
        return customerConverter.toDto(customerOptional.get());
    }
}
