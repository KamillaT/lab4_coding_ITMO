package people;

import exceptions.CheckIfThisCouldEverHappen;

public interface MotorMove {
    void turnOn() throws CheckIfThisCouldEverHappen;
    void turnOff();
}
