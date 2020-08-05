package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.Notice;
import com.cykj.marketpojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeMapper   {
    List<String> findNoticeState();
    List<Notice> findNoticeList(HashMap<String, Object> condition);
    int  findNoticeCount(HashMap<String, Object> condition);
    int updateNoticeState(int id, String state);
    int addNotice(Notice notice);
    int updateNotice(Notice notice);

}
