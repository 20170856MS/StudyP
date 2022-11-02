package com.iu.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
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
		
		//한글 처리
		 response.setCharacterEncoding("UTF-8");
		 
		 //총 파일의 크기
		 response.setContentLengthLong(file.length());
		 
		 //다운로드시 파일의 이름을 인코딩
		 String oriName = URLEncoder.encode(listFileVO.getOriName(), "UTF-8");
		 
		 //header 설정
		 response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		 response.setHeader("Content-Transfer-Encoding", "binary");
		 
		 //HDD에서 파일을 읽고
		 FileInputStream fi = new FileInputStream(file);
		 //Client 로 전송 준비
		 OutputStream os = response.getOutputStream();
		 
		 //전송
		 FileCopyUtils.copy(fi, os);
		 
		 //자원 해제
		 os.close();
		 fi.close();
		
	}
}
