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

    public JobApplicationListBean() {
    }

    @Inject
    public JobApplicationListBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }



    public List<JobApplicationServiceModel> extractAllJobApplications() {
        return this.jobApplicationService.getAllJobApplication();
    }
}
