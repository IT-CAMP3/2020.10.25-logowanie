package pl.camp.it.logowanie.gui;

import pl.camp.it.logowanie.model.User;

import java.util.List;

public interface UserRepositoryInterface {
    boolean authenticate(String login, String pass);
    boolean register(String login, String pass);
    List<User> getUserList();
}
