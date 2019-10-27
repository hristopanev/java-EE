package domain.entites;

import javax.persistence.*;

@Entity
@Table(name = "tubes")
public class Tube extends BaseEntity {

    private String title;
    private String author;
    private String description;
    private String youTuBeLink;
    private Integer views;
    private User uploader;

    public Tube() {
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "youtube_link")
    public String getYouTuBeLink() {
        return this.youTuBeLink;
    }
    public void setYouTuBeLink(String youTuBeLink) {
        this.youTuBeLink = youTuBeLink;
    }

    @Column(name = "views",  columnDefinition = "Integer default 0")
    public Integer getViews() {
        return this.views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uploader", referencedColumnName = "id")
    public User getUploader() {
        return this.uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }
}
