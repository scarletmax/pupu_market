package com.cykj.marketadmin.service;


import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.LayData;

import java.util.HashMap;

public interface GoodsService {

    public LayData<Goods> searchGoodsList(HashMap<String, Object> condition);
}
