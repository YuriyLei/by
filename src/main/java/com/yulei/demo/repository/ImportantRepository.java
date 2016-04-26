package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.Important;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface ImportantRepository extends BaseRepository<Important,Long>{
    @Query(value = "select i from important i where i.deleted=0 order by i.created_at desc limit 0,10",nativeQuery = true)
    List<Important> findTopTen();
}
