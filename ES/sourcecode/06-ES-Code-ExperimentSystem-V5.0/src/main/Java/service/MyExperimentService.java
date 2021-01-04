package main.Java.service;

import main.Java.daoImpl.IExperimentDao;
import main.Java.daoImpl.ILoginDao;
import main.Java.daoImpl.ISelectExDao;
import main.Java.entity.Experiment;
import main.Java.entity.MyExperiment;
import main.Java.entity.SelectEx;
import main.Java.test.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MyExperimentService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    //ExperimentService experimentService = session.getMapper(ExperimentService.class);
    //SelectExService selectExService = session.getMapper(SelectExService.class);
    ExperimentService experimentService = new ExperimentService();
    SelectExService selectExService = new SelectExService();

    public Vector<MyExperiment> getMyExperimentByStuId(String stu_id){
        Vector<MyExperiment> myExperiments = new Vector<>();
        Experiment experiment = new Experiment();
        List<SelectEx> selectExes = selectExService.getSelectExByStuId(stu_id);
        for(SelectEx selectEx:selectExes){
            MyExperiment myExperiment = new MyExperiment();
            experiment = experimentService.getExperimentById(selectEx.getEx_id());//获取实验
            myExperiment.setEx_id(experiment.getId());//实验id
            myExperiment.setEx_name(experiment.getEx_name());//实验名
            myExperiment.setEx_teacher(experiment.getEx_teacher_name());//实验老师
            myExperiment.setRoom(experiment.getRoom());//实验房间
            myExperiment.setYear(experiment.getYear());//实验年份
            myExperiment.setTerm(experiment.getTerm());//实验学期
            myExperiment.setDeadline(experiment.getDeadline());//截止日期
            myExperiment.setGrade(selectEx.getGrade());//分数
//            System.out.println(myExperiment.toString());
            myExperiments.add(myExperiment);
        }
        return myExperiments;
    }

    public static void main(String[] args) throws Exception{
        MyExperimentService myExperimentService = new MyExperimentService();
        List<MyExperiment> myExperiments = myExperimentService.getMyExperimentByStuId("918106840540");
        for(MyExperiment myExperiment:myExperiments){
            System.out.println(myExperiment.toString());
        }
    }
}
