package medium.service;


import medium.model.User;
import medium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        if (user.getPassword().length() < 5) {
            System.out.println("Password must be at least 5 characters!");
        }
        userRepository.createUser(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAllUsers();
    }

    public void printAllUser() { //bütün userları getiren metod
        getAllUser().forEach(user -> System.out.println(user.getName()));
    }
    public void update(User user, Long id) {
        userRepository.update(user,id);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
    public User getByEmail(String email) {

        //// @formatter:off
        return userRepository.findAllUsers()
                .stream()
                .filter(user -> user.getMail().equals(email))
                .findFirst()
                .get();
        // @formatter:on

    }
    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
