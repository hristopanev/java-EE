package web.beans;

import domain.models.service.TubeServiceModel;
import service.TubeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class TubeDetailsBean {

    private TubeServiceModel tubeServiceModel;

    private TubeService tubeService;

    public TubeDetailsBean() {
    }

    @Inject
    public TubeDetailsBean(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    public TubeServiceModel getTube(String id) {
        return this.tubeService.getById(id);
    }

    public TubeServiceModel getTubeServiceModel() {
        return this.tubeServiceModel;
    }

    public void setTubeServiceModel(TubeServiceModel tubeServiceModel) {
        this.tubeServiceModel = tubeServiceModel;
    }
}
