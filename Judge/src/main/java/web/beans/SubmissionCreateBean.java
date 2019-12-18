package web.beans;

import domain.models.binding.SubmissionCreateBindingModel;
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
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Collections;

@Named
@RequestScoped
public class SubmissionCreateBean extends BaseBean {

    private SubmissionCreateBindingModel submissionCreateBindingModel;

    private ProblemService problemService;
    private UserService userService;
    private SubmissionService submissionService;
    private ModelMapper modelMapper;

    public SubmissionCreateBean() {
    }

    @Inject
    public SubmissionCreateBean(ProblemService problemService, UserService userService, SubmissionService submissionService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.userService = userService;
        this.submissionService = submissionService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void initModel() {
        this.submissionCreateBindingModel = new SubmissionCreateBindingModel();
    }


    public ProblemServiceModel getProblem(String id) {
        return this.problemService.getProblemById(id);
    }

    public SubmissionCreateBindingModel getSubmissionCreateBindingModel() {
        return this.submissionCreateBindingModel;
    }

    public void setSubmissionCreateBindingModel(SubmissionCreateBindingModel submissionCreateBindingModel) {
        this.submissionCreateBindingModel = submissionCreateBindingModel;
    }

    public void createSubmission() {
        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

        String problemId = ((HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest())
                .getParameter("id");

        SubmissionServiceModel submissionServiceModel = this
                .modelMapper.map(this.submissionCreateBindingModel, SubmissionServiceModel.class);

        submissionServiceModel.setCode(Collections.singletonList(submissionCreateBindingModel.getCode()));
        submissionServiceModel.setAchievedResult((int) (Math.random() * 100) + 1);
        submissionServiceModel.setCreateOn(LocalDateTime.now());
        submissionServiceModel.setUser(this.userService.findUserByUsername(username));
        submissionServiceModel.setProblem(this.problemService.getProblemById(problemId));

        this.submissionService.createSubmission(submissionServiceModel);


        this.redirect("/home");
    }
}
