package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.Role;
import com.yulei.demo.model.User;
import com.yulei.demo.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by lei.yu on 2016/5/5.
 */
public interface UserRoleRepository extends BaseRepository<UserRole,Long> {
    @Query(value = "select ur.roleId from UserRole ur where ur.userId = :id")
    List<Long> findRoleIdByUserId(@Param("id")Long id);
}
