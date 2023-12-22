package people;

import actions.*;
import emotions.*;
import exeptions.CustomCheckedException;
import locations.*;
import seasons.*;

public class Mother extends Human implements Action, Emotion, Location, Season
{

    public Mother(String nm, people.Writer wrt, Actions act, Emotions emo)
    {
        name = nm;
        writer = wrt;
        action = act;
        emotion = emo;
    }

    @Override
    public void happeningNow() throws CustomCheckedException {
        returnEmotion();
        returnAction();
    }

    @Override
    public void returnAction() {
        switch (action) {
            case NOACTION -> writer.write(name + " бездействует");
            case LAY -> writer.write(name + " лежит на диване и читает книгу");
            case CRY -> writer.write(name + " плачет");
            case COME -> writer.write(name + " возвращается домой");
            case TRAVEL -> writer.write(name + " едет на работу");
            case TURN -> writer.write(name + " отмечает день рождения");
            case WAIT -> writer.write(name + " ждёт зарплату");
            case CALL -> writer.write(name + " звонит по телефону");
        }
    }

    @Override
    public void returnEmotion() {
        switch (emotion) {
            case CALM -> writer.write(name + " спокойна");
            case HAPPY -> writer.write(name + " счастлива");
            case SAD -> writer.write(name + " грустит");
            case BORED -> writer.write(name + " очень устала");
            case MISSING -> writer.write(name + " скучает по бабушке");
        }
    }

    @Override
    public void returnLocation() throws CustomCheckedException {
        Locations location = this.getLocation();
        switch (location) {
            case HOME -> writer.write(name + " дома. Здесь она может отдохнуть и заняться делами по дому");
            case VILLAGE -> writer.write(name + " приезжает в деревню");
            case SCHOOL -> throw new CustomCheckedException(name + " не учится в школе");
            case ROOF -> throw new CustomCheckedException(name + " не живёт на крыше");
        }
    }

    @Override
    public void returnSeason() {
        Seasons season = this.getSeason();
        switch (season) {
            case SUMMER -> writer.write(name + " любит лето из-за отличной погоды");
            case WINTER -> writer.write(name + " любит зиму, ведь на праздниках приезжает бабушка из деревни");
            case SPRING -> writer.write(name + " любит весну, потому что много праздничных дней");
            case AUTUMN -> writer.write(name + " не любит осень. Она часто болеет осенью");
        }
    }
}
