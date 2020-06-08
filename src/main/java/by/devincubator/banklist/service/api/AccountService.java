package by.devincubator.banklist.service.api;

import by.devincubator.banklist.entity.Account;
import by.devincubator.banklist.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccounts() throws ServiceException;
    Optional<Account> getAccountById(int id) throws ServiceException;
}
