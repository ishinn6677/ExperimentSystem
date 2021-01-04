package main.Java.service;

import main.Java.daoImpl.ISelectExDao;
import main.Java.daoImpl.ISignDao;
import main.Java.entity.Sign;
import main.Java.test.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.util.List;

public class SignService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    ISignDao iSignDao = session.getMapper(ISignDao.class);

    public SignService(){

    }

    public List<Sign> findAll(){
        List<Sign> signs = iSignDao.findAll();
        if(signs.size() == 0)
            return null;
        return signs;
    }

    public  int getMaxId(){
        int i = iSignDao.getMaxId();
        if(i == 0)
            return 0;
        return i;
    }
    public boolean addSign(Sign sign){
        int i = iSignDao.addSign(sign);
        if(i == 0)
            return false;
        return true;
    }
    public boolean delSignById(int id){
        int i = iSignDao.delSignById(id);
        if(i == 0)
            return false;
        return true;
    }
    public boolean delSignByStuId(String stu_id){
        int i = iSignDao.delSignByStuId(stu_id);
        if(i == 0)
            return false;
        return true;
    }

    public boolean isExistOfSignByExIdAndStuId(int ex_id, String stu_id){
        List<Sign> signs = iSignDao.isExistOfSignByExIdAndStuId(ex_id,stu_id);
        if(signs == null || signs.size() == 0)
            return false;
        return true;
    }

    public static void main(String args[]) throws Exception{
        //单元测试
        SignService signService = new SignService();

        System.out.println("返回所有记录");
        List<Sign> signs = signService.findAll();
        if(signs == null)
            System.out.println("表为空");
        else{
            for(Sign sign:signs){
                System.out.println(sign.toString());
            }
        }

        if(signService.isExistOfSignByExIdAndStuId(1,"1"))
            System.out.println("学生1签到了实验1");
        else
            System.out.println("学生2没有签到实验2");

        System.out.println("最大id");
        System.out.println(signService.getMaxId());

//        Sign sign = new Sign(1,"实验1",1,"2020-12-2","918106840540","石开");
//        if(signService.addSign(sign))
//            System.out.println("添加成功");
//        else
//            System.out.println("添加失败");
//        System.out.println("返回所有记录");
//        List<Sign> signs2 = signService.findAll();
//        if(signs == null)
//            System.out.println("表为空");
//        else
//            for(Sign sign2:signs2){
//                System.out.println(sign2.toString());
//            }
//
//        if(signService.delSignByStuId("918106840540"))
//            System.out.println("删除成功");
//        else
//            System.out.println("删除失败");
//        System.out.println("返回所有记录");
//        List<Sign> signs3 = signService.findAll();
//        if(signs == null)
//            System.out.println("表为空");
//        else
//            for(Sign sign3:signs3){
//                System.out.println(sign3.toString());
//            }
    }
}

