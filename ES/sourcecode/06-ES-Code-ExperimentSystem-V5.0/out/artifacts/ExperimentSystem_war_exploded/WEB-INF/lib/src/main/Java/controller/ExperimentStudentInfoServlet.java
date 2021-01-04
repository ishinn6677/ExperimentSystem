package main.Java.controller;
import main.Java.entity.SelectEx;
import main.Java.service.SelectExService;
import org.omg.CORBA.INTERNAL;
import sun.awt.geom.AreaOp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
/**
 * @author ：
 * @date ：Created in  2020年12月30日17:30:19
 * @description ： 返回某一实验所有选课学生信息
 */
@WebServlet(name = "ExperimentStudentInfoServlet",urlPatterns = "/ExperimentStudentInfoServlet")
public class ExperimentStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        SelectExService se=new SelectExService();
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        System.out.println(page+" "+" "+limit);
        int ex_id=(int)session.getAttribute("id");
        System.out.println("ex_id"+ex_id);
        List<SelectEx> selectex=se.getSeExsByExId(ex_id);
        int count=selectex.size();
        Vector<SelectEx> selectexList = new Vector<SelectEx>();
        //前端需要获取到的course
        for (int j = count-(page-1)*limit; j > count-(page)*limit; j--) {
            System.out.println("dopost"+selectex.get(j).toString());
            selectexList.add(selectex.get(j));
        }
        request.setAttribute("count",count);
        request.setAttribute("selectexList",selectexList);
        request.getRequestDispatcher("change_select_ex_student.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        SelectExService se=new SelectExService();
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        System.out.println("page:"+page+" "+"limit:"+limit);
        int ex_id=0;
        if(session.getAttribute("id")!=null){
            ex_id=(int)session.getAttribute("id");
        }
        System.out.println("ex_id"+ex_id);
        List<SelectEx> selectex=se.getSeExsByExId(ex_id);
        int count=selectex.size();
        System.out.println("size:"+count);
        Vector<SelectEx> selectexList = new Vector<SelectEx>();
        //前端需要获取到的course
        for (int j = count-(page-1)*limit-1; j > count-(page)*limit-1&&j>=0; j--) {
            if(selectex.get(j)!=null){
                System.out.println("dopost"+selectex.get(j).toString());
                selectexList.add(selectex.get(j));
            }
        }
        count=selectexList.size();
        request.setAttribute("count",count);
        request.setAttribute("selectexList",selectexList);
        request.getRequestDispatcher("change_select_ex_student.jsp").forward(request,response);
    }
}
