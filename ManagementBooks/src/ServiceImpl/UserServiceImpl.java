package ServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

import DAO.UserDAO;
import Entities.Users;
import Services.BookService;
import Services.LibraryService;
import Services.ManagementService;
import Services.UserService;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(Connection connection) throws RemoteException {
        super();
        userDAO = new UserDAO(connection);
    }

    @Override
    public boolean addUser(Users user) throws RemoteException {
        return userDAO.addUser(user);
    }

    @Override
    public boolean removeUser(String userId) throws RemoteException {
        return userDAO.removeUser(userId);
    }

    @Override
    public boolean updateUser(Users user) throws RemoteException {
        return userDAO.updateUser(user);
    }

    @Override
    public Users getUser(String userId) throws RemoteException {
        return userDAO.getUser(userId);
    }
}

