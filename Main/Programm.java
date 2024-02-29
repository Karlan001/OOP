package Main;

import Person.*;
import Service.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Programm {
    public static ArrayList<Heroes> holyTeam = new ArrayList<>();
    public static ArrayList<Heroes> darkTeam = new ArrayList<>();
    public static ArrayList<Heroes> allTeam = new ArrayList<>();
    public static void main(String[] args) {

        fill_team(holyTeam, 10);
        fill_team(darkTeam, 1);
        System.out.println(holyTeam.toString());
        System.out.println(darkTeam.toString());
        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        Scanner scanner = new Scanner(System.in);
        allTeam.sort(new Comparator<Heroes>() {
            @Override
            public int compare(Heroes o1, Heroes o2) {
                return o2.getInitiative() - o1.getInitiative();
            }
        });
        while (true){
            View.view();
            scanner.nextLine();
            int holyTeamHp = 0;
            int darkTeamHp = 0;
            for (Heroes hero : allTeam){
                if(holyTeam.contains(hero)){
                    hero.Step(darkTeam, holyTeam);
                    holyTeamHp += hero.getHp();
                }
                else{
                    hero.Step(holyTeam, darkTeam);
                    darkTeamHp += hero.getHp();
                }
            }
            if (holyTeamHp == 0){
                System.out.println("Победила команда Green Team");
                break;
            }
            if (darkTeamHp == 0){
                System.out.println("Победила команда Blue Team");
                break;
            }


        }
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
        for (int i = 1; i < 11; i++) {
            int num = random.nextInt(1, 8);
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

