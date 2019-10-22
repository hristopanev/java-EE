package web.beans;

import domain.models.binding.JobCreateBindingModel;
import domain.models.service.JobServiceModel;
import org.modelmapper.ModelMapper;
import service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobAddBean extends BaseBean {
    private JobCreateBindingModel jobCreateBindingModel;
    private JobServiceModel jobServiceModel;

    private ModelMapper modelMapper;
    private JobService jobService;

    public JobAddBean() {
    }

    @Inject
    public JobAddBean(ModelMapper modelMapper, JobService jobService) {
        this.modelMapper = modelMapper;
        this.jobService = jobService;
    }

    @PostConstruct
    private void init() {
        this.jobCreateBindingModel = new JobCreateBindingModel();
    }

    public JobCreateBindingModel getJobCreateBindingModel() {
        return this.jobCreateBindingModel;
    }

    public void setJobCreateBindingModel(JobCreateBindingModel jobCreateBindingModel) {
        this.jobCreateBindingModel = jobCreateBindingModel;
    }

    public void createJob() {
        this.jobService.createJob(
                this.modelMapper.map(this.jobCreateBindingModel, JobServiceModel.class));
        this.redirect("/home");

    }
}
