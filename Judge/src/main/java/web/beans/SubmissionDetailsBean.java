package web.beans;

import domain.models.service.SubmissionServiceModel;
import service.SubmissionService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SubmissionDetailsBean {

    SubmissionService submissionService;

    public SubmissionDetailsBean() {
    }

    @Inject
    public SubmissionDetailsBean(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    public SubmissionServiceModel getSubmission(String id) {
        System.out.println();
       return this.submissionService.getById(id);
    }
}
