package com.yulei.demo.repository;

import com.yulei.demo.BaseRepository;
import com.yulei.demo.model.ViewFinder;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface ViewFinderRepository extends BaseRepository<ViewFinder,Long> {

    List<ViewFinder> findAllByParentIdAndDeleted(Long i, String undeleted);
}
