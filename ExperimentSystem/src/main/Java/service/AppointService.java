package service;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import daoImpl.*;
import entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.SqlSessionUtils;

import java.io.InputStream;
import java.util.List;

public class AppointService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    IAppointDao iAppointDao = session.getMapper(IAppointDao.class);

    public AppointService() {
    }

    public List<Appoint> findAll(){
        return iAppointDao.findAll();
    }

    public Appoint getAppointById(int id){
        return iAppointDao.getAppointById(id).get(0);
    }

    public int getMaxId(){
        return iAppointDao.getMaxId();
    }

    public boolean addAppoint(Appoint appoint){
        int i = iAppointDao.addAppoint(appoint);
        if(i == 0)
            return false;
        return true;
    }

    public boolean delAppointById(int id){
        int i = iAppointDao.delAppointById(id);
        if(i == 0)
            return false;
        return true;
    }

    public List<Integer> getAppointOnCourseth(Time time){
        return iAppointDao.getAppointOnCourseth(time);
    }

    public static void main(String[] args) throws Exception {
        //单元测试
        AppointService appointService = new AppointService();
        List<Appoint> appoints = appointService.findAll();
//        System.out.println("返回所有记录:");
//        for (Appoint appoint :
//                appoints) {
//            System.out.println(appoint);
//        }
//        System.out.println("根据实验编号返回实验:");
//        System.out.println(appointService.getAppointById(1).toString());

        //新增
        Appoint appoint = new Appoint(2,"123","1011",1,1,
                2,2,2,"实验1","123","牛旭光");
//        boolean add = appointService.addAppoint(appoint);
//        if(add == true)
//            System.out.println("新增很成功");
//        else
//            System.out.println("新增失败");
//
//        System.out.println("最大编号：");
//        System.out.println(appointService.getMaxId());

//        //删除
//        boolean del = appointService.delAppointById(appoint.getId());
//        if(del == true){
//            System.out.println("删除成功,剩下：");
//            appoints = appointService.findAll();
//            for (Appoint appoint1 : appoints){
//                System.out.println(appoint1.toString());
//                System.out.println("1");
//            }
//        }
//        else
//            System.out.println("删除失败");
        Time time = new Time(2020,1,1,1,1,"1011");
        System.out.println("本节课被预约的机位有：");
        List<Integer> cpt = appointService.getAppointOnCourseth(time);
        for(int i:cpt){
            System.out.println(i);
        }
    }
}
