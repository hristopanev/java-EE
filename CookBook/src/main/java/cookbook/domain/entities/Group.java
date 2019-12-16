//package cookbook.domain.entities;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "groups")
//public class Group extends BaseEntity {
//
//    private String name;
//    private List<User> users;
//    private List<Post> posts;
//
//    public Group() {
//    }
//
//    @Column(name = "name", nullable = false)
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @ManyToMany(mappedBy = "groups")
//    public List<User> getUsers() {
//        return this.users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    @OneToMany(targetEntity = Post.class, mappedBy = "group")
//    public List<Post> getPosts() {
//        return this.posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
//}
