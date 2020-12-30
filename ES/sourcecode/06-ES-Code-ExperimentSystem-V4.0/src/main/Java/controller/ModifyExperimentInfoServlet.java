package main.Java.controller;
import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.service.ExperimentService;
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
 * @date ：Created in 2020/12/17 17:07
 * @description ： 上传实验
 */

@WebServlet(name = "ModifyExperimentInfoServlet", urlPatterns = "/ModifyExperimentInfoServlet")
public class ModifyExperimentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String Ex_teacher_id=login.getId();
        String Ex_teacher_name=login.getName();
        Experiment experiment=new Experiment();
        int id=0;
        String experimentIntroduction= null,experimentName= null,experimentDdl= null,experimentAddress= null,Room = null;
        int year = 0,term=0;
        ExperimentService es=new ExperimentService();
        experiment.setEx_teacher_id(Ex_teacher_id);
        experiment.setEx_teacher_name(Ex_teacher_name);

        try {
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            List<FileItem> list = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : list) {
                System.out.println("FOR");
                if (fileItem.isFormField()) {
                    System.out.println("IF");
                    String name = fileItem.getFieldName();
                    if(name.equals("experimentIntroduction"))
                    {
                        experimentIntroduction=fileItem.getString("utf-8");
                        experiment.setEx_content(experimentIntroduction);
                        System.out.println("experimentIntroduction:"+experimentIntroduction);
                    }
                    if(name.equals("experimentName"))
                    {
                        experimentName=fileItem.getString("utf-8");
                        experiment.setEx_name(experimentName);
                        System.out.println("experimentName:"+experimentName);
                    }
                    if(name.equals("experimentDdl"))
                    {
                        experimentDdl=fileItem.getString("utf-8");
                        experiment.setDeadline(experimentDdl);
                        System.out.println("experimentDdl:"+experimentDdl);

                    }
                    if(name.equals("experimentAddress"))
                    {
                        experimentAddress=fileItem.getString("utf-8");
                        experiment.setRoom(experimentAddress);
                        System.out.println("experimentAddress:"+experimentAddress);
                    }
                    if(name.equals("experimentAddress"))
                    {
                        Room=fileItem.getString("utf-8");
                        experiment.setRoom(Room);
                        System.out.println("Room:"+Room);

                    }
                    if(name.equals("experimentTerm"))
                    {
                        term=Integer.parseInt(fileItem.getString("utf-8"));
                        experiment.setTerm(term);
                        System.out.println("term"+term);
                    }
                    if(name.equals("experimentYear"))
                    {
                        year=Integer.parseInt(fileItem.getString("utf-8"));
                        experiment.setYear(year);
                        System.out.println("year:"+year);
                    }
                    if(name.equals("id"))
                    {
                        id=Integer.parseInt(fileItem.getString("utf-8"));
                        experiment.setId(id);
                        System.out.println("id:"+id);
                    }
                } else {
                    System.out.println("ELSE");
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
                    String relativePath = "UploadContent/" +fileName;
                    String path = request.getServletContext().getRealPath(relativePath);
                    System.out.println("relativePath::"+relativePath);
                    System.out.println("path::"+path);
                    path="D:\\j2ee\\ExperimentSystem\\out\\artifacts\\ExperimentSystem_war_exploded\\UploadContent";
                    File directory = new File(path);
                    if(!directory.exists()) {
                        directory.mkdirs();
                    }
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
                    String upload=uploadpath.substring(69);
                    System.out.println("upload:"+upload);
                    experiment.setUpload(upload);
                }
            }
            //删除之前上传的模板
            Experiment oldExperiment =es.getExperimentById(id);
            String fileExist=oldExperiment.getUpload();
            File file = new File(fileExist);
            if(file.isFile() && file.exists()) {
                file.delete();
            }
            experiment.setRoom(Room);
            experiment.setYear(year);
            experiment.setTerm(term);
            experiment.setDeadline(experimentDdl);
            experiment.setEx_content(experimentIntroduction);
            experiment.setEx_name(experimentName);
            experiment.setId(id);
            boolean result0= es.delExperimentById(id);
            System.out.println(experiment.toString());
            boolean result=es.addExperiment(experiment);
            if(result){
                response.getWriter().write("success");
            }else {
                response.getWriter().write("false");
            }
            System.out.println("experiment:"+experiment);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        System.out.println("delete");
    }
}


