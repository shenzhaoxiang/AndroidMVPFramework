package com.ctsig.android.data.model.entity;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 17:38
 */
public class Demo extends BaseEntity {
    private int day;

    private String des;

    private int id;

    private String lunar;

    private int month;

    private String pic;

    private String title;

    private int year;

    public void setDay(int day){
        this.day = day;
    }
    public int getDay(){
        return this.day;
    }
    public void setDes(String des){
        this.des = des;
    }
    public String getDes(){
        return this.des;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setLunar(String lunar){
        this.lunar = lunar;
    }
    public String getLunar(){
        return this.lunar;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public int getMonth(){
        return this.month;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public String getPic(){
        return this.pic;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }
}
