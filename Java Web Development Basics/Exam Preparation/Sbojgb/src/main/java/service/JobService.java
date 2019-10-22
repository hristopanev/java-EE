package service;

import domain.models.service.JobServiceModel;

import java.util.List;

public interface JobService {

    JobServiceModel createJob(JobServiceModel jobServiceModel);

    JobServiceModel getJobById(String id);

    List<JobServiceModel> getAllJobs();

    void delete(String id);
}
