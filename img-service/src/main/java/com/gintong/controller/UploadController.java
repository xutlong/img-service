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
	       // ��ʼ�����ļ���������
	       if(!_fileName.equals("")) {
	    	   FileOutputStream fos = new FileOutputStream(uploadFilePath + _fileName);
	    	   byte[] buffer = new byte[8192]; // ÿ�ζ�8K�ֽ�  
	           int count = 0;  
	           // ��ʼ��ȡ�ϴ��ļ����ֽڣ����������������˵��ϴ��ļ��������  
	           while ((count = is.read(buffer)) > 0) {  
	               fos.write(buffer, 0, count); // �������ļ�д���ֽ���  
	           } 
	           // �ر�FileOutputStream����  
	           fos.close(); 
	           // InputStream���� 
	           is.close(); 
	       }
	    } catch (UnsupportedEncodingException e) {  
	        e.printStackTrace();  
	        return "fild";
	    } catch (IOException e) {  
	        e.printStackTrace();  
	        return "fild";
	    }  
	    // TODO �����ļ�����...  
	    return "OK"; 
	}
}
