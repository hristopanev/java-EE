package web.beans;

import domain.models.service.JobServiceModel;
import service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class JobListBean {
    private List<JobServiceModel> jobServiceModel;

    private JobService jobService;

    public JobListBean() {
    }

    @Inject
    public JobListBean(JobService jobService) {
        this.jobService = jobService;
    }

    @PostConstruct
    public void init() {
        this.setJobServiceModel(this.jobService.getAllJobs());
        this.getJobServiceModel().forEach(x -> x.setSector(x.getSector().toLowerCase()));
    }

    public List<JobServiceModel> getJobServiceModel() {
        return this.jobServiceModel;
    }

    public void setJobServiceModel(List<JobServiceModel> jobServiceModel) {
        this.jobServiceModel = jobServiceModel;
    }


}
