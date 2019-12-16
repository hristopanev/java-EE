package cookbook.repository;

import cookbook.domain.entities.Post;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class PostRepositoryImpl extends BaseRepository implements PostRepository{

    private final EntityManager entityManager;

    @Inject
    public PostRepositoryImpl(EntityManager entityManager, EntityManager entityManager1) {
        super(entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public void delete(String id) {
        this.executeTransaction((em) -> {
            em.createNativeQuery("DELETE  FROM posts WHERE id = '"+ id +"'").executeUpdate();
            return null;
        });
    }

    @Override
    public Post editPost(Post post) {
        this.entityManager.getTransaction().begin();
        Post edit = this.entityManager.merge(post);
        this.entityManager.getTransaction().commit();

        return edit;
    }

    @Override
    public List<Post> findAllPosts(Post post) {
        this.entityManager.getTransaction().begin();
        List<Post> posts = this.entityManager
                .createQuery("SELECT p FROM Post p", Post.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return posts;
    }

    @Override
    public Post save(Post entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Post> findAll() {
        this.entityManager.getTransaction().begin();
        List<Post> posts = this.entityManager
                .createQuery("SELECT p FROM Post p ORDER BY p.postTime desc", Post.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return posts;
    }

    @Override
    public Post findById(String id) {
        this.entityManager.getTransaction().begin();
        Post post = this.entityManager
                .createQuery("SELECT p FROM Post p WHERE p.id = :id", Post.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return post;
    }

    @Override
    public Long size() {
        this.entityManager.getTransaction().begin();
        Long size = this.entityManager
                .createQuery("SELECT count(p) FROM Post p", Long.class)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return size;
    }

    @Override
    public List<Post> findAllUserPostsById(String id) {
        this.entityManager.getTransaction().begin();
        List<Post> posts = this.entityManager
                .createQuery("SELECT p FROM Post p WHERE p.posts.id =:id", Post.class)
                .setParameter("id", id)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return posts;
    }

    @Override
    public Post update(Post post) {
        this.entityManager.getTransaction().begin();

        try {
            Post updatePost = this.entityManager.merge(post);
            this.entityManager.getTransaction().commit();

            return updatePost;
        }catch (Exception e) {
            this.entityManager.getTransaction().rollback();

            return null;
        }
    }
}
