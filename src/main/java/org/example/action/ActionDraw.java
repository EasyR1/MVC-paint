package org.example.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;



public class ActionDraw {
    private MyShape sampleShape;
    private MyShape shape;
    private Point2D[] p;
    private Model model;

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public void init() {
        p = new Point2D[2];
    }


    public ActionDraw(Model model) {
        shape = new MyShape();
        this.model = model;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }
    public void stretchShape(Point point){
        p[1] = point;
        shape.setFrame(p);
    }
    public void createShape(Point point){
        p[0] = point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }
}