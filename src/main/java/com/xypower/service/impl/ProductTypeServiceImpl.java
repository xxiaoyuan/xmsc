package com.xypower.service.impl;

import com.xypower.mapper.ProductTypeMapper;
import com.xypower.pojo.ProductType;
import com.xypower.pojo.ProductTypeExample;
import com.xypower.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
