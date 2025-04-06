package services;

import itmo.lab.web4.models.Point;
import itmo.lab.web4.services.AreaChecker;
import itmo.lab.web4.services.PointsService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


public class AreaCheckerTest {


    AreaChecker areaChecker;


    @BeforeEach
    void init(){
     areaChecker =new AreaChecker();
    }


    @Test
    void checkIfInTheSpot(){
        Point point = new Point();
        point.setX(-1);
        point.setY(0.5);
        point.setR(1);
        Assertions.assertTrue(areaChecker.isInTheSpot(point));

    }


    @Test
    void checkIfNotInTheSpot(){
        Point point = new Point();
        point.setX(-0.1);
        point.setY(2);
        point.setR(2);
        Assertions.assertFalse(areaChecker.isInTheSpot(point));

    }



}
