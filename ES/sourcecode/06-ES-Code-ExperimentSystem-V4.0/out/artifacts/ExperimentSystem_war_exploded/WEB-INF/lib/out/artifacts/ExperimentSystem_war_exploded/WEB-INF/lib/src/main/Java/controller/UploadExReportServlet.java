package main.Java.controller;
import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.service.ExperimentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
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
import java.util.Arrays;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * @author ：
 * @date ：Created in 2020/12/17 17:07
 * @description ： 上传实验报告模板
 */

@WebServlet(name = "UploadExperimentServlet",urlPatterns = "/UploadExperimentServlet")
public class UploadExReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UploadExReportServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //处理信息
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("").forward(request,response);
        }
        //用户已经登录
        ExperimentService es=new ExperimentService();
        //实验编号
        int id=100,year,term;
        id=es.getMaxId();
        //实验名 实验简介 截止日期 机房
        String Ex_name,Ex_content,deadline,Room,filePath;
        //实验老师id,实验老师姓名
        String Ex_teacher_id,Ex_teacher_name;
        //实验简介
        Ex_content=request.getParameter("experimentIntroduction");
        System.out.println("Ex_content:"+Ex_content);
        Ex_name=request.getParameter("experimentName");
        System.out.println("Ex_name:"+Ex_name);
        deadline=request.getParameter("experimentDdl");
        System.out.println("experimentDdl:"+deadline);
        Room=request.getParameter("experimentAddress");
        System.out.println("Room:"+Room);
        term=Integer.parseInt(request.getParameter("experimentTerm"));
        System.out.println("term:"+term);
        year=Integer.parseInt(request.getParameter("experimentYear"));
        System.out.println("year:"+year);
        filePath = null;
        //获取实验老师信息
        Login login=(Login)session.getAttribute("user_info");
        System.out.println("user_info:"+login.toString());
        Ex_teacher_id=login.getId();
        Ex_teacher_name=login.getName();
        Experiment experiment=new Experiment(id,Ex_name,Ex_teacher_id,Ex_teacher_name,Ex_content,deadline,Room,term,year,filePath);
        System.out.println(experiment.toString());
        boolean ifSuccess= es.addExperiment(experiment);
        if(ifSuccess==true){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("false");
        }

        //第一步、判断请求是否为multipart请求处理二进制比特流
        if(!ServletFileUpload.isMultipartContent(request)) {
            throw new RuntimeException("当前请求只支持文件上传");
        }
        try {
            //第二步、创建FileItem工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置临时文件存储目录
            String path = this.getServletContext().getRealPath("/Temp");
            File temp = new File(path);
            factory.setRepository(temp);
            //单位：字节。本例设置边界值为2MB，超过该值会创建临时文件
            factory.setSizeThreshold(1024*1024*2);
            //第三步、创建文件上传核心组件
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置item的头部字符编码，解决中文乱码问题
            upload.setHeaderEncoding("utf-8");
            //设置单个上传文件的最大值为5MB
            upload.setFileSizeMax(1024*1024*5);
            //设置一次上传所有文件总和的最大值为10MB（上传多个文件时起作用）
            upload.setFileSizeMax(1024*1024*10);
            //第四步、解析请求获取所有的item
            List<FileItem> items = upload.parseRequest(request);
            //第五步、遍历item
            for(FileItem item:items) {
                if (item.isFormField()) {
                    processFormField(item);
                } else {
                    processUploadedFile(item);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
    private void processFormField(FileItem item) {
        try {
            String name = item.getFieldName();
            //解决中文乱码问题
            String value = item.getString("utf-8");
            System.out.println(name+"="+value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    private void processUploadedFile(FileItem item) {
        try {
            InputStream inputStream = item.getInputStream();
            String fieldName = item.getFieldName();
            //获取上传文件原始名称
            String fileName = item.getName();
            //解决文件同名问题
            fileName = System.currentTimeMillis()+fileName;
            String contentType = item.getContentType();
            boolean isInMemory = item.isInMemory();
            long sizeInBytes = item.getSize();
            String path = this.getServletContext().getRealPath("/UploadContent");

            //

            ExperimentService es=new ExperimentService();
            int Ex_id=es.getMaxId();
            path="D:\\j2ee\\ExperimentSystem\\out\\artifacts\\ExperimentSystem_war_exploded\\UploadContent\\"+Ex_id;
            System.out.println(path+"success upload");
/*            //Date now = new Date();
            Calendar now = Calendar.getInstance();
            //对上传的文件进行分类管理
            path += "/"+now.get(Calendar.YEAR)+"/"+(now.get(Calendar.MONTH)+1)+"/"+now.get(Calendar.DAY_OF_MONTH);*/
            //若目录不存在，则创建该目录
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
            item.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

