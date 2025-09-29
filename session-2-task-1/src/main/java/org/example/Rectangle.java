package org.example;

public class Rectangle implements Shape {
    private double width;
    private double length;
    @Override
    public double getArea() {
        return this.width * this.length;
    }

    public double getLength() {
        return this.length;
    }
    public double getWidth()
    {
        return this.width;
    }
    public void setWidth(double width)
    {
        this.width = width;
    }
    public void setLength(double length)
    {
        this.length = length;
    }
    @Override
    public String toString()
    {
        return "the area of the rectangle is = " + this.getArea();
    }
}
