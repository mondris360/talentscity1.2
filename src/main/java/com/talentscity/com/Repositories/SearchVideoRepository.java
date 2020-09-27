package com.talentscity.com.Repositories;

import com.talentscity.com.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchVideoRepository extends JpaRepository<Video, Long> {
    List<Video>  findByDescriptionIsContainingOrTitleContaining(String searchword1, String searchword2);
}
