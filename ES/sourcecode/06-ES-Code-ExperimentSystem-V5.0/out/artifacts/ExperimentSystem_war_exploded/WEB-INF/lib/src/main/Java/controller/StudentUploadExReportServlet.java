package main.Java.controller;

import main.Java.entity.Login;
import main.Java.entity.SelectEx;
import main.Java.service.SelectExService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * @author ：
 * @date ：Created in 2021年1月1日21:42:51
 * @description ： 学生上传实验报告
 */
@WebServlet(name = "StudentUploadExReportServlet",urlPatterns = "/StudentUploadExReportServlet")
public class StudentUploadExReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        boolean result=false;
        String stu_id=login.getId();
        String method;
        String stu_name=login.getName();
        int select_id=0;
        String templateName=stu_id+"_"+stu_name;
        SelectExService ss=new SelectExService();
        String url=null;
        String upload=null;
        StringBuffer sb = new StringBuffer();
        try {
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            List<FileItem> list = servletFileUpload.parseRequest(request);


            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    sb.append(fileItem.getString("utf-8"));
                }
            }
            String idStr = sb.toString();
            int id = Integer.parseInt(idStr.split("=")[1]);
            System.out.println(id+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            for (FileItem fileItem : list) {
                if (!fileItem.isFormField()) {
                    String allFilePath = fileItem.getName();
                    String fileName = null;
                    int ind = allFilePath.lastIndexOf("\\");
                    if (ind != -1) {
                        fileName = allFilePath.substring(ind + 1);
                    } else {
                        fileName = allFilePath;
                    }
                    System.out.println("fileName:"+fileName);
                    long size = fileItem.getSize();
                    System.out.println(fileName + ":" + size + "Byte");
                    InputStream inputStream = fileItem.getInputStream();
                    //D:\j2ee\ExperimentSystem\out\artifacts\ExperimentSystem_war_exploded\
                    String realPath=getServletContext().getRealPath("/");
                    System.out.println(realPath);

                    String relativePath = "StudentReport/" +fileName;
                    String path = request.getServletContext().getRealPath(relativePath);

                    System.out.println("relativePath::"+relativePath);
                    System.out.println("path::"+path);
                    //path="D:\\j2ee\\ExperimentSystem\\out\\artifacts\\ExperimentSystem_war_exploded\\UploadContent";
                    path=realPath+"StudentReport";
                    File directory = new File(path);
                    if(!directory.exists()) {
                        directory.mkdirs();
                    }

                    String[] strs=fileName.split("[.]");
                    System.out.println("strs:"+strs.length);

                    for(int i=0,len=strs.length;i<len;i++){
                        System.out.println(i+":"+strs[i].toString());
                    }
                    fileName=id+templateName+"."+strs[1];
                    File descFile = new File(path,fileName);
                    OutputStream outputStream = new FileOutputStream(descFile);
                    int length = -1;
                    byte[] buffer = new byte[1024];
                    while((length=inputStream.read(buffer))!=-1) {
                        outputStream.write(buffer, 0, length);
                    }
                    outputStream.close();
                    inputStream.close();
                    //删除临时文件
                    fileItem.delete();

                    System.out.println(path);
                    String uploadpath=path+"\\"+fileName;

                    //upload=upload.replaceAll(realPath,"");
                    //upload=uploadpath.substring(69);
                    upload="StudentReport/"+fileName;
                    System.out.println("upload:"+upload);
                }
            }
            System.out.println("end:"+upload);
            System.out.println(id+"selectid:");
            SelectEx selectEx=ss.getSelectExById(id);
            selectEx.setReport(upload);
            result=ss.updateInfo(selectEx);
            if(result){
                response.getWriter().write("{"+"\"code\":0"+"}");
            }else {
                response.getWriter().write("{"+"\"code\":1"+"}");
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
