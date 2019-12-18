package jobs.web.beans;

import jobs.domain.models.binding.JobApplicationCreateBindingModel;
import jobs.domain.models.service.JobApplicationServiceModel;
import jobs.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("jobApplicationCreateBean")
@RequestScoped
public class JobApplicationCreateBean extends BaseBean {

    private JobApplicationCreateBindingModel jobApplicationModel;
    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    public JobApplicationCreateBean() {
    }

    @Inject
    public JobApplicationCreateBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    public JobApplicationCreateBindingModel getJobApplicationModel() {
        return this.jobApplicationModel;
    }

    public void setJobApplicationModel(JobApplicationCreateBindingModel jobApplicationModel) {
        this.jobApplicationModel = jobApplicationModel;
    }

    @PostConstruct
    public void init() {
        this.jobApplicationModel = new JobApplicationCreateBindingModel();
    }

    public void createJobApplication() {
        this.jobApplicationService.createJobApplication(
                this.modelMapper.map(this.jobApplicationModel, JobApplicationServiceModel.class));

        this.redirect("/home");
    }
}
