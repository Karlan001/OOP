import java.util.ArrayList;
import java.util.Random;
import java.util.SortedMap;

public class Programm {
    public static void main(String[] args) {
        ArrayList<Heroes> team1 = new ArrayList<>();
        ArrayList<Heroes> team2 = new ArrayList<>();

        System.out.println(random_name());
    }
    static String random_name(){
        String[] arr = new String[]{"Oleg", "Ivan", "Stas", "Anna", "Olga", "Timofey", "Miron", "Angelina"};
        Random random = new Random();
        return arr[random.nextInt(0, arr.length)];
    }
    static void fill_team(){
        Random random = new Random();
        for (int i = 0; i < 7; i++) {

        }
    }

}
