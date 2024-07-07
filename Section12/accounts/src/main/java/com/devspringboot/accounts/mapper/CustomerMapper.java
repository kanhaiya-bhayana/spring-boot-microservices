package com.devspringboot.accounts.mapper;

import com.devspringboot.accounts.dto.CustomerDetailsDto;
import com.devspringboot.accounts.dto.CustomerDto;
import com.devspringboot.accounts.entity.Customer;

public class CustomerMapper {

    /**
     * mapping customer entity to customerDto
     *
     * @param customer - Customer Object
     * @param customerDto - CustomerDto Object
     * @return customerDto - CustomerDto Object
     */
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto){
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer customer, CustomerDetailsDto customerDetailsDto){
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }

    /**
     * mapping customerDto to customer entity
     *
     * @param customerDto - CustomerDto Object
     * @param customer - Customer Object
     * @return customer - Customer Object
     */
    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer){
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}


