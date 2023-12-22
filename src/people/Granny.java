package people;

import actions.*;
import emotions.*;
import exceptions.CheckIfThisCouldEverHappen;
import locations.*;
import seasons.*;

public class Granny extends Human implements Action, Emotion, Location, Season
{

    public Granny(String nm, people.Writer wrt, Actions act, Emotions emo)
    {
        name = nm;
        writer = wrt;
        action = act;
        emotion = emo;
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
            case LAY -> writer.write(name + " лежит на диване");
            case CRY -> writer.write(name + " плачет");
            case COME -> writer.write(name + " возвращается домой");
            case TRAVEL -> writer.write(name + " приезжает в город к семье");
            case TURN -> writer.write(name + " отмечает день рождения");
            case WAIT -> writer.write(name + " очень ждёт своего внука");
            case CALL -> writer.write(name + " звонит по телефону");
        }
    }

    @Override
    public void returnEmotion() {
        switch (emotion) {
            case CALM -> writer.write(name + " спокойна");
            case HAPPY -> writer.write(name + " счастлива");
            case SAD -> writer.write(name + " грустит");
            case BORED -> writer.write(name + " утомлена");
            case MISSING -> writer.write(name + " скучает по своему внуку");
            case ANGRY -> writer.write(name + " сердится");
        }
    }

    @Override
    public void returnLocation() throws CheckIfThisCouldEverHappen {
        Locations location = this.getLocation();
        switch (location) {
            case HOME -> writer.write(name + " дома у родных. Наконец-то она проводит с ними много времени");
            case VILLAGE -> writer.write(name + " в деревне. Здесь у неё хватает дел до приезда внука");
            case SCHOOL -> throw new CheckIfThisCouldEverHappen(name + " не учится в школе");
            case ROOF -> throw new CheckIfThisCouldEverHappen(name + " не живёт на крыше");
        }
    }

    @Override
    public void returnSeason() {
        Seasons season = this.getSeason();
        switch (season) {
            case SUMMER -> writer.write(name + " любит лето и с нетерпением ждёт внука");
            case WINTER -> writer.write(name + " любит зиму. К тому же у неё день рождения в январе, а тогда " +
                    "она приезжает навестить близких");
            case SPRING -> writer.write(name + " любит весну, ведь скоро к ней приедет любимый внук");
            case AUTUMN -> writer.write(name + " не любит осень, потому что переживает за внука");
        }
    }

    // локальный класс
    public void checkGarden(String state) {
        class CheckGarden {
            private final String state;

            public CheckGarden(String state) {
                this.state = state;
            }

            public void showDetails() {
                writer.write("Состояние сада и огорода: " + state);
            }
        }

        CheckGarden checkGarden = new CheckGarden(state);
        checkGarden.showDetails();
    }
}
