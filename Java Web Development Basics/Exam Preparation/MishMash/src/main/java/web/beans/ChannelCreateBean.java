package web.beans;

import domain.models.binding.ChannelCreateBindingModel;
import domain.models.service.ChannelServiceModel;
import org.modelmapper.ModelMapper;
import service.ChannelService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Collections;

@Named
@RequestScoped
public class ChannelCreateBean extends BaseBean {

    private ChannelCreateBindingModel channelCreateBindingModel;

    private ChannelService channelService;
    private ModelMapper modelMapper;

    public ChannelCreateBean() {
    }

    @Inject
    public ChannelCreateBean(ChannelService channelService, ModelMapper modelMapper) {
        this.channelService = channelService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.channelCreateBindingModel = new ChannelCreateBindingModel();
    }

    public ChannelCreateBindingModel getChannelCreateBindingModel() {
        return this.channelCreateBindingModel;
    }

    public void setChannelCreateBindingModel(ChannelCreateBindingModel channelCreateBindingModel) {
        this.channelCreateBindingModel = channelCreateBindingModel;
    }

    public void createChannel() {

        ChannelServiceModel channelServiceModel =
                this.modelMapper.map(this.channelCreateBindingModel, ChannelServiceModel.class);

        channelServiceModel.setTags(Collections.singletonList(channelCreateBindingModel.getTags()));

        this.channelService.creteChannel(channelServiceModel);

        this.redirect("/home");
    }
}
