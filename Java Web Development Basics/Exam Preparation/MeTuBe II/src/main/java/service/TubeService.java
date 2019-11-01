package service;

import domain.models.service.TubeServiceModel;

import java.util.List;

public interface TubeService {

    void uploadTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel getById(String id);

    List<TubeServiceModel> getAll();

    List<TubeServiceModel> getAllByUserId(String id);
}
