package main.Java.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

            sqlSession = sqlSessionFactory.openSession(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}