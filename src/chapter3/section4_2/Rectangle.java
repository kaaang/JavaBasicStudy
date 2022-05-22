package chapter3.section4_2;

public class Rectangle extends Shape{
    public int width;
    public int height;

    public Rectangle(int w, int h){
        super("Rectangle");
        width = w;
        height = h;
    }

    @Override
    public double computerArea() {
        return (double) width*height;
    }

    @Override
    public double computerPerimeter() {
        return 2.0*(width + height);
    }

    public String toString(){
        return "Rectangle : width is " + width + ", height is " + height;
    }
}
