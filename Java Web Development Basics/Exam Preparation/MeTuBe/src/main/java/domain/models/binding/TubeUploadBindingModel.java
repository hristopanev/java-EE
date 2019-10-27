package domain.models.binding;

public class TubeUploadBindingModel {

    private String title;
    private String author;
    private String description;
    private String youTuBeLink;

    public TubeUploadBindingModel() {
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
}
