package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> getNoticeList();
}
