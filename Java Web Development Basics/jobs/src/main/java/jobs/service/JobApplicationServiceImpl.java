package jobs.service;

import jobs.domain.entities.JobApplication;
import jobs.domain.models.service.JobApplicationServiceModel;
import jobs.repository.JobApplicationRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobApplicationServiceImpl implements JobApplicationService {

    private final  ModelMapper modelMapper;
    private final JobApplicationRepository jobApplicationRepository;

    @Inject
    public JobApplicationServiceImpl(ModelMapper modelMapper, JobApplicationRepository jobApplicationRepository) {
        this.modelMapper = modelMapper;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public JobApplicationServiceModel createJobApplication(JobApplicationServiceModel jobApplication) {
        return this.modelMapper.map(
                this.jobApplicationRepository.save(this.modelMapper.map(jobApplication, JobApplication.class)),
                JobApplicationServiceModel.class);
    }

    @Override
    public JobApplicationServiceModel getJobApplicationById(String id) {
        return this.modelMapper.map(this.jobApplicationRepository.findById(id), JobApplicationServiceModel.class);
    }

    @Override
    public List<JobApplicationServiceModel> getAllJobApplication() {
        return this.jobApplicationRepository.findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, JobApplicationServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.jobApplicationRepository.delete(id);
    }
}
