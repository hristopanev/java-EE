package cookbook.domain.models.service;


import java.time.LocalDateTime;
import java.util.List;

public class PostServiceModel {

    private String id;
    private String name;
    private byte[] image;
    private String product;
    private String description;
    private LocalDateTime postTime;
    private UserServiceModel posts;
    private List<PostServiceModel> postComment;


    public PostServiceModel() {
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

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

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

    public UserServiceModel getPosts() {
        return this.posts;
    }

    public void setPosts(UserServiceModel posts) {
        this.posts = posts;
    }

    public List<PostServiceModel> getPostComment() {
        return this.postComment;
    }

    public void setPostComment(List<PostServiceModel> postComment) {
        this.postComment = postComment;
    }
}
