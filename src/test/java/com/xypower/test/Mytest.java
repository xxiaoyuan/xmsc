package com.xypower.test;

import com.xypower.mapper.ProductInfoMapper;
import com.xypower.pojo.ProductInfo;
import com.xypower.pojo.vo.ProductInfoVo;
import com.xypower.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class Mytest {
    @Autowired
    ProductInfoMapper mapper;
    @Test
    public void testMD5(){
        String mi = MD5Util.getMD5("000000");
        System.out.println(mi);
    }
    @Test
    public void testSelectCondition(){
        ProductInfoVo vo = new ProductInfoVo();
        vo.setPname("4");
        vo.setTypeid(3);
        vo.setLprice(3000);
        List<ProductInfo> list = mapper.selectCondition(vo);
        list.forEach(ProductInfo-> System.out.println(ProductInfo));
    }
}
