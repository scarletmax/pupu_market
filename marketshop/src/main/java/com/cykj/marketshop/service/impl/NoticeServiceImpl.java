package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Notice;
import com.cykj.marketpojo.Role;
import com.cykj.marketshop.mapper.NoticeMapper;
import com.cykj.marketshop.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<String> findNoticeState() {
        List<String> noticeList = null;
        noticeList = noticeMapper.findNoticeState();
        return noticeList;
    }

    @Override
    public LayData findNoticeList(HashMap<String, Object> condition) {
        LayData layuiData = new LayData();
        List<Notice> noticeList = noticeMapper.findNoticeList(condition);
        int count = noticeMapper.findNoticeCount(condition);
        if (noticeList.size() > 0) {
            layuiData.setCode(0);
            layuiData.setMsg("");
            layuiData.setCount(count);
            layuiData.setData(noticeList);
        } else {
            layuiData.setCode(1);
            layuiData.setMsg("加载失败");
        }
        return layuiData;
    }

    @Override
    public boolean updateNoticeState(int id, String state) {
        int result=0;
        result = noticeMapper.updateNoticeState(id, state);
        return result > 0;
    }

    @Override
    public int addNotice(Notice notice) {
        int a=0;
        a = noticeMapper.addNotice(notice);
        return a;
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }
}
