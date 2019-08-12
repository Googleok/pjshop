package com.cafe24.pjshop.frontend.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.pjshop.frontend.util.MimeMediaUtil;
import com.cafe24.pjshop.frontend.util.UploadFileUtils;

@Controller
public class UploadController {

//	private static final String SAVE_PATH = "C:/Users/USER/Desktop/pjshop-project/shop-uploads/";
	private static final String SAVE_PATH = "/shop-uploads/";
	private static final String URL = "/assets/image";
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public void uploadForm() {
	
		
	}
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model) throws Exception{
		logger.info("originalName: "+file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: "+file.getContentType());
		
		String savedName = 
				uploadFile(file.getOriginalFilename(), file.getBytes());
		
		model.addAttribute("savedName", savedName);
		
		return "uploadResult";
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax(){
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{
		logger.info("originalName: "+file.getOriginalFilename());
	
		return new ResponseEntity<String>(
				UploadFileUtils.uploadFile(SAVE_PATH,
						file.getOriginalFilename(),
						file.getBytes()),
				HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/productImageUploadAjax", method=RequestMethod.GET)
	public void snsUploadAjax(){
	}
	
	@RequestMapping(value="/productImageUploadAjax", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> snsUploadAjax(MultipartFile file)throws Exception{
		logger.info("originalName: "+file.getOriginalFilename());
	
		return new ResponseEntity<String>(
				UploadFileUtils.snsUploadFile(SAVE_PATH,
						file.getOriginalFilename(),
						file.getBytes()),
				HttpStatus.CREATED);
	}
	
	private String uploadFile(String originalName, byte[] fileData)
	throws Exception{
		
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(SAVE_PATH, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	@ResponseBody
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		System.out.println(fileName);
		logger.info("FILE NAME : " + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MimeMediaUtil.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(URL+fileName);
			
			System.out.println(in + "====================in=====================");
			
			if(mType != null) {
				headers.setContentType(mType);
			}else if(formatName.equals(".mp4")){
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.MULTIPART_FORM_DATA);
				headers.add("Content-Disposition", "attachment); filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment); filename=\""+
						new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
		
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
			System.out.println("getbody===" + entity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		System.out.println(entity + "==============entity=============");
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		logger.info("delete file: "+ fileName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType = MimeMediaUtil.getMediaType(formatName);
		
		if(mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(SAVE_PATH + (front+end).replace('/', File.separatorChar)).delete();
		}
		
		new File(SAVE_PATH + fileName.replace('/', File.separatorChar)).delete();
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteAllFiles", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files){
		logger.info("delete all files: "+ files);
		
		if(files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
		
		for(String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MimeMediaUtil.getMediaType(formatName);
					
			if(mType != null) {
				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(SAVE_PATH + (front+end).replace('/', File.separatorChar)).delete();
			}
			new File(SAVE_PATH + fileName.replace('/', File.separatorChar)).delete();
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	
	
	
	
}