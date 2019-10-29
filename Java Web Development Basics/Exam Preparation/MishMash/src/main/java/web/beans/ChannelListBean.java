package web.beans;

import domain.models.service.ChannelServiceModel;
import service.ChannelService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ChannelListBean {

    private List<ChannelServiceModel> channelServiceModels;

    private ChannelService channelService;

    public ChannelListBean() {
    }

    public ChannelListBean(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostConstruct
    public void init() {
        this.setChannelServiceModels(this.channelService.findAll());
    }

    public List<ChannelServiceModel> getChannelServiceModels() {
        return this.channelServiceModels;
    }

    public void setChannelServiceModels(List<ChannelServiceModel> channelServiceModels) {
        this.channelServiceModels = channelServiceModels;
    }
}
