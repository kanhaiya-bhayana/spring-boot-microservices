package com.devspringboot.accounts.mapper;

import com.devspringboot.accounts.dto.AccountsDto;
import com.devspringboot.accounts.entity.Accounts;

public class AccountsMapper {

    /**
     * mapping accounts entity to accountsDto
     *
     * @param accounts - Accounts Object
     * @param accountsDto - AccountsDto Object
     * @return accountsDto - AccountsDto Object
     */
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto){
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    /**
     * mapping accountsDto to accounts entity
     * @param accountsDto - AccountsDto Object
     * @param accounts - Accounts Object
     * @return accounts - Accounts Object
     */
    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts){
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accounts.getBranchAddress());
        return accounts;
    }
}
