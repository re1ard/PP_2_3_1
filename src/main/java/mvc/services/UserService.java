package mvc.services;

import mvc.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(User user);
    void updateUser(User user);
}
