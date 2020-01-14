package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

//当前这个服务实现的是哪个服务接口
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    public void add(CheckGroup checkGroup, Integer[] ids) {
        checkGroupDao.add(checkGroup);
        Integer checkGroupId = checkGroup.getId();
        if(ids!=null &&ids.length>0){
            for (Integer id : ids) {
                HashMap<String, Integer> map = new HashMap<>();
                map.put("checkgroup_id",checkGroupId);
                map.put("checkitem_id",id);
                checkGroupDao.addT_checkitem_checkgroup(map);
            }
        }
    }

    @Override
    public PageResult queryPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckGroup> checkItems = checkGroupDao.selectPageCondition(queryString);
        return new PageResult(checkItems.getTotal(),checkItems.getResult());
    }

    @Override
    public List<Integer> queryGroupWithItems(Integer checkgroup_id) {
        return checkGroupDao.queryGroupWithItems(checkgroup_id);
    }

    @Override
    public void deleteById(Integer id) {
        checkGroupDao.deleteGroupAndItemKey(id);
        checkGroupDao.deleteById(id);
    }

    @Override
    public List<CheckGroup> findAll() {
        return checkGroupDao.findAll();
    }
}
