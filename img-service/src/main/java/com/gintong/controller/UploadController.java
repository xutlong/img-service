package com.gintong.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="img")
public class UploadController {

	private static final String uploadFilePath = "d:\\temp_upload_file\\";
	
	@ResponseBody
	@RequestMapping(value="upload.json")
	public String upload(String fileName, MultipartFile jarFile){
	    try {  
	       String _fileName = jarFile.getOriginalFilename();
	       InputStream is = jarFile.getInputStream();
	       File tempFile = new File(uploadFilePath + _fileName); 
	       // 开始保存文件到服务器    的男的女的  你好
	       if(!_fileName.equals("")) {// mihao   没害
	    	   FileOutputStream fos = new FileOutputStream(uploadFilePath + _fileName);
	    	   byte[] buffer = new byte[8192]; // 每次读8K字节  
	           int count = 0;  
	           int ccc = 1;
	           // 开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中  
	           while ((count = is.read(buffer)) > 0) {     
	               fos.write(buffer, 0, count); // 向服务端文件写入字节流  
	           } 
	           // 关闭FileOutputStream对象  
	           fos.close(); 
	           // InputStream对象 
	           is.close(); 
	       }
	       
	       int v = 6;
	       int vn = 56;
	    } catch (UnsupportedEncodingException e) {  
	        e.printStackTrace();  
	        return "fild";
	    } catch (IOException e) {  // cccccc
	        e.printStackTrace();  
	        return "fild";
	    }  // ccccc
	    return "OK"; 
	}
}
