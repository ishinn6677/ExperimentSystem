package main.Java.controller;

import main.Java.entity.Login;
import main.Java.service.AppointService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author ：
 * @date ：Created in 2021年1月1日21:09:25
 * @description ： 取消预约
 */
@WebServlet(name = "CancelAppointServlet",urlPatterns = "/CancelAppointServlet")
public class CancelAppointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String student_id=login.getId();
        int appointmentId=Integer.parseInt(request.getParameter("appointmentId"));
        System.out.println("appointmentId:"+appointmentId);
        AppointService as=new AppointService();
        boolean result=as.delAppointById(appointmentId);
        if(result){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
