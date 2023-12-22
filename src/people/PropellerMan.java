package people;

import actions.*;
import emotions.*;
import exceptions.*;
import locations.*;
import seasons.*;

public class PropellerMan extends Human implements Action, Emotion, Location, Season {

    public PropellerMan(String nm, people.Writer wrt, Actions act, Emotions emo)
    {
        name = nm;
        writer = wrt;
        action = act;
        emotion = emo;
    }

    // нестатический вложенный класс
    public class Motor implements MotorMove {
        private MotorState state = MotorState.OFF;

        @Override
        public void turnOn() {
            if (state == MotorState.ON) {
                throw new MotorCheck("Мотор уже включен");
            }
            this.state = MotorState.ON;
        }

        @Override
        public void turnOff() {
            if (state == MotorState.OFF) {
                throw new MotorCheck("Мотор уже выключен");
            }
            this.state = MotorState.OFF;
        }
    }

    Motor motor = new Motor();

    public void turnOn() {
        motor.turnOn();
        writer.write(this.name + " включил мотор");
    }

    public void turnOff() {
        motor.turnOff();
        writer.write(this.name + " выключил мотор");
    }

    @Override
    public void happeningNow() throws CheckIfThisCouldEverHappen {
        returnEmotion();
        returnAction();
    }

    @Override
    public void returnAction() {
        switch (action) {
            case NOACTION -> writer.write(name + " бездействует");
            case LAY -> writer.write(name + " лежит и уплетает пончики");
            case CRY -> writer.write(name + " плачет");
            case COME -> writer.write(name + " возвращается на крышу");
            case TRAVEL -> writer.write(name + " прилетает к малышу");
            case TURN -> writer.write(name + " отмечает день рождения");
            case WAIT -> writer.write(name + " ждёт возвращения друга и ест варенье");
            case CALL -> writer.write(name + " зовёт ");
        }
    }

    @Override
    public void returnEmotion() {
        switch (emotion) {
            case CALM -> writer.write(name + " спокоен");
            case HAPPY -> writer.write(name + " счастлив");
            case SAD -> writer.write(name + " грустит");
            case BORED -> writer.write(name + " не знает, чем себя занять");
            case MISSING -> writer.write(name + " скучает без друга");
            case ANGRY -> writer.write(name + " сердится");
        }
    }

    @Override
    public void returnLocation() throws CheckIfThisCouldEverHappen {
        Locations location = this.getLocation();
        switch (location) {
            case HOME -> writer.write(name + " дома у своего друга. Он помогает сделать важные дела, чтобы скорее отдохнуть");
            case VILLAGE -> throw new CheckIfThisCouldEverHappen(name + " не бывает в деревне");
            case SCHOOL -> throw new CheckIfThisCouldEverHappen(name + " не посещает школу");
            case ROOF -> writer.write(name + " живёт на крыше");
        }
    }

    @Override
    public void returnSeason() {
        Seasons season = this.getSeason();
        switch (season) {
            case SUMMER -> writer.write(name + " любит лето. В это время года почти каждый день светит солнце " +
                    "и очень тепло");
            case WINTER -> writer.write(name + " любит зиму. На новогодних каникулах он много времени проводит с другом");
            case SPRING -> writer.write(name + " с нетерпением ждёт лета");
            case AUTUMN -> writer.write(name + " не любит осень, потому что его друг ходит в школу, а веселиться не с кем");
        }
    }
}
