package com.wuyan.sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @ClassName: Circle
 * @Description: TDD
 * @Author: xiaowei.song
 * @Date: 2019/3/15 20:48
 * @Version: 1.0.0
 **/

public class Rectangle extends Shape {
    private final static double WIDTH = 300;
    private final static double HEIGHT = 260;

    public Rectangle(Button btn) {
        super(btn);
    }


    @Override
    public Shape draw(Pane p, double centerX, double centerY) {
        Canvas canvas = new Canvas(p.getWidth(), p.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.setColor(Color.YELLOW);
        gc.setFill(this.getColor());

        // 判断绘制点是否超过面板的长和宽，若超过，则选择中心点为圆心，绘制
        if (p.getWidth() < (centerX + WIDTH) || (centerX - WIDTH) < 0) {
            centerX = (p.getWidth()) / 2;
        }

        if (p.getHeight() < (centerY + HEIGHT) || (centerY - HEIGHT) < 0) {
            centerY = (p.getHeight()) / 2;
        }

        System.out.println(String.format("(%f, %f)", centerX, centerY));
        gc.fillRect(centerX - WIDTH/2, centerY - HEIGHT/2, WIDTH, HEIGHT);
        p.getChildren().add(canvas);
        return this;
    }
}
