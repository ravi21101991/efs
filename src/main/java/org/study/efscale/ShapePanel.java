package org.study.efscale;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

class ShapePanel extends JPanel {

    private TriangleShape triangleShape;
    private PolygonShape polygonShape;

    ShapePanel(double factor) {
        triangleShape = new TriangleShape(
                new Point2D.Double(100, 100),
                new Point2D.Double(0, 0),
                new Point2D.Double(200, 0)
        );

        polygonShape = new PolygonShape(factor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLUE);
        g2d.fill(triangleShape);

        g2d.setColor(Color.WHITE);
        g2d.fill(polygonShape);
        g2d.dispose();
    }
}

class TriangleShape extends Path2D.Double {

    TriangleShape(Point2D... points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
}

class PolygonShape extends Path2D.Double {

    PolygonShape(double factor) {
        if (factor > 0) {
            int xMin = 15;
            int yMin = 15;
            int maxX = 200;
            double xFactor = xMin * factor;
            double yFactor = yMin * factor;
            moveTo(xFactor, yFactor);
            lineTo(0, 0);
            lineTo(maxX - xFactor, yFactor);
            moveTo(maxX - xFactor, yFactor);
            lineTo(maxX, 0);
            lineTo(0, 0);
            closePath();
        }
    }
}