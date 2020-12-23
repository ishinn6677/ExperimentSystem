package daoImpl;

import entity.Login;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sun.rmi.runtime.Log;

import java.util.List;

public interface ILoginDao {
    List<Login> findAll();              //返回所有的记录
    List<String> getPwdById(String id); //根据学号返回密码
    List<Login> getUsrById(String id);  //根据学（工）号返回用户
    int addUsr(Login login);            //新增用户
    int delUsrById(String id);          //通过学（工）号删除用户
    int updatePwdById(@Param("id")String id, @Param("newPwd")String newPwd);       //通过学号修改密码
}
