package main.Java.service;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import main.Java.daoImpl.*;
import main.Java.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import main.Java.test.SqlSessionUtils;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AppointService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    IAppointDao iAppointDao = session.getMapper(IAppointDao.class);

    public AppointService() {
    }

    public List<Appoint> findAll(){
        List<Appoint> appoints = iAppointDao.findAll();
        if(appoints == null)
            return null;
        return appoints;
    }

    public Appoint getAppointById(int id){
        List<Appoint> appoints = iAppointDao.getAppointById(id);
        if(appoints == null)
            return null;
        return appoints.get(0);
    }

    public int getMaxId(){
        int i = iAppointDao.getMaxId();
        if(i == 0)
            return 0;
        return i;
    }

    public boolean isExistOfAppointByTimeAndStuId(int weekth,int dayth,int courseth,String stu_id){
        List<Appoint> appoints = iAppointDao.isExistOfAppointByTimeAndStuId(weekth,dayth,courseth,stu_id);
        if(appoints == null || appoints.size() == 0)
            return false;
        return true;
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
        List<Integer> integers = iAppointDao.getAppointOnCourseth(time);
        if(integers == null)
            return null;
        return integers;
    }

    public List<Integer> getNoAppointOnCourseth(Time time){
        List<Integer> integers = iAppointDao.getAppointOnCourseth(time);
        int[] noAppoint = new int[73];
        for(Integer integer:integers){
            noAppoint[integer] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=72;i++){
            if(noAppoint[i]==0){
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        //单元测试
        AppointService appointService = new AppointService();
        List<Appoint> appoints = appointService.findAll();
        List<Integer> noAppoint = new ArrayList();
        Time time = new Time(0,1,1,1,1,"1011");
//        noAppoint = appointService.getNoAppointOnCourseth(time);
//        for(Integer integer:noAppoint){
//            System.out.println(integer);
//        }
        if(appointService.isExistOfAppointByTimeAndStuId(1,1,1,"918106840540"))
            System.out.println("存在记录");
        else
            System.out.println("不存在记录");
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
//        Time time = new Time(2020,1,1,1,1,"1011");
//        System.out.println("本节课被预约的机位有：");
//        List<Integer> cpt = appointService.getAppointOnCourseth(time);
//        for(int i:cpt){
//            System.out.println(i);
//        }
    }
}

