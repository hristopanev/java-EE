package repository;

import domain.entites.Channel;

import java.util.List;

public interface ChannelRepository {

    Channel save(Channel channel);

    List<Channel> findALl();

    Channel findById(String id);


}
