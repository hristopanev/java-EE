package service;

import domain.entites.Channel;
import domain.models.service.ChannelServiceModel;
import org.modelmapper.ModelMapper;
import repository.ChannelRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ChannelServiceImpl(ChannelRepository channelRepository, ModelMapper modelMapper) {
        this.channelRepository = channelRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void creteChannel(ChannelServiceModel channelServiceModel) {
        Channel channel = this.modelMapper.map(channelServiceModel, Channel.class);
        this.channelRepository.save(channel);
    }

    @Override
    public List<ChannelServiceModel> findAll() {
        return this.channelRepository.findALl()
                .stream()
                .map(c -> this.modelMapper.map(c, ChannelServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChannelServiceModel findById(String id) {
        return this.modelMapper.map(this.channelRepository.findById(id), ChannelServiceModel.class);
    }

}
