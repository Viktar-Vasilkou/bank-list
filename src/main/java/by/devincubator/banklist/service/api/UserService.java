package by.devincubator.banklist.service.api;

import by.devincubator.banklist.entity.User;
import by.devincubator.banklist.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(int id) throws ServiceException;
}
