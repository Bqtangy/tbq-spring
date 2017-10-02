package com.study.effective.equals;

import java.awt.*;
import java.util.Collections;

/**
 * equals 的传递性
 * Created by Administrator on 2017/9/10.
 */
public class ColorPoint extends Point {
    private  final Color color;

    public ColorPoint(int x, int y,Color color) {
        super(x, y);
        this.color = color;
    }

   /* //没有对称性
    @Override
    public boolean equals(Object o){
        if(!(o instanceof ColorPoint)){
            return false;
        }
        return super.equals(o) &&((ColorPoint) o).color == color;
    }
    */

   //有对称性，失去的传递性
    @Override
    public boolean equals(Object o){
        if(!(o instanceof  Point))
            return  false;

        if(!(o instanceof ColorPoint))
            return o.equals(this);

        return super.equals(o) && ((ColorPoint) o).color == color;

    }



    public static void main(String[] args) {
       /* Point p = new Point(1,2);
        ColorPoint  cp = new ColorPoint(1,2,Color.black);

        System.out.println("返回的值："+p.equals(cp));

        System.out.println("返回值应该是："+cp.equals(p));*/

       ColorPoint  p1 = new ColorPoint(1,2,Color.black);
       Point  p2 = new Point(1,2);
       ColorPoint  p3 = new ColorPoint(1,2,Color.blue);

        System.out.println("返回的值："+p1.equals(p2));
        System.out.println("得到的值："+p2.equals(p3));
        System.out.println("考虑颜色"+p1.equals(p3));

    }
}
