package com.cykj.marketadmin.service;



import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Level;
import java.util.HashMap;

public interface LevelService {
    public LayData findLevelList(HashMap<String, Object> condition);
    public int addLevel(Level level);
    public int editLevel(Level level);
    public int deleteLevel(int id);
}
