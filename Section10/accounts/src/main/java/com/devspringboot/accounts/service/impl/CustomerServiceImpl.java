package com.devspringboot.accounts.service.impl;

import com.devspringboot.accounts.dto.AccountsDto;
import com.devspringboot.accounts.dto.CardsDto;
import com.devspringboot.accounts.dto.CustomerDetailsDto;
import com.devspringboot.accounts.dto.LoansDto;
import com.devspringboot.accounts.entity.Accounts;
import com.devspringboot.accounts.entity.Customer;
import com.devspringboot.accounts.exceptions.ResourceNotFoundException;
import com.devspringboot.accounts.mapper.AccountsMapper;
import com.devspringboot.accounts.mapper.CustomerMapper;
import com.devspringboot.accounts.repository.AccountsRepository;
import com.devspringboot.accounts.repository.CustomerRepository;
import com.devspringboot.accounts.service.ICustomerService;
import com.devspringboot.accounts.service.client.CardsFeignClient;
import com.devspringboot.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));


        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
