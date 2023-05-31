package com.example.test.testyangte.service.impi;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.test.testyangte.dao.TestMapper;
import com.example.test.testyangte.entity.*;
import com.example.test.testyangte.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;



    ///有查询条件
    @Override
    public PageInfo<Goods> Findbykey(String searchKey, int start, int end) {
        List<Goods> goodsList=this.testMapper.Findbykey(searchKey,start,end);
        PageInfo pageInfo=new PageInfo();
        pageInfo.setList(goodsList);
        pageInfo.setTotal((long) goodsList.size());
        return pageInfo;
    }

    //没有查询条件
    @Transactional(readOnly = true)
    @Override
    public PageInfo<Goods> loadList(int start, int end) {
        //分页可以有两种方法，一种直接用pagehelper插件，直接起始页和每页条数设置进去   sql语句会自动带上limit条件
        //二种将参数当前页和每页条数拿出来，计算出开始数，然后写sql加上limit
      //使用分页插件
       /* PageHelper.startPage(pageParam.getCurrentPage(),pageParam.getPageSize());
        Page<Goods> page=this.testMapper.loadList(pageParam);
        PageInfo pageInfo=new PageInfo();
        pageInfo.setTotal((long) page.getResult().size());
        pageInfo.setList(page.getResult());
        return   pageInfo;*/
        List<Goods> goods = this.testMapper.loadList(start,end);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal((long) goods.size());
        pageInfo.setList(goods);
        return pageInfo;

    }


    @Override
    public boolean delete(Integer id) {
        int result = this.testMapper.delete(id);
        return result>0? true:false;
    }

    @Override
    public Integer deleteInBatch(Integer[] ids) {
        return this.testMapper.deleteInBatch(ids);

    }

    @Override
    public boolean input(SaleDetail saleDetail) {
        int count = this.testMapper.input(saleDetail);
        return count > 0;
    }

    @Override
    public boolean update(Goods goods) {
        int count = this.testMapper.update(goods);
        return count > 0;
    }

    @Override
    public Map<String,Object> select() {
        Map<String,Object> select = testMapper.select();
                return (Map<String, Object>) select;
    }


    //-----------------------------------------------mybaties-plus-------------------------------------------------
    @Override
    public PageInfo<Goods> Select(PageParam pageParam) {
        List<Goods> goods = testMapper.selectList(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getGoodsid, pageParam.getSearchKey())
        );
        return null;
    }

}
