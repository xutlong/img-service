package com.gintong.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class UploadControllerTest {

	@Test
	public void testUpload() {
		
		
	    String filePath = "D:\\xiazai\\kdsjlgkjsldkjglskdjglk3493583.jpg";  
	    String getUrl = "http://192.168.101.21:8081/uploadManager/getUploadIPForImage?userId=123&imageName=kdsjlgkjsldkjglskdjglk3493583.jpg";
	  
	    RestTemplate rest = new RestTemplate();  
	    
	    Map<String,Object> map = new HashMap<String,Object>();
	    /*map.put("userId",123);
	    map.put("imageName", "kdsjlgkjsldkjglskdjglk3493583.jpg");*/
	    String message = rest.getForObject(getUrl,String.class,map);
	    System.out.println(message);
	    String url = "http://" + message.trim() +":8888/image/uploadPic";  
	    FileSystemResource resource = new FileSystemResource(new File(filePath));  
	    MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();  
	    param.add("myfile", resource);  
	    param.add("userId", "123");  
	  
	    String string = rest.postForObject(url, param, String.class);  
	    System.out.println(string);
	}

}
