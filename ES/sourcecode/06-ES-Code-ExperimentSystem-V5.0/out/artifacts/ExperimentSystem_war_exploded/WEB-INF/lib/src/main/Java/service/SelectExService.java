package main.Java.service;

import main.Java.daoImpl.IExperimentDao;
import main.Java.daoImpl.ISelectExDao;
import main.Java.entity.Experiment;
import main.Java.entity.SelectEx;
import main.Java.test.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectExService {
    SqlSession session = SqlSessionUtils.getSqlSession();
    ISelectExDao iSelectExDao = session.getMapper(ISelectExDao.class);

    public SelectExService() {
    }
    public List<SelectEx> findAll(){//返回所有的记录
        return iSelectExDao.findAll();
    }
    public SelectEx getSelectExById(int id){//根据id返回选实验记录
        List<SelectEx> selectExes = iSelectExDao.getSelectExById(id);
        int i = selectExes.size();
        if(i == 0)
            return null;
        return selectExes.get(0);
    }
    public List<String> getStusByExId(int ex_id){//根据实验编号返回选择该实验的学生学号
        List<String> stu_ids = iSelectExDao.getStusByExId(ex_id);
        if(stu_ids.size() == 0)
            return null;
        return stu_ids;
    }
    public boolean addSelectEx(SelectEx selectEx){//新增选择实验记录
        int i = iSelectExDao.addSelectEx(selectEx);
        if(i == 0)
            return false;
        return true;
    }
    public boolean updateInfo(SelectEx selectEx){ //修改实验记录
        int i = iSelectExDao.updateInfo(selectEx);
        if(i == 0)
            return false;
        return true;
    }
    public boolean delSelectExById(int id){  //通过id删除选择试验记录
        int i = iSelectExDao.delSelectExById(id);
        if(i == 0)
            return false;
        return true;
    }
    public boolean setGrade(int ex_id,String stu_id, int grade){ //给实验打分数
        int i = iSelectExDao.setGrade(ex_id,stu_id,grade);
        if(i == 0)
            return false;
        return true;
    }
    public int getMaxId(){
        return iSelectExDao.getMaxId();
    }

    public Integer getGrade(int ex_id,String stu_id){  //获取分数
        List<Integer> grades = iSelectExDao.getGrade(ex_id,stu_id);
        if(grades.size() == 0)
            return null;
        return grades.get(0);
    }
    public List<SelectEx> getSeExsByExId(int ex_id){//通过实验id返回选择该实验的记录
        List<SelectEx> selectExes = iSelectExDao.getSelectExById(ex_id);
        if(selectExes.size() == 0)
            return null;
        return selectExes;
    }

    public boolean isExistOfSelect(int ex_id,String stu_id){
        List<SelectEx> selectExes = iSelectExDao.isExistOfSelect(ex_id,stu_id);
        if(selectExes.size() == 0)
            return false;
        return true;
    }

    public boolean delSelectExByExIdAndStuId(int ex_id,String stu_id){
        int i = iSelectExDao.delSelectExByExIdAndStuId(ex_id,stu_id);
        if(i == 0)
            return false;
        return true;
    }

    List<SelectEx> getSelectExByStuId(String stu_id){
        List<SelectEx> selectExes = iSelectExDao.getSelectExByStuId(stu_id);
        if(selectExes == null || selectExes.size() == 0)
            return null;
        return selectExes;
    }

    public static void main(String[] args) throws Exception {
        //单元测试
        SelectExService selectExService = new SelectExService();
        selectExService.delSelectExById(8);
/*        List<SelectEx> selectExes = selectExService.findAll();
        System.out.println("返回所有记录:");
        for (SelectEx selectEx :
                selectExes) {
            System.out.println(selectEx);
        }
        System.out.println("判断某实验是否存在:");
        if(selectExService.isExistOfSelect(1,"918106840540") == true)
            System.out.println("学生1选了实验1");
        else
            System.out.println("学生1没选实验1");

        System.out.println("根据实验id和学生id退选实验:");
        if(selectExService.delSelectExByExIdAndStuId(1,"918106840540"))
            System.out.println("退选成功");
        else
            System.out.println("退选失败");*/


//        System.out.println("根据编号返回实验:");
//        SelectEx selectEx = selectExService.getSelectExById(1);
//        System.out.println(selectEx.toString());
//
//        System.out.println("根据实验编号返回");
//        selectExes = selectExService.getSeExsByExId(2);
//        for (SelectEx selectEx2 :
//                selectExes) {
//            System.out.println(selectEx2);
//        }

        //新增
        //selectEx = new SelectEx(2,1,"实验1","123","石开",null,0);
//        boolean add = selectExService.addSelectEx(selectEx);
//        if(add == true)
//            System.out.println("新增很成功");
//        else
//            System.out.println("新增失败");
//            System.out.println("增加后：");
//            selectExes = selectExService.findAll();
//            for (SelectEx selectEx1 :
//                    selectExes) {
//                System.out.println(selectEx1.toString());
//            }

//        System.out.println("最大编号：");
//        System.out.println(selectExService.getMaxId());
//        System.out.println("打分：");
//        selectExService.setGrade(2,"456",98);
//        System.out.println(selectExService.getGrade(2,"456"));

//        //删除
//        boolean del = selectExService.delSelectExById(selectEx.getId());
//        if(del == true){
//            System.out.println("删除成功,剩下：");
//            selectExes = selectExService.findAll();
//            for (SelectEx selectEx1 :
//                    selectExes) {
//                System.out.println(selectEx1.toString());
//            }
//        }
//        else
//            System.out.println("删除失败");
    }
}


