package animals;

import emotions.Emotions;
import exeptions.CustomCheckedException;
import actions.Action;

public class Dog {

    private static String owner = "Стафан Альберг";
    private static boolean check_current_owner = true;

    public static void dogAction() {
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
        public static void setOwner(String current_owner) throws CustomCheckedException {
            if (current_owner == null || current_owner.equals(""))
                throw new CustomCheckedException("Имя не может быть пустой строкой");
            String real_owner = "Стафан Альберг";
            if (real_owner != current_owner)
                check_current_owner = false;
            else
                check_current_owner = true;
            owner = current_owner;
        }
        public static void getOwner() {
            if (check_current_owner)
                System.out.println(owner + " владелец собаки");
            else
                System.out.println(owner + " не настоящий владелец собаки, хоть собака сейчас у этого персонажа");
        }

        public static String ownerName() {
            return owner;
        }
    }
}
