package people;

import actions.*;
import animals.Dog;
import emotions.*;
import exeptions.CustomCheckedException;
import locations.*;
import seasons.*;

public class Boy extends Human implements Action, Emotion, Location, Season
{
    public Boy(String nm, people.Writer wrt, Actions act, Emotions emo)
    {
        name = nm;
        writer = wrt;
        action = act;
        emotion = emo;
    }

    public void haveDog() {
        if (Dog.Owner.ownerName().equals(name))
            writer.write("Сейчас собака у персонажа с именем " + name);
        else
            writer.write("Сейчас собака у не персонажа с именем " + name);
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
            case LAY -> writer.write(name + " лежит на диване");
            case CRY -> writer.write(name + " плачет");
            case COME -> writer.write(name + " возвращается домой");
            case TRAVEL -> writer.write(name + " приезжает гости к другу");
            case TURN -> writer.write(name + " отмечает день рождения");
            case WAIT -> writer.write(name + " ждёт каникулы");
            case CALL -> writer.write(name + " звонит по телефону");
        }
    }

    @Override
    public void returnEmotion() {
        switch (emotion) {
            case CALM -> writer.write(name + " спокоен");
            case HAPPY -> writer.write(name + " счастлив");
            case SAD -> writer.write(name + " грустит");
            case BORED -> writer.write(name + " хочет отдохнуть");
            case MISSING -> writer.write(name + " скучает по лету");
            case ANGRY -> writer.write(name + " сердится");
        }
    }

    @Override
    public void returnLocation() throws CustomCheckedException {
        Locations location = this.getLocation();
        switch (location) {
            case HOME -> writer.write(name + " дома. Он сделает уроки, а после отдохнёт");
            case VILLAGE -> writer.write(name + " в деревне");
            case SCHOOL -> throw new CustomCheckedException(name + " сейчас в школе");
            case ROOF -> throw new CustomCheckedException(name + " не живёт на крыше");
        }
    }

    @Override
    public void returnSeason() {
        Seasons season = this.getSeason();
        switch (season) {
            case SUMMER -> writer.write(name + " любит лето");
            case WINTER -> writer.write(name + " любит зиму, потому что будут каникулы");
            case SPRING -> writer.write(name + " любит весну, ведь скоро лето, да и много праздничных дней");
            case AUTUMN -> writer.write(name + " не любит осень, потому что надо учиться");
        }
    }
}
