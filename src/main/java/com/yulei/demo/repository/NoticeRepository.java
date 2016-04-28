package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.Notice;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface NoticeRepository extends BaseRepository<Notice,Long> {
    @Query(value = "select * from notice n where n.deleted=0 order by n.created_at desc limit 0,10",nativeQuery = true)
    List<Notice> findTopTen();

}
