package org.medicine.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;





@Controller
@RequestMapping("uploadify/")
public class uploadify {

			
			
	/**
     * 文件上传,利用MultipartHttpServletRequest来解析request中的文件
     * 用 transferTo方法来保存图片，保存到本地磁盘。
     * 普通request是无法解析请求中的文件的。
     *  MultipartHttpServletRequest是springmvc框架中的一个接口，默认实现类是DefaultMultipartHttpServletRequest
     * @author gaofengjiao
     */
	@ResponseBody
    @RequestMapping("upload.do")
    public String upload2(HttpServletRequest request,ModelMap map) {
		//windows下指定死路径
//		String PATH = "C:/ZDY/MyWorkspace/myobject/src/main/webapp/static/upload";
		
		//linux 文件存储路径   /home/centos/tomcat/webapps/myobject/static/upload
		String PATH= request.getServletContext().getRealPath("/static/upload");
    	try {
    		 MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
             // 获得文件
             MultipartFile file = multiRequest.getFile("Filedata");
             if (!file.isEmpty()) {
                 // 获得原始文件名
                 String fileName = file.getOriginalFilename();
                 //给文件名称加上当前时间，防止名称重复
//                 String newfileName = new Date().getTime() + String.valueOf(fileName);
                 //改变上传文件的名称，防止中文乱码
                 String dataString=new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
                 // 相对路径
                 String path=PATH+"/"+dataString;
                 //前台调用路径
                 String showPath=request.getContextPath()+"/static/upload/"+dataString;
                 map.put("url", showPath);
                 map.put("name", fileName);
                 // 创建文件实例
                 File tempFile = new File(path); //文件保存路径为path
                 if (!tempFile.exists()) {
                     tempFile.mkdirs();
                 }
                 try {
                     file.transferTo(tempFile);	//文件存入文件夹
                     
                     
                    		Map reMap=new HashMap();
            				reMap.put("succ", "true");
            				reMap.put("Url", showPath);
            				reMap.put("name", fileName);
            				JSONObject jsonObject = JSONObject.fromObject(reMap);
            				return jsonObject.toString();
                 } catch (IllegalStateException e) {
                	 System.err.println("上传文件");
                     e.printStackTrace();
                 } catch (IOException e) {
                	 System.err.println("上传文件");
                     e.printStackTrace();
                 }
             }
		} catch (Exception e) {
			System.err.println("上传文件");
			e.printStackTrace();
		}
    	 Map reMap=new HashMap();
    	 reMap.put("succ", "false");
			JSONObject jsonObject = JSONObject.fromObject(reMap);
			return jsonObject.toString();
    }
/*	*//**
	 * 图片插入数据库
	 * @param imgTable
	 * @return
	 *//*
	public boolean insertImg(ImgTable imgTable){
		try {
			int i=this.imgTableService.insertimg(imgTable);
			if(i!=0){
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println("插入文件");
			e.printStackTrace();
			return false;
		}
	*/
}
