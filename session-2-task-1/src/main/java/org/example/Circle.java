package org.example;

public class Circle implements Shape {

    private final float pi = 3.14f;
    private float radius;
    @Override
    public double getArea() {
        return pi * radius * radius;
    }
    public float getRadius()
    {
        return this.radius;
    }
    public void setRadius(float radius)
    {
        this.radius = radius;
    }
    @Override
    public String toString()
    {
        return "the area of Circle is = " + getArea() ;
    }
}
