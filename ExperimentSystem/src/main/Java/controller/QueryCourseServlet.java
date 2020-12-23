package controller;
import service.CourseService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
//import net.sf.json.*;
//import org.apache.commons.beanutils.BeanUtils;
@WebServlet(name = "QueryCourseServlet")
public class QueryCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("html/login.html").forward(request,response);
        }
        CourseService cs=new CourseService();
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));

        response.setContentType("text/json; charset=utf-8");    // 设置response的编码及格式
        PrintWriter out = response.getWriter();
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("res",1);// 使用Map存储键值对// 向Map对象中添加内容
        Map<String,Object> subMap = new HashMap<>();    // 创建子键值对
        subMap.put("sex","man");
        subMap.put("address","Xi'an");
        resMap.put("userInfo",subMap);  // 将子键值对置入母键值对
        //String resJSON = JSON.toJSONString(resMap);     // 转换为json
        //out.print(resJSON); // 输出
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
