package com.wuyan.sample;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * @ClassName: Circle
 * @Description: TDD
 * @Author: xiaowei.song
 * @Date: 2019/3/15 20:48
 * @Version: 1.0.0
 **/

public class Circle extends Shape {
    private int radius = 130;

    public Circle(Button btn) {
        super(btn);
    }


    @Override
    public Shape draw(Pane p, double centerX, double centerY) {
        Ellipse ellipse = new Ellipse();
        this.setColor(Color.GREEN);
        ellipse.setFill(this.getColor());

        // 判断中心点是否超过面板的长和宽，若超过，则选择中心点为圆心，绘制
        if (p.getWidth() < (centerX + radius) || (centerX - radius) < 0) {
            centerX = p.getWidth() / 2;
        }

        if (p.getHeight() < (centerY + radius) || (centerY - radius) < 0) {
            centerY = (p.getHeight()) / 2;
        }


        ellipse.setCenterX(centerX);
        ellipse.setCenterY(centerY);
        ellipse.setRadiusX(radius);
        ellipse.setRadiusY(radius);
        p.getChildren().add(ellipse);
        return this;
    }
}
