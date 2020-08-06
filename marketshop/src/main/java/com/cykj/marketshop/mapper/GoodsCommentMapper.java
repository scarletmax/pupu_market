package com.cykj.marketshop.mapper;


import com.cykj.marketpojo.GoodsComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsCommentMapper {

    List<GoodsComment> findGoodsComment(HashMap<String, Object> hashMap);

}
