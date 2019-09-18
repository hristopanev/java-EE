package jobs.web.beans;

import jobs.domain.models.service.JobApplicationServiceModel;
import jobs.service.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named("jobApplicationDeleteBean")
@RequestScoped
public class JobApplicationDeleteBean extends BaseBean {
    private JobApplicationService jobApplicationsService;

    public JobApplicationDeleteBean() {
    }

    @Inject
    public JobApplicationDeleteBean(JobApplicationService jobApplicationsService) {
        this.jobApplicationsService = jobApplicationsService;
    }

    public JobApplicationServiceModel getJobApplication(String id) {
        JobApplicationServiceModel result = this.jobApplicationsService.getJobApplicationById(id);

        return result;
    }

    public void delete() {
        String id = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.jobApplicationsService.delete(id);
        this.redirect("/home");
    }
}
