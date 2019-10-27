package domain.entites;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "submissions")
public class Submission extends BaseEntity {

    private List<String> code;
    private Integer achievedResult;
    private LocalDateTime createOn;
    private Problem problem;
    private User user;

    public Submission() {
    }

    @ElementCollection
    @CollectionTable(name="codes", joinColumns=@JoinColumn(name="submissions_id"))
    @Column(name = "code")
    public List<String> getCode() {
        return this.code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    @Column(name = "achieved_result")
    public Integer getAchievedResult() {
        return this.achievedResult;
    }

    public void setAchievedResult(Integer achievedResult) {
        this.achievedResult = achievedResult;
    }

    @Column(name = "create_on")
    public LocalDateTime getCreateOn() {
        return this.createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    @ManyToOne(targetEntity = Problem.class)
    @JoinColumn(
            name = "problem",
            referencedColumnName = "id"
    )
    public Problem getProblem() {
        return this.problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "user",
            referencedColumnName = "id"
    )
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
