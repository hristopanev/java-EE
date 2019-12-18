package web.beans;

import domain.models.service.ProblemServiceModel;
import service.ProblemService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ProblemListBean {

    private List<ProblemServiceModel> problemServiceModel;

    private ProblemService problemService;

    public ProblemListBean() {
    }

    @Inject
    public ProblemListBean(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostConstruct
    public void init() {
        this.setProblemServiceModel(this.problemService.getAllProblems());
    }

    public List<ProblemServiceModel> getProblemServiceModel() {
        return this.problemServiceModel;
    }

    public void setProblemServiceModel(List<ProblemServiceModel> problemServiceModel) {
        this.problemServiceModel = problemServiceModel;
    }
}
