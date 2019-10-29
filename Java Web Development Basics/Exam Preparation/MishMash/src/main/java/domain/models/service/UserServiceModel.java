package domain.models.service;

import java.util.List;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private String email;
    private List<ChannelServiceModel> channels;
    private String Role;

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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ChannelServiceModel> getChannels() {
        return this.channels;
    }

    public void setChannels(List<ChannelServiceModel> channels) {
        this.channels = channels;
    }

    public String getRole() {
        return this.Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
