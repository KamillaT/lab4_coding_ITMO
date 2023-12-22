package people;

import exeptions.CustomCheckedException;

public interface MotorMove {
    void turnOn() throws CustomCheckedException;
    void turnOff();
}
