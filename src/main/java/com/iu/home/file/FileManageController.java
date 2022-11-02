package com.iu.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.List.ListFileVO;
import com.iu.home.List.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileManageController {
	@Autowired
	private ListService listService;
	
	@GetMapping("/fileDown/{p}")
	public ModelAndView fileDown(@PathVariable(name = "p") String path, ListFileVO listFileVO) throws Exception{
		log.info("Path : {}",path);
		
		ModelAndView mv = new ModelAndView();
		
		if(path.equals("qna")) {
			//qnaFileVO = qnaService.getFileDetail();
		}else if(path.equals("notice"))
		
		mv.addObject("fileVO", listFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		// BeanNameResolver : 
		// view의 이름과 일치하는 bean의 이름이 있으면 해당 Bean실행
		
		// InternalResourceViewResolver
		// /WEB-INF/views/fileManger.jsp
		return mv;
	}
}
