package main.Java.controller;
import main.Java.entity.Appoint;
import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.entity.Time;
import main.Java.service.AppointService;
import main.Java.service.ExperimentService;
import main.Java.test.ChangeDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author ：
 * @date ：Created in  2021年1月1日21:10:25
 * @description ： 预约实验
 */
@WebServlet(name = "AppointServlet",urlPatterns = "/AppointServlet")
public class AppointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String student_id=login.getId();
        String student_name=login.getName();
        AppointService as=new AppointService();
        int appoint_id=as.getMaxId()+1;
        String appoint_room=request.getParameter("room");
        System.out.println("appoint_room:"+appoint_room);
        int Course_th=Integer.parseInt(request.getParameter("dayOrder"));
        System.out.println("Course_th:"+Course_th);
        //座位
        int appoint_cpt=Integer.parseInt(request.getParameter("seatLabel"));
        System.out.println("appoint_cpt:"+appoint_cpt);
        String date=request.getParameter("goComputerDate");
        System.out.println("goComputerDate:"+date);
        System.out.println("date:"+date);
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
        //todo 假设封装ex_id到session里

        String exid=(String) session.getAttribute("id");
        int ex_id=Integer.parseInt(exid);
        ExperimentService es=new ExperimentService();
        Experiment experiment =es.getExperimentById(ex_id);
        String Ex_teacher_id=experiment.getEx_teacher_id();
        String ex_name=experiment.getEx_name();
        Appoint appoint=new Appoint(appoint_id,Ex_teacher_id,appoint_room,appoint_cpt,Course_th,Day_th,Week_th,ex_id,ex_name,student_id,student_name);
        System.out.println(appoint.toString());
        boolean result;
        boolean isexist=false;
        int term= changeDate.getSemester();
        String[] strs=date.split("-");
        //预约年
        int appointyear=Integer.parseInt(strs[0]);
        Time time = new Time(appointyear,term,Week_th,Day_th,Course_th,appoint_room);
        //
        isexist=as.isExistOfAppointByTimeAndStuId(Week_th,Day_th,Course_th,student_id);

        if(isexist){
            response.getWriter().write("havePeople");
        }else {
            result= as.addAppoint(appoint);
            if(result){
                response.getWriter().write("success");
            }else {
                response.getWriter().write("false");
            }
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
        String student_id=login.getId();
        String student_name=login.getName();
        AppointService as=new AppointService();
        int appoint_id=as.getMaxId()+1;
        String appoint_room=request.getParameter("room");
        System.out.println("appoint_room:"+appoint_room);
        int Course_th=Integer.parseInt(request.getParameter("dayOrder"));
        System.out.println("Course_th:"+Course_th);
        //座位
        int appoint_cpt=Integer.parseInt(request.getParameter("seatLable"));
        String date=request.getParameter("goComputerDate");
        System.out.println("date:"+date);
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
        //todo 假设封装ex_id到session里

        String exid=(String) session.getAttribute("id");
        int ex_id=Integer.parseInt(exid);
        ExperimentService es=new ExperimentService();
        Experiment experiment =es.getExperimentById(ex_id);
        String Ex_teacher_id=experiment.getEx_teacher_id();
        String ex_name=experiment.getEx_name();
        Appoint appoint=new Appoint(appoint_id,Ex_teacher_id,appoint_room,appoint_cpt,Course_th,Day_th,Week_th,ex_id,ex_name,student_id,student_name);
        System.out.println(appoint.toString());
        boolean result;
        boolean isexist=false;
        int term= changeDate.getSemester();
        String[] strs=date.split("-");
        //预约年
        int appointyear=Integer.parseInt(strs[0]);
        Time time = new Time(appointyear,term,Week_th,Day_th,Course_th,appoint_room);
        //
        //isexist=as.addAppoint(appoint);
        if(isexist){
            response.getWriter().write("havePeople");
        }else {
            result= as.addAppoint(appoint);
            if(result){
                response.getWriter().write("success");
            }else {
                response.getWriter().write("false");
            }
        }
    }
}
