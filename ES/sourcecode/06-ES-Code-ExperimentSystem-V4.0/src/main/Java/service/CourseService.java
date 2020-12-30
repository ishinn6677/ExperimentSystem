package main.Java.service;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import main.Java.daoImpl.ICourseDao;
import main.Java.daoImpl.ILoginDao;
import main.Java.entity.Course;
import main.Java.entity.Login;
import main.Java.entity.Time;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import main.Java.test.SqlSessionUtils;

import java.io.InputStream;
import java.util.List;

public class CourseService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    ICourseDao iCourseDao = session.getMapper(ICourseDao.class);

    public CourseService() {
    }

    public List<Course> findAll(){
        return iCourseDao.findAll();
    }

    public List<Course> getCourseById(int id){
        return iCourseDao.getCourseById(id);
    }

    public int getMaxId(){
        return iCourseDao.getMaxId();
    }

    public boolean addCourse(Course course){
        int i = iCourseDao.addCourse(course);
        if(i == 0)
            return false;
        return true;
    }

    public boolean delCourseById(int id){
        int i = iCourseDao.delCourseById(id);
        if(i == 0)
            return false;
        return true;
    }

    public boolean haveCourseOnTime(Time time){
        if(iCourseDao.haveCourseOnTime(time).isEmpty())
            return false;
        return true;
    }

    public List<Integer> haveCourseOnDay(Time time){
        return iCourseDao.haveCourseOnDay(time);
    }

    public static void main(String[] args) throws Exception {
        //单元测试
        CourseService courseService = new CourseService();
        List<Course> courses = courseService.findAll();

        System.out.println(courseService.getMaxId());
//        System.out.println("返回所有记录:");
//        for (Course course :
//                courses) {
//            System.out.println(course);
//        }
//        System.out.println("根据课程编号返回课程:");
//        courses = courseService.getCourseById(1);
//        for(Course course:courses){
//            System.out.println(course.toString());
//        }

        //新增
        Course course = new Course(2,2020,1,4,20,
                3,2,"C++课程设计","蔡云飞","1010");
//        Course course = new Course(1,2020,1,2,14,
//                3,2,"J2EE课程设计","徐建","1011");
//        boolean add = courseService.addCourse(course);
//        if(add == true)
//            System.out.println("新增很成功");
//        else
//            System.out.println("新增失败");

//        //删除
//        boolean del = courseService.delCourseById(course.getId());
//        if(del == true){
//            System.out.println("删除成功,剩下：");
//            courses = courseService.findAll();
//            for (Course course2 : courses){
//                System.out.println(course2.toString());
//                System.out.println("1");
//            }
//        }
//        else
//            System.out.println("删除失败");

//        Time time = new Time(2020,1,5,3,3,"1011");
//        if(courseService.haveCourseOnTime(time))
//            System.out.println("有课");
//        else
//            System.out.println("没课");
//
//        List<Integer> courseths = courseService.haveCourseOnDay(time);
//        for(int i:courseths){
//            System.out.println(i);
//        }
    }
}

