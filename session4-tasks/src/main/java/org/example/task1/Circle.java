package org.example.task1;

public class Circle implements Shape {

    private final float pi = 3.14f;
    private float radius;
    private Draw2d draw2d;
    private Draw3d draw3d;

    public Circle(Draw2d draw2d , Draw3d draw3d)
    {
        this.draw2d = draw2d ;
        this.draw3d = draw3d;
    }
    @Override
    public void draw2d()
    {
        this.draw2d.drawShape(drawCircle());
    }

    @Override
    public void draw3d()
    {
        this.draw3d.drawShape(drawCircle());
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    private String drawCircle()
    {
        return  "Circle";
    }
    public double getArea() {
        return pi * (radius * radius);
    }






}
