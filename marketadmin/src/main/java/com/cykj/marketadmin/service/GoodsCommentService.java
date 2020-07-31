package com.cykj.marketadmin.service;



import com.cykj.marketpojo.GoodsComment;

import java.util.HashMap;
import java.util.List;

public interface GoodsCommentService {
    List<GoodsComment> findGoodsComment(HashMap<String, Object> hashMap);
}
