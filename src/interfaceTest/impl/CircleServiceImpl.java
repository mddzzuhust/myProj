package interfaceTest.impl;

import interfaceTest.ShapeService;

public class CircleServiceImpl implements ShapeService {

    @Override
    public void printShape() {
        System.out.println("i am circle");
    }
}
