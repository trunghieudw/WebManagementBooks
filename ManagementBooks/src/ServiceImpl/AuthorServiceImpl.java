package ServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.List;

import DAO.AuthorDAO;
import Entities.Authors;
import Services.AuthorService;

public class AuthorServiceImpl extends UnicastRemoteObject implements AuthorService {
    private AuthorDAO authorDAO;

    public AuthorServiceImpl(Connection connection) throws RemoteException {
        super();
        authorDAO = new AuthorDAO(connection);
    }

    @Override
    public boolean addAuthor(Authors author) throws RemoteException {
        return authorDAO.addAuthor(author);
    }

    @Override
    public boolean removeAuthor(String authorId) throws RemoteException {
        return authorDAO.removeAuthor(authorId);
    }

    @Override
    public boolean updateAuthor(Authors author) throws RemoteException {
        return authorDAO.updateAuthor(author);
    }

    @Override
    public Authors getAuthor(String authorId) throws RemoteException {
        return authorDAO.getAuthor(authorId);
    }

    @Override
    public List<Authors> getAllAuthors() throws RemoteException {
        return authorDAO.getAllAuthors();
    }
}

