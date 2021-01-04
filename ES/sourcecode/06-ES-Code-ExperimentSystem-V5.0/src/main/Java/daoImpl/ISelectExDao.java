package main.Java.daoImpl;

import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.entity.SelectEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISelectExDao {
    List<SelectEx> findAll();              //返回所有的记录
    List<SelectEx> getSelectExById(int id); //根据id返回选实验记录
    List<String> getStusByExId(int ex_id);  //根据实验编号返回选择该实验的学生学号
    int addSelectEx(SelectEx selectEx);            //新增选择实验记录
    int updateInfo(SelectEx selectEx);            //修改实验记录
    int delSelectExById(int id);          //通过id删除选择试验记录
    int setGrade(@Param("ex_id")int ex_id,@Param("stu_id")String stu_id, @Param("grade")int grade);//给实验打分数
    int getMaxId(); //返回编号最大值
    List<Integer> getGrade(@Param("ex_id")int ex_id,@Param("stu_id")String stu_id);       //获取分数
    List<SelectEx> getSeExsByExId(int ex_id);//通过实验id返回选择该实验的记录
    List<SelectEx> isExistOfSelect(@Param("ex_id")int ex_id,@Param("stu_id")String stu_id); //获取该学生是否选了该实验
    int delSelectExByExIdAndStuId(@Param("ex_id")int ex_id,@Param("stu_id")String stu_id);//根据实验id和学生id退选实验
    List<SelectEx> getSelectExByStuId(String stu_id);//根据学生id查找该学生选择的实验
}



