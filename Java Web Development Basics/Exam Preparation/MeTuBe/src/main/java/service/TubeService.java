package service;

import domain.models.service.TubeServiceModel;

import java.util.List;

public interface TubeService {

    void uploadTube(TubeServiceModel tubeServiceModel);

    List<TubeServiceModel> findAll();

    TubeServiceModel findById(String id);
}
