package cookbook.web.beans;

import cookbook.domain.models.binding.PostCreateBindingModel;
import cookbook.domain.models.service.PostServiceModel;
import cookbook.service.PostService;
import org.modelmapper.ModelMapper;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Named
@RequestScoped
public class PostUploadImage {
    private PostCreateBindingModel postCreateBindingModel;


    private ModelMapper modelMapper;
    private PostService postService;

    public PostUploadImage() {
    }

    @Inject
    public PostUploadImage(ModelMapper modelMapper, PostService postService) {
        this.modelMapper = modelMapper;
        this.postService = postService;
    }

    public void upload(FileUploadEvent event) throws IOException {
        UploadedFile file = event.getFile();
        String fileName = file.getFileName();
        long fileSize = file.getSize();
        InputStream is = file.getInputstream();


        byte[] bytes = is.readAllBytes();
        PostServiceModel postServiceModel = this.modelMapper
                .map(this.postCreateBindingModel, PostServiceModel.class);
        postServiceModel.setImage(is.readAllBytes());

        System.out.println();
    }
}


//    private Part uploadedFile;
//    private String folder = "D:\\Project\\CookBook\\src\\main\\webapp\\resources";
//
//    public PostUploadImage() {
//    }
//
//    @Inject
//    public PostUploadImage(ModelMapper modelMapper, PostService postService) {
//        this.modelMapper = modelMapper;
//        this.postService = postService;
//    }
//
//    public Part getUploadedFile() {
//        return uploadedFile;
//    }
//
//    public void setUploadedFile(Part uploadedFile) {
//        this.uploadedFile = uploadedFile;
//    }
//
//
//    public void saveFile(){
//
//        try (InputStream input = uploadedFile.getInputStream()) {
//            String fileName = uploadedFile.getSubmittedFileName();
//            Files.copy(input, new File(folder, fileName).toPath());
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }