import actions.*;
import animals.*;
import emotions.*;
import exeptions.CustomCheckedException;
import locations.Locations;
import people.*;
import seasons.Seasons;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) throws CustomCheckedException {
        NarratorImpl nar = new NarratorImpl();
        Malysh malysh = new Malysh("Малыш", nar, Actions.NOACTION, Emotions.CALM);
        Granny grandma = new Granny("Бабушка", nar, Actions.NOACTION, Emotions.CALM);
        Mother mom = new Mother("Мама", nar, Actions.NOACTION, Emotions.CALM);
        PropellerMan karlson = new PropellerMan("Карлсон", nar, Actions.NOACTION, Emotions.CALM);
        Boy staphan = new Boy("Стафан Альберг", nar, Actions.NOACTION, Emotions.CALM);
        Boy gunilla = new Boy("Гунилла", nar, Actions.NOACTION, Emotions.CALM);
        Boy krister = new Boy("Кристер", nar, Actions.NOACTION, Emotions.CALM);
        int mn = 1;
        int mx = 5;
        int num = (int) (((mx - mn) * random()) + mn);

        switch (num) {
            case 1 -> {
                System.out.println("Сейчас лето");
                System.out.println("--------------------------------");

                malysh.setSeason(Seasons.SUMMER);
                malysh.returnSeason();
                malysh.setAction(Actions.WAIT);
                malysh.setEmotion(Emotions.HAPPY);
                malysh.happeningNow();
                System.out.println("--------------------------------");

                grandma.setSeason(Seasons.SUMMER);
                grandma.returnSeason();
                grandma.setLocation(Locations.VILLAGE);
                grandma.returnLocation();
                grandma.setAction(Actions.WAIT);
                grandma.setEmotion(Emotions.MISSING);
                grandma.happeningNow();
                grandma.checkGarden("превосходно!");
                System.out.println("--------------------------------");

                malysh.setAction(Actions.TURN);
                malysh.returnAction();
                System.out.println("--------------------------------");

                gunilla.setAction(Actions.TRAVEL);
                gunilla.setEmotion(Emotions.HAPPY);
                gunilla.happeningNow();
                krister.setAction(Actions.TRAVEL);
                krister.setEmotion(Emotions.HAPPY);
                krister.happeningNow();
                gunilla.setAction(Actions.COME);
                gunilla.returnAction();
                krister.setAction(Actions.COME);
                krister.returnAction();
                System.out.println("--------------------------------");

                malysh.setAction(Actions.TRAVEL);
                malysh.returnAction();
                malysh.setLocation(Locations.VILLAGE);
                malysh.returnLocation();
                System.out.println("--------------------------------");

                karlson.setLocation(Locations.ROOF);
                karlson.returnLocation();
                karlson.setEmotion(Emotions.MISSING);
                karlson.setAction(Actions.WAIT);
                karlson.happeningNow();
                System.out.println("--------------------------------");

            }
            case 2 -> {
                System.out.println("Сейчас осень");
                System.out.println("--------------------------------");

                grandma.setSeason(Seasons.AUTUMN);
                grandma.returnSeason();
                grandma.setEmotion(Emotions.MISSING);
                grandma.setAction(Actions.LAY);
                grandma.happeningNow();
                grandma.checkGarden("идеально :)");
                System.out.println("--------------------------------");

                mom.setSeason(Seasons.AUTUMN);
                mom.returnSeason();
                mom.setAction(Actions.TRAVEL);
                mom.returnAction();
                System.out.println("--------------------------------");

                malysh.setSeason(Seasons.AUTUMN);
                malysh.returnSeason();
                malysh.setLocation(Locations.SCHOOL);
                malysh.returnLocation();
                malysh.setEmotion(Emotions.BORED);
                malysh.happeningNow();
                malysh.setAction(Actions.COME);
                malysh.happeningNow();
                System.out.println("--------------------------------");

                karlson.turnOn();
                karlson.setAction(Actions.TRAVEL);
                karlson.setEmotion(Emotions.HAPPY);
                karlson.happeningNow();
                karlson.setLocation(Locations.HOME);
                karlson.returnLocation();
                karlson.turnOff();
                System.out.println("--------------------------------");

                mom.setLocation(Locations.HOME);
                mom.returnLocation();
                mom.setEmotion(Emotions.BORED);
                mom.setAction(Actions.WAIT);
                mom.happeningNow();
                System.out.println("--------------------------------");
            }
            case 3 -> {
                System.out.println("Сейчас зима");
                System.out.println("--------------------------------");

                mom.setSeason(Seasons.WINTER);
                mom.returnSeason();
                grandma.setSeason(Seasons.WINTER);
                grandma.returnSeason();
                System.out.println("--------------------------------");

                grandma.setAction(Actions.TRAVEL);
                grandma.setEmotion(Emotions.HAPPY);
                grandma.happeningNow();
                mom.setEmotion(Emotions.HAPPY);
                mom.setAction(Actions.CALL);
                mom.happeningNow();
                mom.setAction(Actions.WAIT);
                mom.returnAction();
                System.out.println(mom.name + " получила зарплату");
                malysh.setEmotion(Emotions.HAPPY);
                malysh.returnEmotion();
                karlson.turnOn();
                karlson.setEmotion(Emotions.HAPPY);
                karlson.setAction(Actions.TRAVEL);
                karlson.setLocation(Locations.HOME);
                karlson.turnOff();
                System.out.println("--------------------------------");

                grandma.setAction(Actions.TURN);
                grandma.happeningNow();
                malysh.returnEmotion();
                karlson.returnEmotion();
                mom.returnEmotion();
                System.out.println("--------------------------------");

                grandma.setAction(Actions.COME);
                grandma.setEmotion(Emotions.MISSING);
                grandma.happeningNow();
                grandma.setLocation(Locations.VILLAGE);
                grandma.returnLocation();
                System.out.println("--------------------------------");
            }
            case 4 -> {
                System.out.println("Сейчас весна");
                System.out.println("--------------------------------");

                mom.setSeason(Seasons.SPRING);
                mom.returnSeason();
                grandma.setSeason(Seasons.SPRING);
                grandma.returnSeason();
                System.out.println("--------------------------------");

                System.out.println(malysh.name + " нашёл собаку и забрал домой");
                Dog.Owner.setOwner(malysh.name);
                Dog.Owner.getOwner();
                System.out.println("--------------------------------");

                staphan.haveDog();
                staphan.setEmotion(Emotions.SAD);
                staphan.returnEmotion();
                mom.setAction(Actions.CALL);
                mom.returnAction();
                System.out.println(staphan.name + " забирает собаку");
                staphan.setAction(Actions.COME);
                staphan.setEmotion(Emotions.HAPPY);
                staphan.happeningNow();
                try {
                    Dog.Owner.setOwner("");
                }
                catch (CustomCheckedException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                Dog.Owner.setOwner(staphan.name);
                Dog.Owner.getOwner();
                malysh.setEmotion(Emotions.SAD);
                malysh.setAction(Actions.CRY);
                malysh.happeningNow();
                System.out.println("--------------------------------");

                malysh.setLocation(Locations.SCHOOL);
                malysh.returnLocation();
                malysh.setEmotion(Emotions.BORED);
                malysh.setAction(Actions.WAIT);
                malysh.happeningNow();
                System.out.println("--------------------------------");

                grandma.setLocation(Locations.VILLAGE);
                grandma.returnLocation();
                grandma.setEmotion(Emotions.MISSING);
                grandma.returnEmotion();
                grandma.checkGarden("всёё пошло по плану");
                System.out.println("--------------------------------");
            }
        }
    }
}
