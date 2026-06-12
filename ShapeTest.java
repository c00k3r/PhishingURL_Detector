abstract class Shape {
      abstract double calculateArea();
}
class Circle extends Shape {
    double radius;

    Circle(double radius){
        this.radius = radius;
    }
    @Override
    double calculateArea(){
        return Math.PI * radius * radius;
    }
}
class Square extends Shape {
    double side;
    Square(double side){
        this.side=side;
    }
    @Override
    double calculateArea(){
        return side * side;
    }
}
public class ShapeTest{
    public static void main(String[] args) {
        Shape Circle = new Circle(4);
        System.out.println("Area of circle is : " +Circle.calculateArea());
        Shape Square = new Square(6);
        System.out.println("Are of square is : " +Square.calculateArea());
    }
}
