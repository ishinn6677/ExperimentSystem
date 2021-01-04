package main.Java.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 * @author ：
 * @date ：Created in 2021年1月1日17:42:21
 * @description ： 存放本学期校历基本信息，change返回距离本学期第一周第一天有点少天
 */

public class ChangeDate {
    //本学期日历第一周第一天的日期,为周一
    private int year=2020;
    private int month=8;
    private int day=31;
    //第几学期
    private int semester=1;
    private int weekday;
    private int[] monthday=new int[13];;
    public  ChangeDate(){

    }
    public int getSemester(){
        return  semester;
    }
    public int change(String appointData){
        int count=0;
        //获取当前日期
/*        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String currentdate = localDate.format(dateTimeFormatter);*/
        //分割预约时间，获得预约的年月日
        int appointyear,appointmonth,appointday;
        String[] strs=appointData.split("-");
        System.out.println("strs:"+strs.length);
        for(int i=0,len=strs.length;i<len;i++){
            System.out.println(i+":"+strs[i].toString());
        }
        //处理日期时考虑首位为0
        appointyear=Integer.parseInt(strs[0]);
        appointmonth=Integer.parseInt(strs[1]);
        appointday=Integer.parseInt(strs[2]);
        if(year%4==0&&year%100!=0)
        monthday=new int[] {0,31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        else if(year%400==0)
            monthday=new int[] {0,31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        else monthday=new int[] {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int j=month;
        if(semester==1){
            if(appointyear-year==0) {
                if(appointmonth>month){
                    for (;j<13&&j<=appointmonth;j++){
                        //第一个月
                        if(j<appointmonth&&j==month)
                            count=count+monthday[j]-day+1;
                        //中间月
                        if(j<appointmonth&&j>month)
                            count=count+monthday[j];
                        if(j==appointmonth&&j>month)
                            count=count+appointday;
                    }
                }
                if(appointmonth==month){
                    count=count+appointday-day+1;
                }


            }

            if(appointyear-year!=0){
                //学期1.1之前的天数
                for (;j<13;j++){
                    //第一个月
                    if(j==month)
                        count=count+monthday[j]-day+1;
                    //中间月
                    if(j>month)
                        count=count+monthday[j];
                }
                //学期1.1及之后的天数,学校1月放假
                count=count+appointday;

            }
        }else{
            if(appointmonth>month){
                for (;j<7&&j<=appointmonth;j++){
                    //第一个月
                    if(j<appointmonth&&j==month)
                        count=count+monthday[j]-day+1;
                    //中间月
                    if(j<appointmonth&&j>month)
                        count=count+monthday[j];
                    if(j==appointmonth&&j>month)
                        count=count+appointday;
                }
            }
            if(appointmonth==month){
                count=count+appointday-day+1;
            }
        }
        return  count;
    }
    public static void main(String[] args) {
        //获取当前时间
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String date = localDate.format(dateTimeFormatter);
        System.out.println(date);//2020-01-11
        String[] strs=date.split("-");
        System.out.println("strs:"+strs.length);
        for(int i=0,len=strs.length;i<len;i++){
            System.out.println(i+":"+strs[i].toString());
        }
        int currentyear,currentmonth,currentday;
        currentyear=Integer.parseInt(strs[0]);
        currentmonth=Integer.parseInt(strs[1]);
        currentday=Integer.parseInt(strs[2]);
        int appointyear,appointmonth,appointday;
        Date date0=new Date();
        System.out.println(date0);
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        dateFm.format(date0);
        System.out.println(dateFm.format(date0));
        System.out.println(Integer.parseInt("01"));
        ChangeDate ex=new ChangeDate();
        String currentdate="2021-01-03";
        int count =ex.change(currentdate);
        int Week_th=0;
        int Day_th=0;
        if(count%7==0){
            Week_th=count/7;
            Day_th=7;
        }else {
            Week_th=count/7;
            Day_th=count-Week_th*7;
            Week_th++;
        }
        System.out.println(count);
        System.out.println(currentdate);
        System.out.println("第"+Week_th+"周"+"第"+Day_th+"天");
        int re= currentdate.compareTo("2021-01-02");
        System.out.println(re);
    }

}
