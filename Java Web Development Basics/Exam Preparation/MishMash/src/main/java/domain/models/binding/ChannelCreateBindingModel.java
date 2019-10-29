package domain.models.binding;

import domain.entites.Type;

import java.util.List;

public class ChannelCreateBindingModel {

    private String name;
    private String description;
    private String tags;

    public ChannelCreateBindingModel() {
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

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
