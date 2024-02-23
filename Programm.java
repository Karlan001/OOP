import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Programm {
    public static void main(String[] args) {
        ArrayList<Heroes> team1 = new ArrayList<>();
        ArrayList<Heroes> team2 = new ArrayList<>();
        fill_team(team1, 9);
        fill_team(team2, 0);
//        System.out.println(team1.toString());
        System.out.println(team2.toString());
        Sniper sniper = new Sniper(random_name(), 1, 9);
        sniper.Step(team2);
        System.out.println();
        ArrayList<Heroes> team3 = new ArrayList<>();
        team3.addAll(team1);
        team3.addAll(team2);
        team3.sort(new Comparator<Heroes>() {
            @Override
            public int compare(Heroes o1, Heroes o2) {
                return o2.getInitiative() - o1.getInitiative();
            }
        });
        team3.stream().map(Heroes::getInfo).forEach(System.out::println);
    }

    static String random_name() {
        String[] arr = new String[]{"Oleg", "Ivan", "Stas", "Anna", "Olga", "Timofey", "Miron", "Angelina"};
        Random random = new Random();
        return arr[random.nextInt(arr.length)];
    }

    /**
     * Метод для автоматического заполнения команды из 5 объектов разных классов
     * @param team Массив команды, которую необходимо заполнить
     * @param y координата для выбора стороны (право/лево)
     */
    static void fill_team(ArrayList<Heroes> team, int y) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(1, 7);
            switch (num) {
                case 1:
                    team.add(new Sniper(random_name(), i, y));
                    break;
                case 2:
                    team.add(new Crossbowman(random_name(), i, y));
                    break;
                case 3:
                    team.add(new Mag(random_name(), i, y));
                    break;
                case 4:
                    team.add(new Peasant(random_name(), i, y));
                    break;
                case 5:
                    team.add(new Robber(random_name(), i, y));
                    break;
                case 6:
                    team.add(new Monk(random_name(), i, y));
                    break;
                case 7:
                    team.add(new Pikeman(random_name(), i, y));
                    break;
            }
        }

    }
}

