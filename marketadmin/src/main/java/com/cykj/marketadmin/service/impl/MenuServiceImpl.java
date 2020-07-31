package com.cykj.marketadmin.service.impl;


import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.mapper.MenuMapper;
import com.cykj.marketadmin.service.MenuService;

import com.cykj.marketpojo.AttrMsg;
import com.cykj.marketpojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getMenu(int roleId) {
        return menuMapper.getMenu(roleId);
    }

    @Override
    public AttrMsg queryAttr(int roleId) {
        /*查询已分配*/
        //获取父级菜单
        List<Menu> attrList=menuMapper.getMenuByPid(0,roleId);
        List<Menu> childList= new ArrayList<>();//已分配子菜单
        //根据父级菜单获取分配的子菜单
        int num=attrList.size();
        for (int i = 0; i <num; i++) {
            List<Menu> attrChild=menuMapper.getMenuByPid(attrList.get(i).getId(),roleId);
            for (int j = 0; j <attrChild.size(); j++) {
                attrList.add(attrChild.get(j));
                childList.add(attrChild.get(j));
            }
        }
        System.out.println(childList.size()+"已分配的子菜单"+ JSON.toJSONString(childList));

        /*查询未分配*/
        //查询所有子菜单
        List<Menu> unAttrList=new ArrayList<>();
        List<Menu> allChild=menuMapper.queryAllChild();
        System.out.println(allChild.size()+"所有的子菜单"+JSON.toJSONString(allChild));

        //遍历 如果不存在则加入到未分配集合 获取子菜单
        for (int i = 0; i < allChild.size(); i++) {
            int menuId= allChild.get(i).getId();
            int temp=0;
            for (int j = 0; j <childList.size() ; j++) {
                if(menuId==childList.get(j).getId().intValue()){
                    break;
                }else {
                    temp++;
                }
            }
            if(temp==childList.size()) {
                unAttrList.add(allChild.get(i));
            }
        }
        System.out.println(unAttrList.size()+"先获得未分配的子菜单"+JSON.toJSONString(unAttrList));
        //获取未分配子菜单的父级菜单
        List<Integer> parentIdList=new ArrayList<>();
        for (int i = 0; i < unAttrList.size(); i++) {
            int parentId=unAttrList.get(i).getParentId().intValue();
            if(!parentIdList.contains(parentId)) {
                parentIdList.add(parentId);
            }
        }
        for (int i = 0; i < parentIdList.size(); i++) {
            unAttrList.add(menuMapper.getMenuById(parentIdList.get(i)));
        }

        System.out.println(unAttrList.size()+"最后加入父级菜单"+JSON.toJSONString(unAttrList));



        return new AttrMsg(attrList,unAttrList);
    }

    @Override
    public boolean removeAttr(int roleId,String arr) {
        String[] menuArr = arr.split(",");
        for (int i = 0; i < menuArr.length; i++) {
            menuMapper.removeAttr(roleId,Integer.parseInt(menuArr[i]));
        }
        //获取父级菜单
        List<Menu> attrList=menuMapper.getMenuByPid(0,roleId);
        List<Menu> childList= new ArrayList<>();//已分配子菜单
        //根据父级菜单获取分配的子菜单
        for (int i = 0; i <attrList.size(); i++) {
            List<Menu> attrChild=menuMapper.getMenuByPid(attrList.get(i).getId().intValue(),roleId);
            //如果父目录下没有子目录了 则把父目录的关系也删除
            if(attrChild.size()==0) {
                menuMapper.removeAttr(roleId,attrList.get(i).getId().intValue());
            }
        }
        return true;
    }

    @Override
    public boolean newAttr(int roleId, String arr) {
        String[] menuArr = arr.split(",");
        //获取现有的菜单
        List<Menu> menuList= getAttr(roleId);
        List<Integer> newAttrIdList=new ArrayList<>();
        for (int i = 0; i < menuArr.length; i++) {
            int x= Integer.parseInt(menuArr[i]);
            boolean flag=true;
            for (int j = 0; j <menuList.size() ; j++) {
                if(menuList.get(j).getId().intValue()==x) {
                    flag=false;
                    break;
                }
            }
            if(flag) {
                newAttrIdList.add(x);
            }
        }
        //插入新分配数据
        for (int i = 0; i < newAttrIdList.size(); i++) {
            menuMapper.newAttr(roleId,newAttrIdList.get(i));
        }
        //判断是否有父级菜单没插入，但是他的子菜单插入的情况
        List<Integer> numList= menuMapper.getUnInsert(roleId);
        if(numList.size()!=0) {
            for (int i = 0; i <numList.size() ; i++) {
                menuMapper.newAttr(roleId,numList.get(i));
            }
        }
        return true;
    }

    public List<Menu> getAttr(int roleId) {
        /*查询已分配*/
        //获取父级菜单
        List<Menu> attrList=menuMapper.getMenuByPid(0,roleId);
        List<Menu> childList= new ArrayList<>();//已分配子菜单
        //根据父级菜单获取分配的子菜单
        int num=attrList.size();
        for (int i = 0; i <num; i++) {
            List<Menu> attrChild=menuMapper.getMenuByPid(attrList.get(i).getId().intValue(),roleId);
            for (int j = 0; j <attrChild.size(); j++) {
                attrList.add(attrChild.get(j));
                childList.add(attrChild.get(j));
            }
        }
        //查询所有的子类

        return attrList;
    }
}
