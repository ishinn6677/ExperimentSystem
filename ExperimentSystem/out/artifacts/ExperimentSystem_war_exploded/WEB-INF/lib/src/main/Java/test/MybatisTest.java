package main.Java.test;

import main.Java.daoImpl.*;
import main.Java.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author ：
 * @date ：Created in 2019/11/8 10:12
 * @description ： 入门案例
 */
public class MybatisTest {
    /**
     * @author      ：
     * @description ：入门案例
     * @param       : [args]
     * @return      : void
     * @date        ：Created in 2019/11/8
     */
    public static void main(String[] args) throws Exception {
        SqlSession session = SqlSessionUtils.getSqlSession();
        //4.使用SqlSession创建dao接口的代理对象
        ILoginDao iLoginDao = session.getMapper(ILoginDao.class);
        //5.使用代理对象执行方法
        List<Login> logins = iLoginDao.findAll();
        for (Login login :
                logins) {
            System.out.println(login);
        }
        System.out.println(iLoginDao.getPwdById("石开"));
        //6.释放资源
        session.close();
    }
}

