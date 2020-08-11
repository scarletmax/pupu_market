package com.cykj.marketpojo;

import java.util.List;

public class MainPageInfo {
    private List<Advertisement> carouselAdList; //轮播图广告集合 3张 （状态启用中
    private List<Goods> flashSaleList; //秒杀信息集合
    private List<Goods> recommendList; //推荐商品集合 6条 （状态销售中 1
    private List<Goods> newGoodsList; //新品集合 最新添加的6个商品 （状态销售中 1
    private List<Goods> bestSaleList; //畅销商品结合  6条 （状态销售中 1
    private List<Goods> specialPriceList; //特价商品集合 6条 （状态销售中 1

    public MainPageInfo() {
    }

    public MainPageInfo(List<Advertisement> carouselAdList, List<Goods> flashSaleList, List<Goods> recommendList, List<Goods> newGoodsList, List<Goods> bestSaleList, List<Goods> specialPriceList) {
        this.carouselAdList = carouselAdList;
        this.flashSaleList = flashSaleList;
        this.recommendList = recommendList;
        this.newGoodsList = newGoodsList;
        this.bestSaleList = bestSaleList;
        this.specialPriceList = specialPriceList;
    }

    public List<Advertisement> getCarouselAdList() {
        return carouselAdList;
    }

    public void setCarouselAdList(List<Advertisement> carouselAdList) {
        this.carouselAdList = carouselAdList;
    }

    public List<Goods> getFlashSaleList() {
        return flashSaleList;
    }

    public void setFlashSaleList(List<Goods> flashSaleList) {
        this.flashSaleList = flashSaleList;
    }

    public List<Goods> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<Goods> recommendList) {
        this.recommendList = recommendList;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<Goods> getBestSaleList() {
        return bestSaleList;
    }

    public void setBestSaleList(List<Goods> bestSaleList) {
        this.bestSaleList = bestSaleList;
    }

    public List<Goods> getSpecialPriceList() {
        return specialPriceList;
    }

    public void setSpecialPriceList(List<Goods> specialPriceList) {
        this.specialPriceList = specialPriceList;
    }
}
