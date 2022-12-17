package medium.repository;



import medium.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserRepository {
    private static List<User> userList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> findAllUsers() { //bütün listeyi geri döner
        return userList;
    }


    public void update(User user, Long id) {
        var item = getById(user.getId());
        item.setName(user.getName());
        item.setBiography(user.getBiography());
        item.setMail(user.getMail());
        item.setPassword(user.getPassword());
        item.setBlogList(user.getBlogList());
        item.setFollowUserList(user.getFollowUserList());
        item.setTagList(user.getTagList());
        item.setCreateDate(user.getCreateDate());
        item.setFollowings(user.getFollowings());
    }

    public void delete(Long id) {
        userList.removeIf(user -> user.getId()==id);
    }

    public User getById(Long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
