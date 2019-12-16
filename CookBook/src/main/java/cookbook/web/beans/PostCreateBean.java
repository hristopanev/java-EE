package cookbook.web.beans;

import cookbook.domain.models.binding.PostCreateBindingModel;
import cookbook.domain.models.service.PostServiceModel;
import cookbook.service.PostService;
import cookbook.service.UserService;
import org.modelmapper.ModelMapper;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Part;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class PostCreateBean extends BaseBean {

    private List<String> users;
    private PostCreateBindingModel postCreateBindingModel;

    private PostService postService;
    private UserService userService;
    private ModelMapper modelMapper;


//    private Part file;
//    private String fileContent;

    public PostCreateBean() {
    }

    @Inject
    public PostCreateBean(PostService postService, UserService userService,ModelMapper modelMapper) {
        this.postService = postService;
        this.userService = userService;
        this.modelMapper = modelMapper;

        this.initUser();
        this.initModel();
    }

    private void initUser() {
        this.users = this.userService.findAllUsers()
                .stream()
                .map(u -> u.getUsername())
                .collect(Collectors.toList());
    }

    private void initModel() {
        this.postCreateBindingModel = new PostCreateBindingModel();
    }

    public List<String> getUsers() {
        return this.users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public PostCreateBindingModel getPostCreateBindingModel() {
        return this.postCreateBindingModel;
    }

    public void setPostCreateBindingModel(PostCreateBindingModel postCreateBindingModel) {
        this.postCreateBindingModel = postCreateBindingModel;
    }

    public void create() {

        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

        PostServiceModel postServiceModel = this.modelMapper
                .map(this.postCreateBindingModel, PostServiceModel.class);

        postServiceModel.setPostTime(LocalDateTime.now());
            postServiceModel
                .setPosts(this.userService.findUserByUsername(username));

        this.postService
                .postCreate(postServiceModel);



        this.redirect("/home");
    }

//    public void upload(FileUploadEvent event) throws IOException {
//        UploadedFile file = event.getFile();
//        String fileName = file.getFileName();
//        long fileSize = file.getSize();
//        InputStream is = file.getInputstream();
//
//        byte[] bytes = is.readAllBytes();
//        PostServiceModel postServiceModel = this.modelMapper.map(this.postCreateBindingModel, PostServiceModel.class);
//        postServiceModel.setImage(bytes);
//    }



}
