package com.cykj.marketshop.service;


import com.cykj.marketpojo.GoodsComment;

import java.util.HashMap;
import java.util.List;

public interface GoodsCommentService {
    //商品评论
    List<GoodsComment> findGoodsComment(HashMap<String, Object> hashMap);
}
