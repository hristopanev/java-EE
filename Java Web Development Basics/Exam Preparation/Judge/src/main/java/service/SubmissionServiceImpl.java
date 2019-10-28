package service;

import domain.entites.Submission;
import domain.models.service.SubmissionServiceModel;
import org.modelmapper.ModelMapper;
import repository.SubmissionRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final ModelMapper modelMapper;

    @Inject
    public SubmissionServiceImpl(SubmissionRepository submissionRepository, ModelMapper modelMapper) {
        this.submissionRepository = submissionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SubmissionServiceModel createSubmission(SubmissionServiceModel submissionServiceModel) {
        return this.modelMapper
                .map(this.submissionRepository
                        .save(this.modelMapper.map(submissionServiceModel, Submission.class)), SubmissionServiceModel.class);
    }

    @Override
    public SubmissionServiceModel getById(String id) {
        return this.modelMapper.map(submissionRepository.findById(id), SubmissionServiceModel.class);
    }

    @Override
    public List<SubmissionServiceModel> getAllSubmission() {
        return this.submissionRepository.findAll()
                .stream()
                .map(s -> this.modelMapper.map(s, SubmissionServiceModel.class))
                .collect(Collectors.toList());
    }
}
