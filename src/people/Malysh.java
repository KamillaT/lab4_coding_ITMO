package people;

import actions.*;
import emotions.*;
import exceptions.CheckIfThisCouldEverHappen;
import locations.*;
import seasons.*;

public class Malysh extends Boy implements Action, Emotion, Location, Season {
    public Malysh(String nm, people.Writer wrt, Actions act, Emotions emo) {
        super(nm, wrt, act, emo);
        name = nm;
        writer = wrt;
        action = act;
        emotion = emo;
    }

    public void haveDog() {
        super.haveDog();
    }

    public void happeningNow() throws CheckIfThisCouldEverHappen {
        returnEmotion();
        returnAction();
    }

    @Override
    public void returnAction() {
        switch (action) {
            case NOACTION -> writer.write(name + " бездействует");
            case LAY -> writer.write(name + " лежит ничком");
            case CRY -> writer.write(name + " плачет так горько, что сердце разрывается");
            case COME -> writer.write(name + " приходит домой");
            case TRAVEL -> writer.write(name + " приезжает в деревню к бабушке");
            case TURN -> writer.write(name + " отмечает день рождения. Теперь ему 8 лет");
            case WAIT -> writer.write(name + " так долго ждёт своего дня рождения");
            case CALL -> writer.write(name + " звонит по телефону");
        }
    }

    @Override
    public void returnEmotion() {
        switch (emotion) {
            case CALM -> writer.write(name + " спокоен");
            case HAPPY -> writer.write(name + " счастлив");
            case SAD -> writer.write(name + " грустит");
            case BORED -> writer.write(name + " утомлён");
            case MISSING -> writer.write(name + " скучает");
            case ANGRY -> writer.write(name + " сердится");
        }
    }

    @Override
    public void returnLocation() throws CheckIfThisCouldEverHappen {
        Locations location = this.getLocation();
        switch (location) {
            case HOME -> writer.write(name + " дома. Он может отдохнуть, а потом заняться делами");
            case VILLAGE -> writer.write(name + " в деревне. Он каждое утро ест блинчики, которые готовит бабушка, " +
                    "купается в речке, греется на солнце, играет с друзьями");
            case SCHOOL -> writer.write(name + " в школе. Хоть он и не любит ходить туда, но старается хорошо учиться. " +
                    "И, конечно, ждёт каникулы");
            case ROOF -> throw new CheckIfThisCouldEverHappen(name + " не живёт на крыше");
        }
    }

    @Override
    public void returnSeason() {
        Seasons season = this.getSeason();
        switch (season) {
            case SUMMER -> writer.write(name + " любит лето, потому что не надо ходить в школу, у него день рождения " +
                    "и он навестит свою бабушку");
            case WINTER -> writer.write(name + " любит зиму. На новогодних каникулах он много гуляет, играет в снежки, " +
                    "катается на лыжах. А ещё в январе призжает бабушка");
            case SPRING -> writer.write(name + " любит весну, ведь в это время года много праздничных дней, да и лето не за горами");
            case AUTUMN -> writer.write(name + " не любит осень, потому что начинается учёба, а в школу он ходить не любит");
        }
    }
}