package domain.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private Gender Gender;
    private List<User> friend;

    public User() {
    }

    @Column(name = "username", nullable = false, updatable = false, unique = true)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    public Gender getGender() {
        return this.Gender;
    }

    public void setGender(domain.entites.Gender gender) {
        Gender = gender;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name ="users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    public List<User> getFriend() {
        return this.friend;
    }

    public void setFriend(List<User> friend) {
        this.friend = friend;
    }
}
