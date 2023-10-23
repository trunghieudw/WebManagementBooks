package Services;

import Entities.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    boolean addUser(Users user) throws RemoteException;
    boolean removeUser(String userId) throws RemoteException;
    boolean updateUser(Users user) throws RemoteException;
    Users getUser(String userId) throws RemoteException;
}
