package web.beans;

import domain.models.service.TubeServiceModel;
import domain.models.view.HomeViewModel;
import org.modelmapper.ModelMapper;
import service.TubeService;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        setTubeServiceModels(this.tubeService.getAll());
    }

    public List<TubeServiceModel> getTubeServiceModels() {
        return this.tubeServiceModels;
    }

    public void setTubeServiceModels(List<TubeServiceModel> tubeServiceModels) {
        this.tubeServiceModels = tubeServiceModels;
    }
}
