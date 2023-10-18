package Service;

import Entities.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    boolean addUser(Users user) throws RemoteException;
    boolean removeUser(String userId) throws RemoteException;
    Users getUser(String userId) throws RemoteException;
}
