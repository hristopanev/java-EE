package web.beans;

import domain.models.service.TubeServiceModel;
import domain.models.view.TubeViewModel;
import org.modelmapper.ModelMapper;
import service.TubeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class TubeDetailsBean {

    private TubeViewModel model;

    private TubeService tubeService;
    private ModelMapper modelMapper;

    public TubeDetailsBean() {
    }

    @Inject
    public TubeDetailsBean(TubeService tubeService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.modelMapper = modelMapper;
    }

    public TubeServiceModel getTube(String id) {
        return this.tubeService.findById(id);


    }

    public TubeViewModel getModel() {
        return this.model;
    }

    public void setModel(TubeViewModel model) {
        this.model = model;
    }
}
