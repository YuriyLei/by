package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.Attachment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/22.
 */
public interface AttachmentRepository extends BaseRepository<Attachment,Long> {
    List<Attachment> findAllByShortId(String shortId);
}
