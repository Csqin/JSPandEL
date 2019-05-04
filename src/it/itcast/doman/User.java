package it.itcast.doman;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private String Name;
    private  int Age;
    private Date Bir;

    public User(String name, int age, Date bir) {
        Name = name;
        Age = age;
        Bir = bir;
    }

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Date getBir() {
        return Bir;
    }

    public String getBirC()
    {
        if ( Bir!= null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
            return sdf.format(Bir);
        }
        else{return  "";}
    }
    public void setBir(Date bir) {
        Bir = bir;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Bir=" + Bir +
                '}';
    }
}
