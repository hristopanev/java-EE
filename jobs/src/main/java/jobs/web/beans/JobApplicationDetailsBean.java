package jobs.web.beans;

import jobs.domain.models.service.JobApplicationServiceModel;
import jobs.service.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class JobApplicationDetailsBean extends BaseBean {

    private JobApplicationService jobApplicationService;

    public JobApplicationDetailsBean() {
    }

    @Inject
    public JobApplicationDetailsBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    public JobApplicationServiceModel getJobApplication(String id) {
        return this.jobApplicationService.getJobApplicationById(id);
    }
}
