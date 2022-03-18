package com.launchcode.gamersunite.models.data;

import com.launchcode.gamersunite.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostDao extends CrudRepository<Post, Integer> {
}
