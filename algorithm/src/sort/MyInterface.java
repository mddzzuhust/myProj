package sort;

import interfaceTest.ShapeService;
import interfaceTest.impl.CircleServiceImpl;
import interfaceTest.impl.RectangleServiceImpl;
import interfaceTest.impl.SquareServiceImpl;

public class MyInterface {
    static ShapeService shapeService;

    public static void main(String[] args) {
       shapeService = new CircleServiceImpl();
       shapeService.printShape();

       shapeService = new RectangleServiceImpl();
       shapeService.printShape();

       shapeService = new SquareServiceImpl();
       shapeService.printShape();
    }
}
