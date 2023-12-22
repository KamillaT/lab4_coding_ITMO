package people;

import actions.*;
import emotions.*;
import exeptions.CustomCheckedException;
import seasons.*;
import locations.*;

public abstract class Human
{
    public String name;
    protected Writer writer;
    protected Actions action;
    protected Emotions emotion;
    protected String behaviour = "";
    private Locations location;
    private Seasons season;
    public abstract void happeningNow() throws CustomCheckedException;
    public void setAction(Actions action) {
        this.action = action;
    }
    public Actions getAction() {
        return action;
    }
    public void setEmotion(Emotions emotion) { this.emotion = emotion; }
    public Emotions getEmotion() {
        return emotion;
    }
    public void setLocation(Locations location) {
        this.location = location;
    }
    public Locations getLocation() {
        return location;
    }
    public void setSeason(Seasons season) {
        this.season = season;
    }
    public Seasons getSeason() {
        return season;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        Human others = (Human) obj;
        return this.name == others.name;
    }

    public int hashCode() {
        return this.name.hashCode() * this.writer.hashCode();
    }

    public String toString() {
        return "Персонаж: " + this.name;
    }
}
