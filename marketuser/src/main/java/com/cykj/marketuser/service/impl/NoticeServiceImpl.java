package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Notice;
import com.cykj.marketuser.mapper.GoodMapper;
import com.cykj.marketuser.mapper.NoticeMapper;
import com.cykj.marketuser.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticeList() {
        return noticeMapper.getNoticeList();
    }
}
