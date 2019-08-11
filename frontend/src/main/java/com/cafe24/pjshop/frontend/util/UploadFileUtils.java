package com.cafe24.pjshop.frontend.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	private static final String PREFIX_URL = "/assets/image/"; //저장된 파일을 jsp에서 불러오기 위한 경로
	
	// 날짜별로 폴더 생성해서 경로 설정
	public static String calcPath(String uploadPath)throws Exception{
		
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		
		String monthPath = yearPath +
				File.separator +
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		
		String datePath = monthPath +
				File.separator + 
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath,monthPath,datePath);
		
		logger.info(datePath);
		
		return datePath;
	}
	
	// 폴더 생성
	public static void makeDir(String uploadPath, String... paths) {
		if(new File(paths[paths.length-1]).exists()) {
			return;
		}
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	
	// 파일 업로드 
	public static String uploadFile(String uploadPath,
									String originalName,
									byte[] fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath + savedPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;

		if(MimeMediaUtil.getMediaType(formatName) != null) {
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		}else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;
	}
	
	
	// 파일 업로드 
	public static String snsUploadFile(String uploadPath,
									String originalName,
									byte[] fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath + savedPath, savedName);
		System.out.println("=========target==========" + target);
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;

		if(MimeMediaUtil.getMediaType(formatName) != null) {
			System.out.println("================uploadPath===========" + uploadPath);
			uploadedFileName = target.toString().substring(uploadPath.length()).replace(File.separatorChar, '/');		// uploadPath - 2 를 한것은 uploadPath 가 \ 한번이 아닌 \\ 이렇게 두번으로 찍혀서 -2 해줬다.
			makeThumbnail2(uploadPath, savedPath, savedName);
		}else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		System.out.println("=========uploadedFileName=========" + uploadedFileName);
		return PREFIX_URL + uploadedFileName;
	}
	
	
	private static String makeThumbnail(
				String uploadPath,
				String path,
				String fileName)throws Exception{
		BufferedImage sourceImg = 
				ImageIO.read(new File(uploadPath + path, fileName));
		
		BufferedImage destImg =
				Scalr.resize(sourceImg,
							 Scalr.Method.AUTOMATIC,
							 Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		String thumbnailName = 
				uploadPath + path + File.separator + "s_"+fileName;
		
		File newFile = new File(thumbnailName);
		String formatName =
				fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	private static String makeThumbnail2(
				String uploadPath,
				String path,
				String fileName)throws Exception{
		BufferedImage sourceImg = 
				ImageIO.read(new File(uploadPath + path, fileName));
		
		BufferedImage destImg =
				Scalr.resize(sourceImg,
							 Scalr.Method.AUTOMATIC,
							 Scalr.Mode.FIT_TO_HEIGHT, 300);
		
		String thumbnailName = 
				uploadPath + path + File.separator + "s_"+fileName;
		
		File newFile = new File(thumbnailName);
		String formatName =
				fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	private static String makeIcon(String uploadPath,
			String path,
			String fileName)throws Exception{
		String iconName =
				uploadPath + path + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
}