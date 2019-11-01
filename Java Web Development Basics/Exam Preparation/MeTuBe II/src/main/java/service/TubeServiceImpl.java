package service;

import domain.entites.Tube;
import domain.models.service.TubeServiceModel;
import org.modelmapper.ModelMapper;
import repository.TubeRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class TubeServiceImpl implements TubeService {

    private final TubeRepository tubeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper modelMapper) {
        this.tubeRepository = tubeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void uploadTube(TubeServiceModel tubeServiceModel) {
        Tube tube = this.modelMapper.map(tubeServiceModel, Tube.class);

        this.tubeRepository.save(tube);
    }

    @Override
    public TubeServiceModel getById(String id) {
        return this.modelMapper.map(this.tubeRepository.findById(id), TubeServiceModel.class);
    }

    @Override
    public List<TubeServiceModel> getAll() {
        return this.tubeRepository.findAll()
                .stream()
                .map(t -> this.modelMapper.map(t, TubeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TubeServiceModel> getAllByUserId(String id) {
        return this.tubeRepository.findAllByUserId(id)
                .stream()
                .map(t -> this.modelMapper.map(t, TubeServiceModel.class))
                .collect(Collectors.toList());
    }
}
