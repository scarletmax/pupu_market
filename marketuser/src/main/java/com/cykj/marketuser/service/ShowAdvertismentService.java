package com.cykj.marketuser.service;

import com.cykj.marketpojo.Advertisement;

import java.util.List;

public interface ShowAdvertismentService {

    List<Advertisement> findCarouselAD();
    List<Advertisement> findStaticAD();
}
