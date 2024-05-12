package com.devspringboot.accounts.service;

import com.devspringboot.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
