package web.beans;

import domain.models.binding.TubeUploadBindingModel;
import domain.models.service.TubeServiceModel;
import org.modelmapper.ModelMapper;
import service.TubeService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class TubeUploadBean extends BaseBean {
    private TubeUploadBindingModel tubeUploadBindingModel;

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
        this.tubeUploadBindingModel = new TubeUploadBindingModel();
    }

    public TubeUploadBindingModel getTubeUploadBindingModel() {
        return this.tubeUploadBindingModel;
    }

    public void setTubeUploadBindingModel(TubeUploadBindingModel tubeUploadBindingModel) {
        this.tubeUploadBindingModel = tubeUploadBindingModel;
    }

    public void upload() {
        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

        TubeServiceModel tubeServiceModel = this.modelMapper
                .map(this.tubeUploadBindingModel, TubeServiceModel.class);

        tubeServiceModel.setUploader(this.userService.findUserByUsername(username));
        tubeServiceModel.setYouTuBeLink(tubeUploadBindingModel.getYouTuBeLink().split("=")[1]);

        this.tubeService.uploadTube(tubeServiceModel);

        this.redirect("/home");
    }
}
