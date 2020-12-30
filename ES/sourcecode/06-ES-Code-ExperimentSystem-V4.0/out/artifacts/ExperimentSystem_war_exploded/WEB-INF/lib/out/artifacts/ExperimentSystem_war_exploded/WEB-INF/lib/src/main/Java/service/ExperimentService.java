package main.Java.service;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import main.Java.daoImpl.ICourseDao;
import main.Java.daoImpl.IExperimentDao;
import main.Java.daoImpl.ILoginDao;
import main.Java.daoImpl.IUserDao;
import main.Java.entity.Course;
import main.Java.entity.Experiment;
import main.Java.entity.Login;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import main.Java.test.SqlSessionUtils;

import java.io.InputStream;
import java.util.List;

public class ExperimentService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    IExperimentDao iExperimentDao = session.getMapper(IExperimentDao.class);

    public ExperimentService() {
    }

    public List<Experiment> findAll(){
        return iExperimentDao.findAll();
    }

    public Experiment getExperimentById(int id){
        return iExperimentDao.getExperimentById(id).get(0);
    }

    public int getMaxId(){
        return iExperimentDao.getMaxId();
    }

    public boolean addExperiment(Experiment experiment){
        int i = iExperimentDao.addExperiment(experiment);
        if(i == 0)
            return false;
        return true;
    }

    public boolean delExperimentById(int id){
        int i = iExperimentDao.delExperimentById(id);
        if(i == 0)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        //单元测试
        ExperimentService experimentService = new ExperimentService();
        List<Experiment> experiments = experimentService.findAll();
        System.out.println("返回所有记录:");
        for (Experiment experiment :
                experiments) {
            System.out.println(experiment);
        }
        System.out.println("根据实验编号返回实验:");
        Experiment experiment = experimentService.getExperimentById(1);
        System.out.println(experiment.toString());

        //新增
        experiment = new Experiment(3,"实验3","789","潘玉兰",
                "使用Verilog语言在vavado上建立一个cpu并且上板验证","2020.12.30","1011",1,2020);
//        boolean add = experimentService.addExperiment(experiment);
//        if(add == true)
//            System.out.println("新增很成功");
//        else
//            System.out.println("新增失败");
//
        System.out.println("最大编号：");
        System.out.println(experimentService.getMaxId());

//        //删除
//        boolean del = experimentService.delExperimentById(experiment.getId());
//        if(del == true){
//            System.out.println("删除成功,剩下：");
//            experiments = experimentService.findAll();
//            for (Experiment experiment2 : experiments){
//                System.out.println(experiment2.toString());
//                System.out.println("1");
//            }
//        }
//        else
//            System.out.println("删除失败");
    }
}
