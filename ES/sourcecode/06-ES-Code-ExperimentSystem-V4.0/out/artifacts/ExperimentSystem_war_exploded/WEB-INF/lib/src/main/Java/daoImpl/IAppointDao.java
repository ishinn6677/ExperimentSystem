package main.Java.daoImpl;

import main.Java.entity.Appoint;
import main.Java.entity.Experiment;
import main.Java.entity.Time;

import java.util.List;

public interface IAppointDao {
    List<Appoint> findAll();              //返回所有的记录
    List<Appoint> getAppointById(int id);  //根据 预约编号 返回实验
    int getMaxId(); //返回编号最大值
    int addAppoint(Appoint appoint);            //新增预约
    int delAppointById(int id);          //通过 预约编号 删除预约
    List<Integer> getAppointOnCourseth(Time time);  //获取某一周的某一大节某机房的机位预约情况
//    List<Integer> getNullRoomOnTime(Time time); //获取某时刻 被占用的机房
}
