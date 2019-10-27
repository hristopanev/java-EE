package web.beans;

import domain.models.binding.ProblemCreateBindingModel;
import domain.models.service.ProblemServiceModel;
import org.modelmapper.ModelMapper;
import service.ProblemService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ProblemCreateBean extends BaseBean {

    private ProblemCreateBindingModel model;

    private ProblemService problemService;
    private ModelMapper modelMapper;

    public ProblemCreateBean() {
    }

    @Inject
    public ProblemCreateBean(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.model = new ProblemCreateBindingModel();
    }

    public ProblemCreateBindingModel getModel() {
        return this.model;
    }

    public void setModel(ProblemCreateBindingModel model) {
        this.model = model;
    }

    public void create() {
        this.problemService.createProblem(
                this.modelMapper.map(this.model, ProblemServiceModel.class)
        );

        this.redirect("/home");
    }
}
