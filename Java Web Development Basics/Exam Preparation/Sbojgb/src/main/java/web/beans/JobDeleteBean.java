package web.beans;

import domain.models.service.JobServiceModel;
import service.JobService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class JobDeleteBean extends BaseBean {

    private JobService jobService;

    public JobDeleteBean() {
    }

    @Inject
    public JobDeleteBean(JobService jobService) {
        this.jobService = jobService;
    }

    public JobServiceModel jobServiceModel(String id) {
        JobServiceModel result = this.jobService.getJobById(id);

        return result;
    }

    public void delete() {
        String id = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest())
                .getParameter("id");

        this.jobService.delete(id);
        this.redirect("/home");
    }
}
