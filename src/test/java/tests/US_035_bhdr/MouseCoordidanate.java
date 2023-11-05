package tests.US_035_bhdr;
import tests.US_010_Burhan.utilities.ReusableMethods;

import java.awt.*;

public class MouseCoordidanate {
    public static void main(String[] args) {
        ReusableMethods.wait(5);
        Point point = MouseInfo.getPointerInfo().getLocation();
        int x = (int) point.getX();
        int y = (int) point.getY();
        System.out.println("Mouse coordinates: " + x + ", " + y);
    }
    //Mouse coordinates1: 676, 229
    //Mouse coordinates2: 1126, 722
}