package service;

import domain.models.service.ProblemServiceModel;

import java.util.List;

public interface ProblemService {

    ProblemServiceModel createProblem(ProblemServiceModel problemServiceModel);

    ProblemServiceModel getProblemById(String id);

    List<ProblemServiceModel> getAllProblems();
}
