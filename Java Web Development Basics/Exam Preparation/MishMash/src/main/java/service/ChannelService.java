package service;

import domain.models.service.ChannelServiceModel;

import java.util.List;

public interface ChannelService {

    void creteChannel(ChannelServiceModel channelServiceModel);

    List<ChannelServiceModel> findAll();

    ChannelServiceModel findById(String id);

}
