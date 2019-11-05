package service;

import domain.entities.Hero;
import domain.models.service.HeroServiceModel;
import org.modelmapper.ModelMapper;
import repository.HeroRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    @Inject
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HeroServiceModel createHero(HeroServiceModel heroServiceModel) {
        return this.modelMapper.map(
                this.heroRepository.save(this.modelMapper.map(heroServiceModel, Hero.class)),
                HeroServiceModel.class);
    }

    @Override
    public HeroServiceModel getById(String id) {
        return this.modelMapper.map(this.heroRepository.findById(id), HeroServiceModel.class);
    }

    @Override
    public List<HeroServiceModel> getAllHeroes() {
        return this.heroRepository.findALL()
                .stream()
                .map(t -> this.modelMapper.map(t, HeroServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteHero(String id) {
        this.heroRepository.delete(id);
    }
}
