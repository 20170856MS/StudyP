package com.iu.home.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

@Controller
@RequestMapping("/list/*")
public class ListController {
	
	@Autowired
	private ListService listService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ListVO> ar = listService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("list/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public String setAdd()throws Exception{
		return "list/add";
	}
	
	@PostMapping("add")
	public String setAdd(ListVO listVO, RedirectAttributes redirectAttributes)throws Exception{
		
		int result = listService.setAdd(listVO);
		redirectAttributes.addAttribute("result", result);
		
		return "redirect:./list";
	}
	
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int setFileDelete(ListFileVO listFileVO)throws Exception{
		int result = listService.setDeleteFile(listFileVO);
		
		return result;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(ListVO listVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list/update");
		listVO = listService.getDetail(listVO);
		mv.addObject("vo", listVO);
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(ListVO listVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		listVO=listService.getDetail(listVO);
		mv.addObject("vo", listVO);
		mv.setViewName("list/detail");
		return mv;
	}
}
