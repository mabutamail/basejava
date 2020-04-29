package ru.javawebinar.basejava.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume r = new Resume();
        Field field =  r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
//        System.out.println("field.getName() " + field.getName());
//        System.out.println("field.get(r) " + field.get(r));
//        field.set(r, "123");
//        System.out.println("field.get(r).toString() " + field.get(r).toString());
//        System.out.println(r);

        Method method = r.getClass().getDeclaredMethod("toString");
        System.out.println("method " + method);
        //method.setAccessible(true);
        System.out.println("-------------");
        field.set(r, "33333");
        System.out.println("method.invoke(r) " + method.invoke(r));
    }
}
