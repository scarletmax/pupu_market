package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.*;
import com.cykj.marketshop.service.GoodsService;
import com.cykj.marketshop.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping("goodsControl")
public class GoodsControl {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/searchGoodsList")
    public String searchGoodsList(HttpServletRequest request, HttpServletResponse response){
        String curPage = request.getParameter("curPage");
        String pageSize = request.getParameter("pageSize");
        int shopId = ((ShopAdmin)(request.getSession().getAttribute("admin"))).getShopId();
        String name = request.getParameter("name");
        String typeId = request.getParameter("typeId");
        String parentTypeId = request.getParameter("parentTypeId");
        String price_min = request.getParameter("price_min");
        String price_max = request.getParameter("price_max");
        String state = request.getParameter("state");


        int curPage1 = Integer.parseInt(curPage);
        int pageSize1 = Integer.parseInt(pageSize);
        int offset1 = (curPage1-1)*pageSize1;

        HashMap<String,Object> condition = new HashMap<>();
        condition.put("offset",offset1);
        condition.put("pageSize",pageSize1);//name和shopid为可选搜索项，因此没点击搜索失为null或，点击时可能有数值或者为""
        condition.put("shopId",shopId);//mysql中的int和传上的string可以兼容
        condition.put("name",name);
        condition.put("typeId",typeId);
        condition.put("parentTypeId",parentTypeId);
        condition.put("price_min",price_min);
        condition.put("price_max",price_max);
        condition.put("state",state);
        return JSON.toJSONString(goodsService.searchGoodsList(condition));
    }

    @RequestMapping("/startRecommended")
    public String startRecommended(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.startRecommended(id)+"");
    }

    @RequestMapping("/endRecommended")
    public String endRecommended(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.endRecommended(id)+"");
    }

    @RequestMapping("/startSpecial")
    public String startSpecial(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.startSpecial(id)+"");
    }

    @RequestMapping("/endSpecial")
    public String endSpecial(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.endSpecial(id)+"");
    }

    @RequestMapping("/startFlashSale")
    public String startSFlashSale(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.startFlashSale(id)+"");
    }

    @RequestMapping("/endFlashSale")
    public String endFlashSale(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.endFlashSale(id)+"");
    }

    @RequestMapping("/putaway")
    public String putaway(int[] idArr,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.putaway(idArr)+"");
    }

    @RequestMapping("/unshelve")
    public String unshelve(int[] idArr,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.unshelve(idArr)+"");
    }

    @RequestMapping("/deleteGoods")
    public String deleteGoods(int[] idArr,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.deleteGoods(idArr)+"");
    }

    @RequestMapping("/detailPic")
    public String detailPic(String id){
        return JSON.toJSONString(goodsService.detailPic(id));
    }

    @RequestMapping(value = "/detailPicUpload")
    @ResponseBody
    public String upload(HttpServletRequest request, HttpServletResponse response,@RequestParam("file") MultipartFile thisFile) throws ServletException, IOException {
        try {
            //获取文件名
            String originalName = thisFile.getOriginalFilename();
            //获取扩展名
            String suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
            //使用UUID+后缀名保存文件名，防止中文乱码问题
            String uuid = UUID.randomUUID() + "";
            boolean ftpUpload= FtpUtil.uploadFile("120.25.147.141",21,"ftpmax","ftpmax","/home/ftpmax/","/upload/goods_pic",uuid + "." + suffix,thisFile.getInputStream() );

//            String savePath = request.getSession().getServletContext().getRealPath("/upload/goods_pic");
//            //最终实际保存路径
//            String filePath = savePath + File.separator + uuid + "." + suffix;
//            File files = new File(filePath);
//            //打印查看上传路径
//            if (!files.getParentFile().exists()) {//判断目录是否存在，否则创建父目录
//                files.getParentFile().mkdirs();
//            }
//            thisFile.transferTo(files); // 将接收的文件保存到指定文件中

            LayData<String> layData=new LayData<String>();
            layData.setCode(0);
            layData.setData(Collections.singletonList(uuid + "." + suffix));
            System.out.println("url"+layData.getData().toString());
            return JSON.toJSONString(layData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping("/addGoods")
    public String addGoods(Goods goods,HttpServletRequest request, HttpServletResponse response){
        int shopId = ((ShopAdmin)(request.getSession().getAttribute("admin"))).getShopId();
        goods.setShopId(shopId);
        return JSON.toJSONString(goodsService.addGoods(goods)+"");
    }

    @RequestMapping("/editGoods")
    public String editGoods(Goods goods,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.editGoods(goods)+"");
    }

}
