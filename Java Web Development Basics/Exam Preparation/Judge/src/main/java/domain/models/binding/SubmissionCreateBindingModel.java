package domain.models.binding;

import domain.models.service.ProblemServiceModel;
import domain.models.service.UserServiceModel;

import java.time.LocalDateTime;

public class SubmissionCreateBindingModel {

    private String code;
    private Integer achievedResult;
    private LocalDateTime createOn;
    private ProblemServiceModel problem;
    private UserServiceModel user;

    public SubmissionCreateBindingModel() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAchievedResult() {
        return this.achievedResult;
    }

    public void setAchievedResult(Integer achievedResult) {
        this.achievedResult = achievedResult;
    }

    public LocalDateTime getCreateOn() {
        return this.createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public ProblemServiceModel getProblem() {
        return this.problem;
    }

    public void setProblem(ProblemServiceModel problem) {
        this.problem = problem;
    }

    public UserServiceModel getUser() {
        return this.user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }
}
