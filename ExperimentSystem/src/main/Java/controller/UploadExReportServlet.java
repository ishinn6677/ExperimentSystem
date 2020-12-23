package controller;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import java.util.List;
import java.util.UUID;

public class UploadExReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private String[] fileExts = {"doc","zip","rar","jpg","txt"};

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //检查该请求是否是一个上传表单( 必须是 post请求,和enctype="multipart/form-data")
        Boolean  isMultipart  =	ServletFileUpload.isMultipartContent(request);
        if(isMultipart){
            //创建一个临时文件存放要上传的文件，第一个参数为上传文件大小，第二个参数为存放的临时目录
            DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024*5,new File("C:\\temp1"));
            // 创建一个文件上传的句柄
            ServletFileUpload upload = new ServletFileUpload(factory);

            //设置上传文件的整个大小和上传的单个文件大小
            upload.setSizeMax(1024*1024*50);
            upload.setFileSizeMax(1024*1024*5);

            try {
                //把页面表单中的每一个表单元素解析成一个FileItem
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem fileItem : items) {
                    //如果是一个普通的表单元素(type不是file的表单元素)
                    if(fileItem.isFormField()){
                        System.out.println(fileItem.getFieldName());  //得到对应表单元素的名字
                        System.out.println(fileItem.getString());  //得到表单元素的值
                    }else{
                        //获取文件的后缀名
                        String fileName = fileItem.getName();//得到文件的名字
                        String fileExt = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());

                        if(Arrays.binarySearch(fileExts, fileExt)!=-1){
                            try {
                                //将文件上传到项目的upload目录并命名，getRealPath可以得到该web项目下包含/upload的绝对路径
                                fileItem.write(new File(getServletContext().getRealPath("/upload")+"/"
                                        +UUID.randomUUID().toString()+"."+fileExt));
                                System.out.println("sussess upload!");
                                request.getRequestDispatcher("/login.jsp").forward(request,response);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else{
                            System.out.println("该文件类型不能够上传");
                        }
                    }
                }
            } catch (FileUploadBase.SizeLimitExceededException e) {
                System.out.println("整个请求的大小超过了规定的大小...");
            } catch (FileUploadBase.FileSizeLimitExceededException e) {
                System.out.println("请求中一个上传文件的大小超过了规定的大小...");
            }catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}

