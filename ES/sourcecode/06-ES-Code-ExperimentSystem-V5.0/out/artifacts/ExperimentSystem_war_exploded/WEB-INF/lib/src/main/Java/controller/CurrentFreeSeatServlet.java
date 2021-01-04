package main.Java.controller;

import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.entity.Time;
import main.Java.service.AppointService;
import main.Java.service.CourseService;
import main.Java.service.ExperimentService;
import main.Java.test.ChangeDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author ：
 * @date ：Created in  2021年1月1日21:10:25
 * @description ： 现在空闲的机位
 */
@WebServlet(name = "CurrentFreeSeatServlet",urlPatterns = "/CurrentFreeSeatServlet")
public class CurrentFreeSeatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String appoint_room=request.getParameter("room");
        int Course_th=Integer.parseInt(request.getParameter("dayOrder"));
        //座位
        String date=request.getParameter("goComputerDate");
        ChangeDate changeDate=new ChangeDate();
        //天数
        int count=changeDate.change(date);
        //第几周周几
        int Week_th=0;
        int Day_th=0;
        if(count%7==0){
            Week_th=count/7;
            Day_th=7;
        }else {
            Week_th=count/7;
            Day_th=count-Week_th*7;
            Week_th++;
        }
        ExperimentService es=new ExperimentService();
        AppointService as=new AppointService();
        int term= changeDate.getSemester();
        String[] strs=date.split("-");
        //预约年
        int appointyear=Integer.parseInt(strs[0]);
        Time time = new Time(appointyear,term,Week_th,Day_th,Course_th,appoint_room);
        CourseService courseService=new CourseService();
        boolean result= courseService.haveCourseOnTime(time);
        if(result){
            request.getRequestDispatcher("change_seat0.jsp").forward(request,response);
        }else {
            List<Integer> cptList = as.getNoAppointOnCourseth(time);
            request.setAttribute("cptList",cptList);
            request.getRequestDispatcher("change_seat.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String appoint_room=request.getParameter("room");
        int Course_th=Integer.parseInt(request.getParameter("dayOrder"));
        //座位
        String date=request.getParameter("goComputerDate");
        ChangeDate changeDate=new ChangeDate();
        //天数
        int count=changeDate.change(date);
        //第几周周几
        int Week_th=0;
        int Day_th=0;
        if(count%7==0){
            Week_th=count/7;
            Day_th=7;
        }else {
            Week_th=count/7;
            Day_th=count-Week_th*7;
            Week_th++;
        }
        ExperimentService es=new ExperimentService();
        AppointService as=new AppointService();
        int term= changeDate.getSemester();
        String[] strs=date.split("-");
        //预约年
        int appointyear=Integer.parseInt(strs[0]);
        Time time = new Time(appointyear,term,Week_th,Day_th,Course_th,appoint_room);
        List<Integer> cpt=as.getAppointOnCourseth(time);
        Vector<Integer> cptList = new Vector<Integer>();
        CourseService cs=new CourseService();
        boolean result=cs.haveCourseOnTime(time);
        for (int i = 0; i < 72; i++) {
            cptList.add(i,i+1);
        }
        if(result){
            for (int i = 0; i < 72; i++) {
                cptList.set(i,0);
            }
        }else{
            for(int i:cpt){
                cptList.set(i,0);
            }
        }
        request.setAttribute("cptList",cptList);
        request.getRequestDispatcher("change_seat.jsp").forward(request,response);
    }
}
