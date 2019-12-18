package web.beans;

import domain.models.service.ProblemServiceModel;
import domain.models.service.SubmissionServiceModel;
import org.modelmapper.ModelMapper;
import service.ProblemService;
import service.SubmissionService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Named
@RequestScoped
public class ProblemDetailsBean {

    private List<SubmissionServiceModel> submissionServiceModel;

    private SubmissionService submissionService;
    private ProblemService problemService;
    private UserService userService;
    private ModelMapper modelMapper;

    public ProblemDetailsBean() {
    }

    @Inject
    public ProblemDetailsBean(SubmissionService submissionService, ProblemService problemService, UserService userService, ModelMapper modelMapper) {
        this.submissionService = submissionService;
        this.problemService = problemService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public Double getRandomRate() {
        Double rate =( Math.random() * 100) + 1;

        return rate;
    }

    public int getRandomResult() {
        int result = (int) (Math.random() * 100) + 1;

        return result;
    }

    public ProblemServiceModel getProblem(String id) {
        return this.problemService.getProblemById(id);
    }

    public List<SubmissionServiceModel> getSubmissions() {
        String id = ((HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest())
                .getParameter("id");

        return this.submissionService.getAllProblemSubmissions(id);
    }

    public List<SubmissionServiceModel> getSubmissionServiceModel() {
        return this.submissionServiceModel;
    }

    public void setSubmissionServiceModel(List<SubmissionServiceModel> submissionServiceModel) {
        this.submissionServiceModel = submissionServiceModel;
    }
}
