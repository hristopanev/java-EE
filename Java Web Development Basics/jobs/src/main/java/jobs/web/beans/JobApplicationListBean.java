package jobs.web.beans;

import jobs.domain.models.binding.JobApplicationCreateBindingModel;
import jobs.domain.models.service.JobApplicationServiceModel;
import jobs.service.JobApplicationService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("jobApplicationListBean")
@RequestScoped
public class JobApplicationListBean extends BaseBean {

    private JobApplicationService jobApplicationService;
    private List<JobApplicationServiceModel> jobApplications;

    public JobApplicationListBean() {
    }

    @Inject
    public JobApplicationListBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostConstruct
    public void init() {
        this.setJobApplications(this.jobApplicationService.getAllJobApplication());
        this.getJobApplications().forEach(x -> x.setSector(x.getSector().toLowerCase()));
    }

    public List<JobApplicationServiceModel> getJobApplications() {
        return this.jobApplications;
    }

    public void setJobApplications(List<JobApplicationServiceModel> jobApplications) {
        this.jobApplications = jobApplications;
    }
}
