package com.study.effective.equals;

import java.awt.*;

/**
 *
 *使用复合优先于继承
 * Created by Administrator on 2017/9/10.
 */
public class ColorPointRepeat {
    private final Point point;
    private final Color color;

    public ColorPointRepeat(int x, int y,Color color){
        if(color == null){
            throw  new NullPointerException();
        }
        point = new Point(x,y);
        this.color = color;
    }

    public Point asPoint(){
        return  point;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ColorPoint))
            return false;
        ColorPointRepeat cp = (ColorPointRepeat) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }



}
