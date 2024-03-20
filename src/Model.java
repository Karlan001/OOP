import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Model {
    //    public static void chekName(String name){
//        if (name){
//            throw new RuntimeException();
//        }
//    }
    public static void chekPhone(String phone) {
        char[] ch = phone.toCharArray();
        System.out.println(Arrays.toString(ch));
        for (char elem : ch) {
            if (Character.isDigit(Integer.parseInt(String.valueOf(elem)))) throw new NumberFormatException();
        }
    }

    public static void chekSex(String sex) throws RuntimeException {
        try {
            if (!sex.equals("f") && !sex.equals("m")) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println(sex + " Такого пола нет");
            try {
                writeFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static int chek(String[] data) throws ArrayIndexOutOfBoundsException {
        if (data.length != 6) return 0;
        return 1;
    }

    public static void writeFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол через пробел");
        String s = scanner.nextLine();
        String[] mass = s.split(" ");
        System.out.println(mass.length);
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
        try {
            if (chek(mass) == 0) throw new ArrayIndexOutOfBoundsException();
            Model.chekPhone(mass[4]);
            Model.chekSex(mass[5].toLowerCase());
            Contact contact = new Contact(mass[0] + " " + mass[1] + " " + mass[2], mass[3], mass[4], mass[5]);
            FileWriter fl = new FileWriter(mass[0] + ".txt", true);

            try {
                fl.write(contact.toString() + "\n");
                fl.close();
                System.out.println("Контакт добавлен");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (NumberFormatException e) {
            System.out.println("Номер телефона указан не корректно");
            writeFile();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Данные введены не полностью. Указано больше или меньше данных чем требуется.\nКод ошибки: " + Model.chek(mass));
            writeFile();
        }
    }
}
