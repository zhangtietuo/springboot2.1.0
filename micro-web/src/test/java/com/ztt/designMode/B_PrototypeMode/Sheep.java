package com.ztt.designMode.B_PrototypeMode;

import java.io.*;
import java.util.ArrayList;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/2 15:27
 */
public class Sheep implements Cloneable, Serializable {

    private String name;

    private int age;

    //表示羊腿
    public Leg leg;

    public ArrayList<String> strs = new ArrayList<String>(); //set get 方法省略，这个时候这个Sheep类中的clone方法中没有进行任何特殊操作

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public ArrayList<String> getStrs() {
        return strs;
    }

    public void setStrs(ArrayList<String> strs) {
        this.strs = strs;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        /*Sheep sheepClone = null;
        if(sheepClone==null){

            sheepClone = (Sheep) super.clone();
            sheepClone.strs =  (ArrayList<String>)(this.strs.clone());

        }
        return sheepClone;*/

        ByteArrayOutputStream bos = null ;
        ObjectOutputStream oos = null ;
        ByteArrayInputStream bis = null ;
        ObjectInputStream ois  = null ;
        try {
            //直接super.clone() 这个是浅克隆，只克隆八大基本数据类型   return super.clone();
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);


            //反序列化
            bis = new ByteArrayInputStream( bos.toByteArray() );
            ois = new ObjectInputStream( bis );
            Sheep copy = (Sheep) ois.readObject();


            return copy;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    protected class Leg implements Serializable {

        private String leglong;
        private String legweight;

        public String getLeglong() {
            return leglong;
        }

        public void setLeglong(String leglong) {
            this.leglong = leglong;
        }

        public String getLegweight() {
            return legweight;
        }

        public void setLegweight(String legweight) {
            this.legweight = legweight;
        }
    }
}
