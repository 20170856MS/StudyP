package com.iu.home.List;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.home.util.Pager;

@Mapper
public interface ListMapper {
	public List<ListVO> getList(Pager pager)throws Exception;
	
	public int setAdd(ListVO listVO) throws Exception;
	
}
