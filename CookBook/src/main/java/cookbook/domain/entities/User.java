package cookbook.domain.entities;

import cookbook.service.UserService;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private List<Post> recipes;
    private List<User> friends;
    private List<Comment> comments;


    public User() {

    }

    @Column(name = "firstname", nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname", nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(targetEntity = Post.class, mappedBy = "posts")
    public List<Post> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(List<Post> recipes) {
        this.recipes = recipes;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name ="users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    public List<User> getFriends() {
        return this.friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @OneToMany(targetEntity = Comment.class, mappedBy = "users")
    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
