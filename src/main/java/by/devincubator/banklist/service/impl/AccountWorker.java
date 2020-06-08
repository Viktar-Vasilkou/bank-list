package by.devincubator.banklist.service.impl;

import by.devincubator.banklist.builder.Builder;
import by.devincubator.banklist.dao.DaoHelper;
import by.devincubator.banklist.dao.imlp.AccountDao;
import by.devincubator.banklist.entity.Account;
import by.devincubator.banklist.exception.DaoException;
import by.devincubator.banklist.exception.ServiceException;
import by.devincubator.banklist.service.api.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountWorker implements AccountService {

    private AccountDao accountDao;

    public AccountWorker(DaoHelper daoHelper, Builder<Account> builder) {
        this.accountDao = daoHelper.accountDao(builder);
    }

    @Override
    public List<Account> getAllAccounts() throws ServiceException {
        try {
            return accountDao.getAll();
        } catch (DaoException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public Optional<Account> getAccountById(int id) throws ServiceException {
        try {
            return accountDao.getById(id);
        } catch (DaoException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public Integer getAccountSum() throws ServiceException{
        try {
            Integer sum = 0;
            for (Account a: accountDao.getAll()) {
                sum += a.getAccount();
            }
            return sum;
        } catch (DaoException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public Integer getRichestUserId() throws ServiceException{
        try {
            Integer userId = 1;
            if (accountDao.getById(1).isPresent()){
                Integer cash = accountDao.getById(1).get().getAccount();
                for (Account a: accountDao.getAll()) {
                    if (cash < a.getAccount()){
                        userId = a.getId();
                    }
                }
            }

            return userId;
        } catch (DaoException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
