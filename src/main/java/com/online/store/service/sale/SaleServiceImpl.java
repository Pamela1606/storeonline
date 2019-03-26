package com.online.store.service.sale;

import com.online.store.models.Customer;
import com.online.store.models.Item;
import com.online.store.models.Sale;
import com.online.store.reporsitory.CustomerRepository;
import com.online.store.reporsitory.ModelItemRepository;
import com.online.store.reporsitory.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SaleConverter saleConverter;

    @Override
    public Page<SaleDto> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable).map(saleConverter::toDto);
    }

    @Override
    public SaleDto createEntity(SaleDto saleDto) {
        Optional<Customer> customerOptional = customerRepository.findById(saleDto.getCustomerId());
        if (!customerOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Customer with %d not exist.", saleDto.getCustomerId()));
        }
        Sale sale = saleConverter.toModel(saleDto);
        sale.setCustomer(customerOptional.get());
        saleRepository.save(sale);
        return saleConverter.toDto(sale);
    }

    @Override
    public SaleDto updateEntity(SaleDto saleDto) {
        Optional<Sale> saleOptional = saleRepository.findById(saleDto.getId());
        if (!saleOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Sale with %d not exist.", saleDto.getId()));
        }
        saleRepository.save(saleConverter.toModel(saleDto));
        return saleDto;
    }

    @Override
    public SaleDto deleteEntity(Long id) {
        Optional<Sale> saleOptional = saleRepository.findById(id);
        if (!saleOptional.isPresent()) {
            throw new InvalidParameterException(String.format("The Sale with %d not exist.", id));
        }
        saleRepository.delete(saleOptional.get());
        return saleConverter.toDto(saleOptional.get());
    }
}
