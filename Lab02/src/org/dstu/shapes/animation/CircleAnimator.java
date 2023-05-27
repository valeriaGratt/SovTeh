package org.dstu.shapes.animation;

import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class CircleAnimator extends Animator {

    public CircleAnimator(Shape shape, JComponent component) {
        super(shape, component);
    }

    @Override
    public void run() {
        int xStep = 1;
        int yStep = 0;
        while (true) {
            if(shape.getX() <= 100 && shape.getY() <= 100) {
                xStep = 1;
                yStep = 0;
                shape.setColor(new Color((int)(Math.random() * 0x1000000)));
            } else if (shape.getX() >= 700 && shape.getY() <= 100) {
                xStep = 0;
                yStep = 1;
                shape.setColor(new Color((int)(Math.random() * 0x1000000)));
            } else if (shape.getX() >= 700 && shape.getY() >= 700) {
                xStep = -1;
                yStep = 0;
                shape.setColor(new Color((int)(Math.random() * 0x1000000)));
            } else if (shape.getX() <= 100 && shape.getY() >= 700) {
                xStep = 0;
                yStep = -1;
                shape.setColor(new Color((int)(Math.random() * 0x1000000)));
            }

            shape.moveRel(xStep, yStep);
            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
