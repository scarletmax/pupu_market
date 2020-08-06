package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Level;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LevelMapper {
    List<Level> findLevelList(HashMap<String, Object> condition);
    int  findLevelCount(HashMap<String, Object> condition);
    int  addLevel(Level level);
    int editLevel(Level level);
    int deleteLevel(int id);
}
