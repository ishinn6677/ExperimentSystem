package main.Java.service;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import main.Java.daoImpl.ILoginDao;
import main.Java.entity.Login;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import main.Java.test.SqlSessionUtils;

import java.io.InputStream;
import java.util.List;

public class LoginService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    ILoginDao iLoginDao = session.getMapper(ILoginDao.class);

    public LoginService() {
    }

    public List<Login> findAll(){
        return iLoginDao.findAll();
    }

    public String getPwdById(String id){
        List<String> strings = iLoginDao.getPwdById(id);
        int i = strings.size();
        if(i == 0)
            return null;
        else
            return strings.get(0);
    }

    public Login getUsrById(String id){
        List<Login> logins = iLoginDao.getUsrById(id);
        int i = logins.size();
        if(i == 0)
            return null;
        else
            return logins.get(0);
    }

    public boolean addUsr(Login login){
        int i = iLoginDao.addUsr(login);
        if(i == 0)
            return false;
        return true;
    }

    public boolean delUsrById(String id){
        int i = iLoginDao.delUsrById(id);
        if(i == 0)
            return false;
        return true;
    }

    public boolean updatePwdById(String id, String newPwd){
        int i = iLoginDao.updatePwdById(id, newPwd);
        if(i == 0)
            return false;
        return true;
    }

    public boolean updateInfo(Login login){
        if(iLoginDao.updateInfo(login) == 0)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        //单元测试
        LoginService loginService = new LoginService();
        List<Login> logins = loginService.findAll();
        System.out.println("返回所有记录:");
        for (Login login :
                logins) {
            System.out.println(login);
        }
        System.out.println("根据学号返回密码:");
        System.out.println(loginService.getPwdById("123"));//根据学号返回密码
        System.out.println("根据学号返回用户:");
        System.out.println(loginService.getUsrById("456").toString());//根据学号返回用户

        boolean i = loginService.updatePwdById("123","1111111");
        if(i)
            System.out.println("update success");
        else
            System.out.println("update fail");


        //新增
        Login login = new Login("马朴涵","789","老师","789","11.11","山东","男");
        i = loginService.updateInfo(login);
        if(i)
            System.out.println("update success");
        else
            System.out.println("update fail");
//        boolean add = loginService.addUsr(login);
//        if(add == true) {
//            System.out.println("新增很成功");
//            System.out.println(loginService.getUsrById("789").toString());
//        }
//        else
//            System.out.println("新增失败");
//
//        //删除
//        boolean del = loginService.delUsrById(login.getId());
//        if(del == true){
//            System.out.println("删除成功,剩下：");
//            logins = loginService.findAll();
//            for (Login login2 : logins){
//                System.out.println(login2.toString());
//                System.out.println("1");
//            }
//        }
//        else
//            System.out.println("删除失败");
    }
}

