import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Model {
    public static void chekName(String[] name) throws NumberFormatException {
        for (int i = 0; i < 3; i++) {
            String chek = name[i];
            boolean flag = false;
            for (int j = 0; j < chek.length() && !flag; j++) {
                if (Character.isDigit(chek.charAt(j))) {
                    flag = true;
                }
            }
            if (flag) throw new NumberFormatException("ФИО указано некорректно");
        }
    }

    public static void chekPhone(String phone) {
        for (int j = 0; j < phone.length(); j++) {
            if (!Character.isDigit(phone.charAt(j))) {
                throw new NumberFormatException("Не верно указан номер телефона");
            }
        }
    }


    public static void chekSex(String sex) throws IllegalArgumentException {
            if (!sex.equals("f") && !sex.equals("m")) {
                throw new IllegalArgumentException("Введите пол: m или f");
            }
        }

    public static int chek(String[] info) throws ArrayIndexOutOfBoundsException {
        if (info.length != 6) return 0;
        return 1;
    }

    public static void chekData(String date) throws DataFormatException {
        if (!date.matches("(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)"))
            throw new DataFormatException("Введенная дата не соответствует формату: ДД.ММ.ГГГГ");
        ;
    }

    public static void writeFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол через пробел");
        String s = scanner.nextLine();
        String[] mass = s.split(" ");
        try {
            if (chek(mass) == 0) throw new ArrayIndexOutOfBoundsException();
            chekName(mass);
            chekData(mass[3]);
            chekPhone(mass[4]);
            chekSex(mass[5].toLowerCase());
            Contact contact = new Contact(mass[0] + " " + mass[1] + " " + mass[2], mass[3], mass[4], mass[5]);
            FileWriter fl = new FileWriter(mass[0] + ".txt", true);

            try {
                fl.write(contact.toString() + "\n");
                fl.close();
                System.out.println("Контакт добавлен");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (NumberFormatException | DataFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Данные введены не полностью. Указано больше или меньше данных чем требуется.\nКод ошибки: " + Model.chek(mass));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Хотите снова добавить контакт?\nда, нет");
            String repeat = scanner.nextLine();
            if (repeat.equalsIgnoreCase("да")) {
                writeFile();
            }
        }
    }
}
