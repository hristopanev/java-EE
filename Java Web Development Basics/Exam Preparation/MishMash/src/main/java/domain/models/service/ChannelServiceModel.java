package domain.models.service;

import domain.entites.Type;

import java.util.List;

public class ChannelServiceModel {

    private String id;
    private String name;
    private String description;
    private Type types;
    private List<String> tags;
    private List<UserServiceModel> followers;

    public ChannelServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getTypes() {
        return this.types;
    }

    public void setTypes(Type types) {
        this.types = types;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<UserServiceModel> getFollowers() {
        return this.followers;
    }

    public void setFollowers(List<UserServiceModel> followers) {
        this.followers = followers;
    }
}
