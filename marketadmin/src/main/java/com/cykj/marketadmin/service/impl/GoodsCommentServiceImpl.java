package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.GoodsCommentMapper;
import com.cykj.marketadmin.service.GoodsCommentService;
import com.cykj.marketpojo.GoodsComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired
    private GoodsCommentMapper goodsCommentMapper;

    @Override
    public List<GoodsComment> findGoodsComment(HashMap<String, Object> hashMap) {
        return goodsCommentMapper.findGoodsComment(hashMap);
    }
}
