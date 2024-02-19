package com.devspringboot.accounts.service.impl;

import com.devspringboot.accounts.dto.CustomerDto;
import com.devspringboot.accounts.repository.AccountsRepository;
import com.devspringboot.accounts.repository.CustomerRepository;
import com.devspringboot.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
