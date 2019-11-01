package web.beans;

import domain.models.service.TubeServiceModel;
import service.TubeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;

@Named
@RequestScoped
public class UserProfileBean {

    private List<TubeServiceModel> tubeServiceModels;

    private TubeService tubeService;

    public UserProfileBean() {
    }

    @Inject
    public UserProfileBean(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @PostConstruct
    public void init() {
        String userId = (String) ((HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false)).getAttribute("user-id");

        this.setTubeServiceModels(this.tubeService.getAllByUserId(userId));
    }

    public List<TubeServiceModel> getTubeServiceModels() {
        return this.tubeServiceModels;
    }

    public void setTubeServiceModels(List<TubeServiceModel> tubeServiceModels) {
        this.tubeServiceModels = tubeServiceModels;
    }
}
