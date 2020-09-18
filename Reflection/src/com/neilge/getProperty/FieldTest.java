package com.neilge.getProperty;

import com.neilge.property.Person;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Neo
 * @since 09/17/2020-11:36 PM
 */
public class FieldTest {

    @Test
    public void test1() {
        Class clazz = Person.class;
        // getFields(): 获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f:fields) {
            System.out.println(f);
        }

        System.out.println();

        // getDeclaredFields():获取当前运行时类当中声明的所有属性. (不包含父类中的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields) {
            System.out.println(f);
        }
    }

    // 权限修饰符 数据类型 变量名
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields) {
            // 1. 权限修饰符
            String modifier = Modifier.toString(f.getModifiers());
            System.out.print(modifier + "\t");
            // 2. 数据类型
            Class type = f.getType();
            System.out.print(type.getName() +"\t");
            // 3. 变量名
            String fieldName = f.getName();
            System.out.println(fieldName);
        }
    }
}
