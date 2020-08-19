package com.cykj.marketuser.service;

import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getShops(String longitude,String latitude);
    List<Marker> getAllShopMarkers();

}
