import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Quiz {
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        al.add("A");
        al.add("B");
        al.add("C");
        al.add(1,"Z");
        al.add(4,"V");
        System.out.println(al);
    }
}
