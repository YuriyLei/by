package com.yulei.demo.repository;

import com.yulei.demo.BaseRepository;
import com.yulei.demo.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 余磊 on 2016/5/29.
 */
public interface NewsRepository extends BaseRepository<News,Long> {
    Page<News> findAllByDeletedAndType(Pageable pageable, String undeleted, Long type);
    @Query(value = "select * from news n where n.deleted=:deleted and n.type=:newsType order by n.created_at limit 0,10",nativeQuery =true)
    List<News> findTopTen(@Param("deleted") String undeleted, @Param("newsType") long l);
}
