package by.devincubator.banklist.service.impl;

import by.devincubator.banklist.builder.Builder;
import by.devincubator.banklist.dao.DaoHelper;
import by.devincubator.banklist.dao.imlp.UserDao;
import by.devincubator.banklist.entity.User;
import by.devincubator.banklist.exception.DaoException;
import by.devincubator.banklist.exception.ServiceException;
import by.devincubator.banklist.service.api.UserService;

import java.util.Optional;

public class UserWorker implements UserService {

    private UserDao userDao;

    public UserWorker(DaoHelper daoHelper, Builder<User> builder) {
        this.userDao = daoHelper.userDao(builder);
    }

    @Override
    public Optional<User> getUserById(int id) throws ServiceException {
        try{
            return userDao.getById(id);
        } catch (DaoException e){
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
