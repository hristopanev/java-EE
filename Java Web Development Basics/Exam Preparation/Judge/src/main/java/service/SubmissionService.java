package service;

import domain.entites.Submission;
import domain.models.service.SubmissionServiceModel;

import java.util.List;

public interface SubmissionService {

    SubmissionServiceModel createSubmission(SubmissionServiceModel submissionServiceModel);

    SubmissionServiceModel getById(String id);

    List<SubmissionServiceModel> getAllSubmission();

    List<SubmissionServiceModel> getAllProblemSubmissions(String id);
}
