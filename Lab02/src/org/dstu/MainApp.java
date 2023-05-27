package org.dstu;

import org.dstu.components.GraphicsPanel;
import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(100, 100, 100, Color.RED));
        shapes.add(new Circle(200, 100, 100, Color.GREEN));
        shapes.add(new Circle(300, 100, 100, Color.BLUE));
        shapes.add(new Circle(400, 100, 100, Color.MAGENTA));
        shapes.add(new Circle(500, 100, 100, Color.YELLOW));

        GraphicsPanel canvas = new GraphicsPanel(shapes);

//        Runnable circleController = () -> {
//            while (true) {
//                shapes.forEach(shape -> {
//                    if (shape instanceof Circle) {
//                        shape.moveRel((int)(Math.random() * 10), (int)(Math.random() * 10));
//                    } else if (shape instanceof Square) {
//                        shape.moveRel(-(int)(Math.random() * 10), -(int)(Math.random() * 10));
//                    }
//                });
//                canvas.repaint();
//                try {
//                    Thread.sleep(250);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };

        for (Shape s: shapes) {
            Thread t = new Thread(s.getAnimator(canvas));
            t.start();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);

//        Thread animationThread = new Thread(circleController);
//        animationThread.start();
    }
}
