package domain.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "channels")
public class Channel extends BaseEntity {

    private String name;
    private String description;
    private Type types;
    private List<String> tags;
    private List<User> followers;

    public Channel() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "types")
    public Type getTypes() {
        return this.types;
    }

    public void setTypes(Type types) {
        this.types = types;
    }

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "channels_id"))
    @Column(name = "tags", columnDefinition = "TEXT")
    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "channels_users",
            joinColumns = @JoinColumn(name = "channels_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    public List<User> getFollowers() {
        return this.followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}
