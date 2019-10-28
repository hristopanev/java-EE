package domain.models.service;

import domain.entites.Problem;
import domain.entites.User;

import java.time.LocalDateTime;
import java.util.List;

public class SubmissionServiceModel {

    private String id;
    private List<String> code;
    private Integer achievedResult;
    private LocalDateTime createOn;
    private ProblemServiceModel problem;
    private UserServiceModel user;

    public SubmissionServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCode() {
        return this.code;
    }

    public void setCode(List<String> code) {
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
