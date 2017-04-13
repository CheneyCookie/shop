package com.shop.dao;

import java.util.List;

import com.shop.bean.Category;


public interface CategoryDao extends BaseDao<Category>{
	//查询类别信息，级联管理员
	public List<Category> queryJoinAccount(String type,int page,int size);
	//根据关键字查询总记录数
	public Long getCount(String type);
	//根据id删除多条记录
	public void deleteByIds(String ids);
	public List<Category> queryByHot(boolean hot);
}
