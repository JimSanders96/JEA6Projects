package Service;

import DAO.DAOManager;
import Domain.Group;
import Domain.Kweet;
import Domain.User;

import java.util.List;

/**
 * Created by Joris on 4-3-2017.
 */
public class ModService {

    /**
     * Lets a mod or admin to change the role of a user
     *
     * @param userId the id of the user where the role will be changed of
     * @param role   the role the user get
     */
    public void changeRole(int userId, String role) throws NullPointerException {
        User user = DAOManager.userDAO.get(userId);

        if (user == null)
            throw new NullPointerException("Can't find the user!");

        Group group = new Group();
        group.setGroupName(role);
        user.setGroup(group);
        DAOManager.userDAO.update(user);
    }

    /**
     * Gives a list of all users with its roles for a mod or admin
     *
     * @return the list of all users with its roles
     */
    public List<User> getAllUsers() {
        return DAOManager.userDAO.getAll();
    }

    /**
     * Gives a list of all kweets for a mod or admin
     *
     * @return the list of all kweets
     */
    public List<Kweet> getAllKweets() {
        return DAOManager.kweetDAO.getAll();
    }

    /**
     * Lets a mod or admin delete a kweet
     *
     * @param kweet the kweet that has to be deleted
     */
    public void deleteKweet(int kweetId) throws NullPointerException {
        Kweet kweetToDelete = DAOManager.kweetDAO.get(kweetId);

        if (kweetToDelete == null)
            throw new NullPointerException("Can't find the kweet!");

        DAOManager.kweetDAO.delete(kweetToDelete);
    }
}