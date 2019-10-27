package web.beans;

import domain.models.service.TubeServiceModel;
import domain.models.view.TubeViewModel;
import service.TubeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class HomeBean {

    private List<TubeServiceModel> tubeServiceModels;

    private TubeService tubeService;

    public HomeBean() {
    }

    @Inject
    public HomeBean(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    public void init() {
        this.setTubeServiceModels(this.tubeService.findAll());
    }

    public List<TubeServiceModel> getTubeServiceModels() {
        return this.tubeServiceModels;
    }

    public void setTubeServiceModels(List<TubeServiceModel> tubeServiceModels) {
        this.tubeServiceModels = tubeServiceModels;
    }
}
