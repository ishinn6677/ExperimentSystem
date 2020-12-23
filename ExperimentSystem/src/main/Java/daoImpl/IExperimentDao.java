package daoImpl;

import entity.Experiment;
import entity.Login;

import java.util.List;

public interface IExperimentDao {
    List<Experiment> findAll();              //返回所有的记录
    List<Experiment> getExperimentById(int id);  //根据 实验编号 返回实验
    int getMaxId(); //返回编号最大值
    int addExperiment(Experiment experiment);            //新增实验
    int delExperimentById(int id);          //通过 实验编号 删除实验
}
