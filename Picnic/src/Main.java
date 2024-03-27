import javax.naming.ldap.SortKey;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] arr = getText();
        int total = arr.length;
        Map<Integer, String> words = countWord(getText());
        System.out.println("1. Колличество слов в файле = " + total);
        System.out.println("_______");
        System.out.println("2. Самое длинное слово в файле - " + getLength(words));
        System.out.println("_______\n3. ");
        for (Map.Entry<Integer, String> s : words.entrySet()){
            System.out.println("Слово " + s.getValue() + " встречается " + s.getKey() + " раз");
        }

    }

    public static String[] getText() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/ivanandreev/Documents/Java_OOP/Picnic/src/input.txt"));
        String line = reader.readLine();
        String[] array = line.split(" ");
        try {
            while (line != null) {
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
    static public Map<Integer, String> countWord(String[] array){
        int count = 0;
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            String w = array[i];
            for (String s : array){
                if (s.equals(w)){
                    count++;
                }
            }
            map.put(count, w);
            count = 0;
        }
        return map;
    }
    static public String getLength(Map<Integer, String> array) {
        String word = "";
        for (String words : array.values()){
            if (words.length() > word.length()){
                word = words;
            }
        }
        return word;
    }
}