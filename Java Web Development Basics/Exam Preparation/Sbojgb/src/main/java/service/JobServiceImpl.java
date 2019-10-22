package service;

import domain.entites.JobApp;
import domain.models.service.JobServiceModel;
import org.modelmapper.ModelMapper;
import repository.JobRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Inject
    public JobServiceImpl(JobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JobServiceModel createJob(JobServiceModel jobServiceModel) {
        return this.modelMapper.map(
                this.jobRepository
                .save(this.modelMapper.map(jobServiceModel, JobApp.class)),
                JobServiceModel.class);
    }

    @Override
    public JobServiceModel getJobById(String id) {
        return this.modelMapper.map(this.jobRepository.findById(id), JobServiceModel.class);
    }

    @Override
    public List<JobServiceModel> getAllJobs() {
        return this.jobRepository.findAll()
                .stream()
                .map(j -> this.modelMapper.map(j, JobServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.jobRepository.delete(id);
    }
}
