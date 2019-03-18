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

public class Triangle extends Shape {
    private static final double SIDE_LENGTH = 230;
    private static final int SIDE_SIZE = 3;
    private static final double SQRT3 = Math.sqrt(3);

    public Triangle(Button btn) {
        super(btn);
    }


    @Override
    public Shape draw(Pane p, double centerX, double centerY) {
        Canvas canvas = new Canvas(p.getWidth(), p.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.setColor(Color.RED);
        gc.setFill(this.getColor());

        double[] xPoints = new double[3];
        double[] yPoints = new double[3];

        // 计算等腰三角形三个点位置
        // 判断中心点是否超过面板的长和宽，若超过，则选择中心点为面板中心位置，绘制
        if (p.getWidth() < (centerX + SIDE_LENGTH * 0.5)
                || (0 > (centerX - SIDE_LENGTH * 0.5))) {
            centerX = p.getWidth() / 2;
        }

        if (p.getHeight() < (centerY + SQRT3 * SIDE_LENGTH / 6)
                || 0 > (centerY - SQRT3 * SIDE_LENGTH / 3)) {
            centerY = 2 * p.getHeight() / 3;
        }

        boolean flag = true;
        try {
            this.calculPoints(centerX, centerY, xPoints, yPoints);
        } catch (Exception e) {
            gc.fillText(e.getMessage(), centerX, centerY);
            flag = false;
        }
        if (flag) {
//            // 画多边形
//            gc.strokePolyline(xPoints, yPoints, SIDE_SIZE);
//            // 最后一个点到第一个点的连线
//            gc.strokePolyline(new double[]{xPoints[SIDE_SIZE-1], xPoints[0]}, new double[]{yPoints[SIDE_SIZE-1], yPoints[0]}, 2);
//            // 填充颜色
//            gc.strokePolyline(new double[]{centerX, centerX+10}, new double[]{centerY, centerY+10}, 2);
//            System.out.println(String.format("(%f, %f)", centerX, centerY));
//            System.out.println(String.format("width=%f, height=%f, layoutX=%f, layoutY=%f",
//                    p.getWidth(), p.getHeight(), p.getLayoutX(), p.getLayoutY()));
//            // 画个点，0，0，颜色为黑色
//            for (int i = 0; i < SIDE_SIZE; i++) {
//                System.out.println(String.format("(%f, %f)", xPoints[i], yPoints[i]));
//            }
            gc.strokePolyline(new double[]{p.getLayoutX()}, new double[]{p.getLayoutY()}, 1);
            gc.fillPolygon(xPoints, yPoints, SIDE_SIZE);
        }
        p.getChildren().add(canvas);
        return this;
    }

    //计算等腰三角形的三个点
    private void calculPoints(double centerX, double centerY, double[] xs, double[] ys) throws Exception {
        //计算xs和ys，查看是否符合要求
        if (xs == null || xs.length != SIDE_SIZE) {
            throw new Exception(String.format("x points is null or sides size not %d", SIDE_SIZE));
        }
        if (ys == null || ys.length != SIDE_SIZE) {
            throw new Exception(String.format("y points is null or sides size not %s", SIDE_SIZE));
        }
        // 初始化三点坐标为0
        for (int i = 0; i < SIDE_SIZE; i++) {
            xs[i] = 0;
            ys[i] = 0;
        }

        //计算三角形三个点
        xs[0] = centerX;
        ys[0] = centerY - SQRT3 / 3 * SIDE_LENGTH;

        xs[1] = centerX - 0.5 * SIDE_LENGTH;
        ys[1] = centerY + SQRT3 / 6 * SIDE_LENGTH;

        xs[2] = centerX + 0.5 * SIDE_LENGTH;
        ys[2] = centerY + SQRT3 / 6 * SIDE_LENGTH;
    }
}
