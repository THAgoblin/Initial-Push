package Abstraction;

public class Triangle extends Shape{

    double height;
    double length;

Triangle(double height ,double length){
    this.height = height;
    this.length = length;
}

    @Override
    double area() {
        return (height *length)/2;
    }
}
