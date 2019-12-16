package cookbook.domain.models.service;

import java.util.ArrayList;
import java.util.List;

public class UserServiceModel {

    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private List<PostServiceModel> recipes;
    private List<UserServiceModel> friends;
    private List<UserServiceModel> userComment;

    public UserServiceModel() {
        this.friends = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<PostServiceModel> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(List<PostServiceModel> recipes) {
        this.recipes = recipes;
    }

    public List<UserServiceModel> getFriends() {
        return this.friends;
    }

    public void setFriends(List<UserServiceModel> friends) {
        this.friends = friends;
    }

    public List<UserServiceModel> getUserComment() {
        return this.userComment;
    }

    public void setUserComment(List<UserServiceModel> userComment) {
        this.userComment = userComment;
    }
}
