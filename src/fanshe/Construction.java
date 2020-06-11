package fanshe;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Construction {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName(getValue("className"));
        Method methodName = clazz.getMethod(getValue("methodName"),String.class);
        methodName.invoke(clazz.getConstructor().newInstance(),"付俊川");
    }

    public static String getValue(String valueName) throws Exception {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("pro.text");
        properties.load(fileReader);
        fileReader.close();
        return properties.getProperty(valueName);
    }



}
