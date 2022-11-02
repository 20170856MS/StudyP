package com.iu.home.List;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ListService {
	
	@Autowired
	private ListMapper listMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.upload.list}")
	private String path;
	
	public List<ListVO> getList(Pager pager) throws Exception{
		
		pager.makeRow();
		return listMapper.getList(pager);
	}
	
	public int setAdd(ListVO listVO) throws Exception{
		int result = listMapper.setAdd(listVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check=file.mkdirs();
		}
	
		
		
		for(MultipartFile f : listVO.getFiles()) {

			if(!f.isEmpty()) {
				log.info("FileName : {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				ListFileVO listFileVO = new ListFileVO();
				listFileVO.setFileName(fileName);
				listFileVO.setOriName(f.getOriginalFilename());
				listFileVO.setNum(listVO.getNum());
				listMapper.setFileAdd(listFileVO);
				
			}
		}
		
		return result;
	}
	
	public ListVO getDetail(ListVO listVO)throws Exception{
		return listMapper.getDetail(listVO);
	}
	
	
	public int setDeleteFile(ListFileVO listFileVO)throws Exception{
		listFileVO = listMapper.getDetailFile(listFileVO);
		int result = listMapper.setDeleteFile(listFileVO);
		
		if(result>0) {
			File file = new File(path, listFileVO.getFileName());
			file.delete();
		}
		
		return result;
		
	}
}
