package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.Advertisement;
import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.LayData;
import com.cykj.marketshop.mapper.AdMapper;
import com.cykj.marketshop.service.AdService;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service("adService")
public class AdServiceImpl implements AdService {
    @Autowired
    private AdMapper adMapper;
    @Override
    public LayData<Advertisement> showTable(HashMap<String, Object> condition) {
        List<Advertisement> advertisements = adMapper.queryAd(condition);
        int totalCount = adMapper.queryCount(condition);
        return new LayData<Advertisement>(0, "", totalCount, advertisements);

    }

    @Override
    public List<String> getAllType() {
        return adMapper.getAllType();
    }

    @Override
    public String updateState(int id, int state,int shopId) {
        //如果是停用 ，直接停用更改状态
        if(state==2) {
            return adMapper.updateState(id,state)>0?"success":"fail";
        }
        //如果是启用，需要先判断 目前启用广告个数是否已满（轮播图最多3个，静态1个）
        if(state==1){
            //判断该广告类型是否已配置满(大于0表示还有广告位置
            if(adMapper.queryTypeCount(id,shopId)>0) {
                return adMapper.updateState(id,state)>0?"success":"fail";
            }else {
                return "unavailable";
            }
        }
        return null;
    }

    @Override
    public Integer updateAd(Advertisement ad) {
        return adMapper.updateAd(ad);
    }

    @Override
    public Integer newAd(Advertisement ad) {
        return adMapper.newAd(ad);
    }


}
