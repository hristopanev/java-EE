package service;

import domain.entites.Problem;
import domain.models.service.ProblemServiceModel;
import org.modelmapper.ModelMapper;
import repository.ProblemRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ProblemServiceImpl(ProblemRepository problemRepository, ModelMapper modelMapper) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProblemServiceModel createProblem(ProblemServiceModel problemServiceModel) {
        return this.modelMapper
                .map(this.problemRepository
                        .save(this.modelMapper.map(problemServiceModel, Problem.class)), ProblemServiceModel.class);
    }

    @Override
    public ProblemServiceModel getProblemById(String id) {
        return this.modelMapper.map(this.problemRepository.findById(id), ProblemServiceModel.class);
    }

    @Override
    public List<ProblemServiceModel> getAllProblems() {
        return this.problemRepository.findAll()
                .stream()
                .map(p -> this.modelMapper.map(p, ProblemServiceModel.class))
                .collect(Collectors.toList());
    }
}
