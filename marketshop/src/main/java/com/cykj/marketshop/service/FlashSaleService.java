package com.cykj.marketshop.service;


import com.cykj.marketpojo.FlashSale;
import com.cykj.marketpojo.LayData;
import com.cykj.marketshop.mapper.FlashSaleMapper;

import java.util.HashMap;

public interface FlashSaleService {

    public LayData<FlashSale> selectFlashSale(HashMap<String,Object> condition);

    public int insertFlashSale(FlashSale flashSale);
}
