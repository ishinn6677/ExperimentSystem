package main.Java.test;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet",urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        if(userType.equals("0")){//普通用户
            UserService userService = new UserService();
            TinyUser tinyUser = userService.findTinyUser(userName,password);
            if(tinyUser==null){
                //登录失败,返回用户名或密码错误的resp。进行提示
                response.getWriter().write("false");
            }else{
                //登录成功，跳转到首页。
                request.getSession().setAttribute("loginUser",tinyUser);
                response.getWriter().write("true");
            }
        }else{//管理员
            AdminService adminService = new AdminService();
            Admin admin = adminService.findAdmin(userName,password);
            if (admin == null) {
                response.getWriter().write("false");
            }else{
                request.getSession().setAttribute("loginUser",admin);
                response.getWriter().write("admin");
            }
        }
       */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
