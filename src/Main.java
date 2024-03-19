import java.io.*;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол через пробел");
        String s = scanner.nextLine();
        String[] mass = s.split(" ");
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
        try {
            if (Model.chek(mass) == 0) {
                System.out.println("Данные введены некорректно");
            }
            Model.chekPhone(mass[4]);
            Contact contact = new Contact(mass[0] + " " + mass[1] + " " + mass[2], mass[3], mass[4], mass[5]);
            FileWriter fl = new FileWriter(mass[0] + ".txt", true);
            try {
                Model.writeFile(contact, fl);
                fl.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (NumberFormatException e){
            System.out.println("Номер телефона указан не корректно");
        }
    }
}