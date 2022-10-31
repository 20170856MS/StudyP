package com.iu.home.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.util.Pager;

@Service
public class ListService {
	
	@Autowired
	private ListMapper listMapper;
	
	public List<ListVO> getList(Pager pager) throws Exception{
		
		pager.makeRow();
		return listMapper.getList(pager);
	}
	
	public int setAdd(ListVO listVO) throws Exception{
		int result = listMapper.setAdd(listVO);
		
		return result;
	}
}
