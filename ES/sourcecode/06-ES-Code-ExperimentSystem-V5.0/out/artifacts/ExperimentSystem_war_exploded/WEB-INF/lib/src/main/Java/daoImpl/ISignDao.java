package main.Java.daoImpl;

import main.Java.entity.Login;
import main.Java.entity.Sign;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISignDao {
    List<Sign> findAll();              //返回所有的记录
    int addSign(Sign sign);            //新增签到记录
    int delSignById(int id);          //通过id删除签到记录
    int delSignByStuId(String stu_id); //通过学号删除记录
    int getMaxId(); //获取最大id
    List<Sign> isExistOfSignByExIdAndStuId(@Param("ex_id")int ex_id,@Param("stu_id")String stu_id);//根据实验id和学生id看是否存在
}


