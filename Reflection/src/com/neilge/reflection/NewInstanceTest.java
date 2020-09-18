package com.neilge.reflection;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * 通过反射创建对应的运行时类对象
 *
 * @author Neo
 * @since 09/17/2020-9:37 PM
 *
 */
public class NewInstanceTest {

    @Test
    public void test1() throws Exception {

        Class clazz = Person.class;

        /*
        newInstance, 调用此方法, 创建对应的运行时类的对象.

        要想此方法正常创建运行时类的对象, 要求:
        1. 运行时类必须提供空参构造器
        2. 空参构造器的访问权限得足够. 通常设置为public

        在javabean中要求提供一个public的空参构造器. 原因:
        1. 便于通过反射, 创建运行时类的对象.
        2. 便于子类继承此运行时类, 默认调用super()时, 保证父类有此构造器.
         */
        Object obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj);

        Class<Person> clazz1 = Person.class;

        Person ob1j = clazz1.getDeclaredConstructor().newInstance();
        System.out.println(obj);
    }

    // 体会反射的动态性
    @Test
    public void test2() throws Exception {
        for (int i = 0; i < 100; i++) {
            String classPath = getClassPath();
            Object obj = getInstance(classPath);
            System.out.println(obj);
        }
    }

    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.getDeclaredConstructor().newInstance();
    }

    public String getClassPath() {
        int num = new Random().nextInt(3); // 0,1,2
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.neilge.reflection.Person";
                break;
        }
        return classPath;
    }
}
