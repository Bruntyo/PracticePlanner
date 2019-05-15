package controller;

import model.User;

public class StartController {

    User user;
    //Load Profile
    public String loadUser(){
        user = new User("TestUser");
        return user.getName();
    }

    public User getUser(){
        return user;
    }

    //Create Profile

    //Initialize
}
