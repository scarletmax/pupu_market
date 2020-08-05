package com.cykj.marketshop.service;

import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Notice;
import com.cykj.marketpojo.Role;

import java.util.HashMap;
import java.util.List;

public interface NoticeService {
    public List<String> findNoticeState();
    public LayData findNoticeList(HashMap<String, Object> condition);
    public boolean updateNoticeState(int id, String state);
    public int addNotice(Notice notice);
    public int updateNotice(Notice notice);
}
