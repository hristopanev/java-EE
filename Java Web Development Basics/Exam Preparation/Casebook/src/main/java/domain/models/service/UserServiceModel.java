package domain.models.service;

import domain.entites.Gender;

import java.util.List;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private String  gender;
    private List<UserServiceModel> friends;

    public UserServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<UserServiceModel> getFriends() {
        return this.friends;
    }

    public void setFriends(List<UserServiceModel> friends) {
        this.friends = friends;
    }
}
