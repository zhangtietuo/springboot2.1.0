package com.ztt.designMode.B_PrototypeMode;

import java.util.ArrayList;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/2 15:29
 */
public class Test {

    public static void main(String[] args) {
        Sheep cell1 = new Sheep();
        cell1.setName("普通绵羊");
        cell1.setAge(11);
        Sheep.Leg l = cell1.new Leg();  l.setLeglong("120");  l.setLegweight("10");
        cell1.setLeg(l);
        ArrayList<String> list = new ArrayList();
        list.add("母羊");
        list.add("白色");
        list.add("40kg");
        cell1.setStrs(list);

        try {
            Sheep cell1clone = (Sheep) cell1.clone();


            System.out.println(cell1clone.getName());
            System.out.println(cell1clone.getAge());
            System.out.println(cell1clone.strs.size());

            System.out.println( cell1.strs == cell1clone.strs );
            System.out.println( cell1.leg == cell1clone.leg );

        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
