package main.Java.controller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.service.ExperimentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author ：
 * @date ：Created in 2020/12/17 17:07
 * @description ： 上传实验
 */

@WebServlet(name = "UploadExperimentServlet",urlPatterns = "/UploadExperimentServlet")
public class UploadExReportServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

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
        String hasMultipart=""; //是否携带附件
        int id;
        File file=null;
        FileItem fileitem=null;
        String s=UUID.randomUUID().toString().replaceAll("-", "");
        String UUID=s;
        String experimentIntroduction,experimentName,experimentDdl,experimentAddress,Room;
        int year,term;
        ExperimentService es=new ExperimentService();
        id=es.getMaxId()+1;
        experiment.setId(id);
        boolean bb=ServletFileUpload.isMultipartContent(request);
        // 判断是否有enctype="multipart/form-data"
        if(bb) {
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload load=new ServletFileUpload(factory);
            try {
                List<FileItem> list=load.parseRequest(request);
                // 解析请求

                Iterator<FileItem> it=list.iterator();
                while(it.hasNext()) {
                    FileItem item=it.next();
                    if(item.isFormField()) {
                        // 判断是否是普通表单字段

                        String fieldName=item.getFieldName();
// 表单字段名

                        switch(fieldName) {
                            case "experimentIntroduction":experimentIntroduction=item.getString("utf-8");experiment.setEx_content(experimentIntroduction);System.out.println(1);break;
                            case "experimentName":experimentName=item.getString("utf-8");experiment.setEx_name(experimentName);System.out.println(2);break;
                            case "experimentDdl":experimentDdl=item.getString("utf-8");experiment.setDeadline(experimentDdl);System.out.println(3);break;
                            case "experimentAddress":experimentAddress=item.getString("utf-8");experiment.setRoom(experimentAddress);System.out.println(4);break;
                            case "Room":Room=item.getString("utf-8");experiment.setRoom(Room);System.out.println(5);break;
                            case "term":term=Integer.parseInt(item.getString("utf-8"));experiment.setTerm(term);System.out.println(6);break;
                            case "year":year=Integer.parseInt(item.getString("utf-8"));experiment.setYear(year);System.out.println(7);break;
                        }

                        // System.out.println(item.getString("utf-8"));
                        //获取value值；必须附上utf-8编码，否则出现中文乱码

                    }else {
                        if(!item.getName().isEmpty()) {// 判断是否选择文件
                            fileitem=item;
                            String name=item.getName();
// 获取文件名（完整路径） -->

                            name=name.substring(name.lastIndexOf("/")+1);
                            hasMultipart=name;

                            InputStream in=UploadExperimentServlet.class.getClassLoader().getResourceAsStream("properties/uploadPath.properties");
                            Properties p=new Properties();
                            p.load(in);
                            String path=(String)p.get("upload");
// 文件保存路径 -->

                            name=name.substring(name.lastIndexOf("."));
                            file=new File(path,UUID+name);


                        }
                    }


                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        try {if(fileitem!=null) {
            fileitem.write(file);
            // 保存文件 -->
        }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
