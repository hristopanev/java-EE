package repository;

import domain.entites.Problem;
import domain.models.service.ProblemServiceModel;

import java.util.List;

public interface ProblemRepository {

    Problem save(Problem problem);

    Problem findById(String id);

    List<Problem> findAll();
}
