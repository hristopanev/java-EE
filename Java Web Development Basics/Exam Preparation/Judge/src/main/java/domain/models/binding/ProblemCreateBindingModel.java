package domain.models.binding;

public class ProblemCreateBindingModel {

    private String name;
    private Integer points;

    public ProblemCreateBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return this.points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
