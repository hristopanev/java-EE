package repository;

import domain.entites.Problem;
import domain.entites.Submission;

import java.util.List;

public interface SubmissionRepository{

    Submission save(Submission submission);

    Submission findById(String id);

    List<Submission> findAll();

    List<Submission> findAllProblemSubmissions(String ProblemId);
}
