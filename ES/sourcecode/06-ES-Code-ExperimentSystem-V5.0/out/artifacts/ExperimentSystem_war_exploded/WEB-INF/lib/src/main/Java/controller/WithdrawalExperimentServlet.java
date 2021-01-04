package main.Java.controller;

import main.Java.entity.Appoint;
import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.entity.SelectEx;
import main.Java.service.AppointService;
import main.Java.service.ExperimentService;
import main.Java.service.SelectExService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * @author ：
 * @date ：Created in 2021年1月1日21:42:51
 * @description ： 退选实验，退选时间要早于报告截止日期
 */
@WebServlet(name = "WithdrawalExperimentServlet",urlPatterns = "/WithdrawalExperimentServlet")
public class WithdrawalExperimentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login) session.getAttribute("user_info");
        String std_id=login.getId();
        int  appointmentId=Integer.parseInt(request.getParameter("appointmentId")) ;
        //todo 退选要删除预约记录嘛
        SelectExService se=new SelectExService();
        ExperimentService ES=new ExperimentService();
        AppointService as=new AppointService();
        Appoint appoint= as.getAppointById(appointmentId);
        int ex_id=appoint.getEx_id();
        Experiment experiment= ES.getExperimentById(ex_id);
        String date=experiment.getDeadline();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String currentdate = localDate.format(dateTimeFormatter);
        int re= currentdate.compareTo(date);
        System.out.println("re:"+re);
        boolean result=false;
        if(re<0){
            AppointService AS=new AppointService();
            result=as.delAppointById(appointmentId);
           if(result){
               response.getWriter().write("success");
           }else {
               response.getWriter().write("false");
           }
        }else {
            response.getWriter().write("false");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login) session.getAttribute("user_info");
        String std_id=login.getId();
        int  appointmentId=Integer.parseInt(request.getParameter("appointmentId")) ;
        System.out.println(appointmentId+"appointmentId");
        //todo 退选要删除预约记录嘛
        SelectExService se=new SelectExService();
        ExperimentService ES=new ExperimentService();
        AppointService as=new AppointService();
        Appoint appoint= as.getAppointById(appointmentId);
        int ex_id=appoint.getEx_id();
        System.out.println("ex_id:"+ex_id);
        Experiment experiment= ES.getExperimentById(ex_id);
        System.out.println(experiment.toString());
        String date=experiment.getDeadline();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String currentdate = localDate.format(dateTimeFormatter);
        int re= currentdate.compareTo(date);
        System.out.println("re:"+re);
        boolean result=false;
        if(re<0){
            AppointService AS=new AppointService();
            result=as.delAppointById(appointmentId);
            /*result=se.delSelectExById(appointmentId);*/
            if(result){
                response.getWriter().write("success");
            }else {
                response.getWriter().write("failed");
            }
        }else {
            response.getWriter().write("failed");
        }
    }
}
