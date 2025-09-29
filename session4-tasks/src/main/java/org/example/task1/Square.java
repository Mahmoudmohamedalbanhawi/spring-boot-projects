package org.example.task1;


public class Square implements Shape{
    private float side;
    private Draw2d draw2d;
    private Draw3d draw3d;
    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void draw2d() {
        this.draw2d.drawShape(drawSquare());
    }

    @Override
    public void draw3d() {
        this.draw3d.drawShape(drawSquare());
    }



    public void setDraw2d(Draw2d draw2d) {
        this.draw2d = draw2d;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }


    public void setDraw3d(Draw3d draw3d) {
        this.draw3d = draw3d;
    }
    private String drawSquare()
    {
        return  "Square";
    }
}
