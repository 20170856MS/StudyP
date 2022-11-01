package com.iu.home.util;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.home.List.ListFileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView{
	@Value("${app.download.base}")
	private String base;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ListFileVO listFileVO = (ListFileVO)model.get("fileVO");
		String path = (String)model.get("path");
		log.info("=======fileManager========");
		log.info("FILEVO {}",listFileVO);
		
		File file = new File(base+path, listFileVO.getFileName());
		
	}
}
