package services;
import itmo.lab.web4.models.Point;
import itmo.lab.web4.services.AuthService;
import itmo.lab.web4.services.PointsService;
import itmo.lab.web4.services.Validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

public class ValidatorTest {


    Validator validator;


    @BeforeEach
    void init(){
        validator = new Validator();
    }


    @Test
    void testValidationSuccess(){
        Point point = new Point();
        point.setX(0);
        point.setY(0);
        point.setR(1);
        Assertions.assertTrue(validator.validate(point));

    }

    @Test
    void testValidationFailure(){
        Point point = new Point();
        point.setX(0);
        point.setY(0);
        point.setR(-3);
        Assertions.assertFalse(validator.validate(point));
    }

}
