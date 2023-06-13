import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaLearn {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] array = new int[5];
        for(int i=0; i<array.length;i++){
            array[i]=i+1;
            System.out.println(array[i]);

        }
//        System.out.println(array);

        String[] name = {"janice","livia","fred"};
        for(String s:name){
            System.out.println(s);
        }

        ArrayList a = new ArrayList();
        ArrayList<String> stringList = new ArrayList<String>();
        for (int i=0;i<5;i++){
            a.add(i+1);
        }
        int x=2;
        a.remove(x);
        System.out.println(a.get(a.size()-1));

        List<String> newList = Arrays.asList(name);


    }
}
