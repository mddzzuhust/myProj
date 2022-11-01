package interfaceTest.impl;

import interfaceTest.ShapeService;

public class RectangleServiceImpl implements ShapeService {

    @Override
    public void printShape() {
        System.out.println("i am rectangle");
    }
}
