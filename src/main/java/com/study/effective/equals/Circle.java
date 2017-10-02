package com.study.effective.equals;

import java.util.HashSet;
import java.util.Set;

/**
 * 圆的一般初始化
 * Created by Administrator on 2017/9/10.
 */
public class Circle {
    private static final Set<Point> unitCircle;

    static {
        unitCircle = new HashSet<Point>();
        unitCircle.add(new Point(1,0));
        unitCircle.add(new Point(0,1));
        unitCircle.add(new Point(-1,0));
        unitCircle.add(new Point(0,-1));
    }

    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);

    }



}
