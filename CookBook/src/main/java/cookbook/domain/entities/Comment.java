package cookbook.domain.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment  extends  BaseEntity{

    private User users;
    private Post posts;

    public Comment() {
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    public User getUsers() {
        return this.users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "id"
    )
    public Post getPosts() {
        return this.posts;
    }

    public void setPosts(Post posts) {
        this.posts = posts;
    }
}
