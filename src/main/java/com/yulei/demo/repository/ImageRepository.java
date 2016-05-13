package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.Image;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lei.yu on 2016/5/13.
 */
public interface ImageRepository extends BaseRepository<Image,Long> {
    @Query(value = "select * from image a where a.deleted=0 and a.is_carousel=1 order by a.created_at limit 0,5",nativeQuery = true)
    List<Image> findCarouselTopFive();
    @Query(value = "select * from image a where a.deleted=0 and a.is_carousel=0 order by a.created_at limit 0,10",nativeQuery = true)
    List<Image> findImageTopTen();
}
