package service;

import domain.models.service.HeroServiceModel;

import java.util.List;

public interface HeroService {

    HeroServiceModel createHero(HeroServiceModel heroServiceModel);

    HeroServiceModel getById(String id);

    List<HeroServiceModel> getAllHeroes();

    void deleteHero(String id);
}
