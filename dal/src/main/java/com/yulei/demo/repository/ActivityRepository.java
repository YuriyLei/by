package com.yulei.demo.repository;

import com.yulei.demo.BaseRepository;
import com.yulei.demo.model.Activity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface ActivityRepository extends BaseRepository<Activity,Long> {
    @Query(value = "select * from activity a where a.deleted=0 order by a.created_at limit 0,10",nativeQuery = true)
    List<Activity> findTopTen();
}
