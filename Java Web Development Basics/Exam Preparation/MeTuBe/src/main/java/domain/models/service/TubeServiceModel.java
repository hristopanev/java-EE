package domain.models.service;

public class TubeServiceModel {

    private String id;
    private String title;
    private String author;
    private String description;
    private String youTuBeLink;
    private Integer views;
    private UserServiceModel uploader;

    public TubeServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYouTuBeLink() {
        return this.youTuBeLink;
    }

    public void setYouTuBeLink(String youTuBeLink) {
        this.youTuBeLink = youTuBeLink;
    }

    public Integer getViews() {
        return this.views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public UserServiceModel getUploader() {
        return this.uploader;
    }

    public void setUploader(UserServiceModel uploader) {
        this.uploader = uploader;
    }
}
