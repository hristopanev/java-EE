package jobs.service;

import jobs.domain.models.service.JobApplicationServiceModel;

import java.util.List;

public interface JobApplicationService {

    JobApplicationServiceModel createJobApplication(JobApplicationServiceModel jobApplication);

    JobApplicationServiceModel getJobApplicationById(String id);

    List<JobApplicationServiceModel> getAllJobApplication();

    void delete(String id);
}
