package main.Java.daoImpl;

import main.Java.entity.Course;
import main.Java.entity.Login;
import main.Java.entity.Time;

import java.util.List;

public interface ICourseDao {
    List<Course> findAll();              //返回所有的记录
    List<Course> getCourseById(int id); //根据 课程编号 返回课程
    int addCourse(Course course);            //新增 课程
    int delCourseById(int id);          //通过课程编号 删除 课程
    List<Integer> haveCourseOnTime(Time time); //某时间某教室有没有大课
    List<Integer> haveCourseOnDay(Time time); //某天某教室哪些大节有课
    int getMaxId();                         //获得课程编号最大值
}

