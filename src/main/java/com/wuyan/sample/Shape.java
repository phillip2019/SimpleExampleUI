package com.wuyan.sample;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @ClassName: Shape
 * @Description: 几何形状基类
 * @Author: xiaowei.song
 * @Date: 2019/3/15 20:41
 * @Version: 1.0.0
 **/

public class Shape {
    private Color color;

    public Shape(Button btn) {
        btn.setUserData(this);
    }

    /*
     * 画几何形状
     */
    public Shape draw(Pane p, double centerX, double centerY) {
        return this;
    }

    /*
     * 清除几何形状
     */
    public Shape erase(Pane p) {
        p.getChildren().clear();
        return this;
    }

    /*
     * 移动几何形状
     */
    public Shape move(Pane p) {
        return this;
    }

    /**
     * 获取几何形状的颜色
     * @return
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * 设置几何形状颜色
     * @return
     */
    public void setColor(Color c) {
        if (c == null) {
            c = Color.WHITE;
        }
        this.color = c;
    }

}
