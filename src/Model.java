import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
//    public static void chekName(String name){
//        if (name){
//            throw new RuntimeException();
//        }
//    }
    public static void chekPhone(String phone){
        char[] ch = phone.toCharArray();
        if (Character.isDigit(Integer.parseInt(String.valueOf(ch[0])))) throw new NumberFormatException();
    }
    public static void chekSex(String sex){
        if (!sex.equals("f") && !sex.equals("m")){
            throw new RuntimeException();
        }
    }
    public static int chek(String[] data){
        if (data.length != 6) return 0;
        return 1;
    }
    public static void writeFile(Contact contact, FileWriter fw) throws IOException {
        fw.write(contact.toString() + "\n");
    }
}
