package repository;

import domain.entites.Channel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ChannelRepositoryImpl implements ChannelRepository {

    private final EntityManager entityManager;

    @Inject
    public ChannelRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Channel save(Channel channel) {
        this.entityManager.getTransaction().begin();
            this.entityManager.persist(channel);
        this.entityManager.getTransaction().commit();
        return channel;
    }

    @Override
    public List<Channel> findALl() {

        this.entityManager.getTransaction().begin();
            List<Channel> channels = this.entityManager
                    .createQuery("SELECT c FROM Channel c", Channel.class)
                    .getResultList();
        this.entityManager.getTransaction().commit();

        return channels;
    }

    @Override
    public Channel findById(String id) {
        this.entityManager.getTransaction().begin();
            Channel channel = this.entityManager
                    .createQuery("SELECT c FROM Channel c WHERE c.id =:id", Channel.class)
                    .setParameter("id", id)
                    .getSingleResult();
        this.entityManager.getTransaction().commit();

        return channel;
    }
}
