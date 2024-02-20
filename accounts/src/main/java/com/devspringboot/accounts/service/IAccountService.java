package com.devspringboot.accounts.service;

import com.devspringboot.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - String
     * @return the customerDto
     */
    CustomerDto fetchAccount(String mobileNumber);
}
