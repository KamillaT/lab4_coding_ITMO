package animals;

import exceptions.CheckIfThisCouldEverHappen;
import actions.Action;

public class Dog {
    protected String realOwner;
    
    public Dog(String realOwner) {
        this.realOwner = realOwner;
    }
    private static String currentOwner;
    private boolean checkCurrentOwner = true;

    public void setOwner(String nameOfOwner) throws CheckIfThisCouldEverHappen {
        if (nameOfOwner == null || nameOfOwner.equals(""))
            throw new CheckIfThisCouldEverHappen("Имя не может быть пустой строкой");
        checkCurrentOwner = realOwner == nameOfOwner;
        currentOwner = nameOfOwner;
    }
    public void getOwner() {
        if (checkCurrentOwner)
            System.out.println(currentOwner + " владелец собаки");
        else
            System.out.println(currentOwner + " не настоящий владелец собаки, хоть собака сейчас у этого персонажа");
    }
    public void dogAction() {
        // анонимный класс
        Action action = new Action() {
            @Override
            public void returnAction() {
                System.out.println("Собачка просто наслаждается жизнью :)");
                showMood();
            }
            public void showMood() {
                System.out.println("Собака всегда в хорошем настроении");
            }
        };
        action.returnAction();
    }

    // статический вложенный класс
    public static class Owner {
        public static String ownerName() {
            return currentOwner;
        }
    }
}
