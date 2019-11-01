package web.beans;

import domain.models.binding.TubeCreateBindingModel;
import domain.models.service.TubeServiceModel;
import org.modelmapper.ModelMapper;
import service.TubeService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class TubeUploadBean extends BaseBean {

    private TubeCreateBindingModel tubeCreateBindingModel;

    private TubeService tubeService;
    private UserService userService;
    private ModelMapper modelMapper;

    public TubeUploadBean() {
    }

    @Inject
    public TubeUploadBean(TubeService tubeService, UserService userService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.tubeCreateBindingModel = new TubeCreateBindingModel();
    }

    public TubeCreateBindingModel getTubeCreateBindingModel() {
        return this.tubeCreateBindingModel;
    }

    public void setTubeCreateBindingModel(TubeCreateBindingModel tubeCreateBindingModel) {
        this.tubeCreateBindingModel = tubeCreateBindingModel;
    }


    public void uploadTube() {
        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

        TubeServiceModel tubeServiceModel =
                this.modelMapper.map(tubeCreateBindingModel, TubeServiceModel.class);

        tubeServiceModel.setUploader(this.userService.findUserByUsername(username));
        tubeServiceModel.setYoutubeId(this.tubeCreateBindingModel.getYoutubeLink().split("=")[1]);

        this.tubeService.uploadTube(tubeServiceModel);

        this.redirect("/home");
    }
}

