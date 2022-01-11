package utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.google.gson.*;
import dtos.AnimalDTO;
import dtos.ZooDTO;
import entities.Animal;
import entities.Zoo;

public class Utility {

    public static void printAllProperties() {
        Properties prop = System.getProperties();
        Set<Object> keySet = prop.keySet();
        for (Object obj : keySet) {
            System.out.println("System Property: {"
                    + obj.toString() + ","
                    + System.getProperty(obj.toString()) + "}");
        }
    }




    public static void main(String[] args) throws UnsupportedEncodingException {
    }

    public static List convertList(Class<?> type, List list) {
        List l = new ArrayList();
        for (Object p : list) {
            if (type == Animal.class) l.add(new Animal((AnimalDTO) p));
            if (type == AnimalDTO.class) l.add(new AnimalDTO((Animal) p));
            if (type == ZooDTO.class) l.add(new ZooDTO((Zoo) p));
        }
        return l;
    }

}
