package cookbook.service;

import cookbook.domain.entities.Post;
import cookbook.domain.models.service.PostServiceModel;
import cookbook.repository.PostRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Inject
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void postCreate(PostServiceModel postServiceModel) {
         Post post = this.modelMapper.map(postServiceModel, Post.class);
                 this.postRepository.save(post);
    }

    @Override
    public List<PostServiceModel> findAllPost(Post post) {
        return this.postRepository
                .findAllPosts(post)
                .stream()
                .map(p -> this.modelMapper.map(p, PostServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostServiceModel> findAllPost() {
        return this.postRepository.findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, PostServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void postEdit(String id) {

        //TODO
    }

    @Override
    public PostServiceModel getPostById(String id) {
        return this.modelMapper.map(this.postRepository.findById(id), PostServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.postRepository.delete(id);
    }

    @Override
    public List<PostServiceModel> getAllUsersPosts(String id) {
        return this.postRepository.findAllUserPostsById(id)
                .stream()
                .map(p -> this.modelMapper.map(p, PostServiceModel.class))
                .collect(Collectors.toList());
    }
}
