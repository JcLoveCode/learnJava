package fanshe;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class TypeCheck {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("俊川");
        strings.add("aaa");
        Class aClass = strings.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(strings,123);
        for (Object string : strings) {
            System.out.println(string);
        }
    }


}
