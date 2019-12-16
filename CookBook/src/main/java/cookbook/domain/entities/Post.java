package cookbook.domain.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    private String name;
    private byte[] image;
    private String product;
    private String description;
    private LocalDateTime postTime;
    private User posts;
    private List<Comment> comments;

    public Post() {
    }

    @Column(name = "recipe_name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(name = "image")
    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Column(name = "products")
    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPostTime() {
        return this.postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    public User getPosts() {
        return this.posts;
    }

    public void setPosts(User posts) {
        this.posts = posts;
    }

    @OneToMany(targetEntity = Comment.class, mappedBy = "posts")
    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
