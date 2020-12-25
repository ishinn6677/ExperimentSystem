package main.Java.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：
 * @date ：Created in 2020/12/17 17:07
 * @description ： 实验老师裸着学生下载服务器提供的实验报告
 */
@WebServlet(name = "DownReportServlet",urlPatterns = "/DownReportServlet")
public class DownReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public DownReportServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置响应的头部属性content-disposition值为attachment
        //使用filename来指定文件名
        String filename = "超跑.png";
        byte[] bytes = filename.getBytes("utf-8");
        //http协议规定浏览器只能接受ISO8859-1类型的字节数据
        filename = new String(bytes,"ISO8859-1");
        response.setHeader("content-disposition", "attachment;filename="+filename);
        //获取连接服务器资源文件的输入流
        InputStream is = request.getServletContext().getResourceAsStream("/Resources/BS架构原理图1.png");
        //获取输出流
        ServletOutputStream os = response.getOutputStream();
        //将输入流中的数据写到输出流中
        int length = -1;
        byte[] buffer = new byte[1024];
        while((length=is.read(buffer))!=-1) {
            os.write(buffer,0,length);
        }
        os.close();
        is.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}