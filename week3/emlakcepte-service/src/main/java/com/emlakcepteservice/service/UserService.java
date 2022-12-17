package com.emlakcepteservice.service;

import com.emlakcepteservice.model.User;
import com.emlakcepteservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Singleton Pattern
/*	private static UserService userService = new UserService();

	private UserService() {

	}

	public static UserService getDifferentInstance() {
		return  new UserService();
	}

	public static UserService getSameInstance() {
		return userService;
	}
	*/
    public void createUser(User user) {
        //UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
        System.out.println("ben bir userDao objesiyim:" + userRepository.toString());

        if (user.getPassword().length() < 5) {
            System.out.println("Şifre en az 5 karakterli olmalı");
        }
        userRepository.createUser(user);
    }

    public List<User> getAllUser() {
        //UserDao userDao = new UserDao();
        return userRepository.findAllUsers();
    }

    public void printAllUser() {

        getAllUser().forEach(user -> System.out.println(user.getName()));

    }

    public void updatePassword(User user, String newPassword) {
        // önce hangi user bul ve passwordü update et.
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

}
