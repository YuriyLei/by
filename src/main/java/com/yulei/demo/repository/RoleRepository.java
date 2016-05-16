package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lei.yu on 2016/5/5.
 */
public interface RoleRepository extends BaseRepository<Role,Long>{
    List<Role> findAllByDeleted(String undeleted);
    @Query(value = "select count(*) from role r where r.deleted=0 ",nativeQuery = true)
    int countNotDelete();

}
