package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Advertisement;
import com.cykj.marketuser.mapper.ShowAdvertismentMapper;
import com.cykj.marketuser.service.ShowAdvertismentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowAdvertismentServiceImpl implements ShowAdvertismentService {

    @Autowired
    private ShowAdvertismentMapper showAdvertismentMapper;
    @Override
    public List<Advertisement> findCarouselAD() {
        return showAdvertismentMapper.findCarouselAD();
    }

    @Override
    public List<Advertisement> findStaticAD() {
        return showAdvertismentMapper.findStaticAD();
    }
}
