package web.beans;

import domain.models.service.JobServiceModel;
import service.JobService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobDetailsBean extends BaseBean {

    private JobService jobService;

    public JobDetailsBean() {
    }

    @Inject
    public JobDetailsBean(JobService jobService) {
        this.jobService = jobService;
    }

    public JobServiceModel jobServiceModel(String id) {
        return this.jobService.getJobById(id);
    }
}
