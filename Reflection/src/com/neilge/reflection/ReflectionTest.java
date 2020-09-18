package com.neilge.reflection;

import com.neilge.reflection.Person;
import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @author Neo
 * @since 09/16/2020-11:27 PM
 */
public class ReflectionTest {

    /*
    关于java.lang.Class类的理解
    1. 类的加载过程
    程序经过javac.exe命令后, 会生成一个或多个字节码文件(.class结尾). 接着我们使用java.exe命令对某个字节码文件进行解释运行. 相当于讲某个字节
    码文件加载到内润中, 此过程就称为类的加载. 加载到内存中的类, 我们就成为运行时类, 此运行时类, 就作为Class的一个实例.
    2. 换句话说, Class的实例就对应着一个运行时类.
    3. 加载到内存中的运行时类, 会缓存一定时间. 在此时间内, 我们可以通过不同的方式来获取此运行时类.
     */

    // 获取Class的实例的方式
    @Test
    public void getClassInstance() throws ClassNotFoundException {
        // Method 1: 调用运行时类的属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        // Method 2: 通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // Method 3: 调用class的静态方法:forName(String classPath)
        Class clazz3 = Class.forName("com.neilge.reflection.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        // Method 4: ClassLoader 类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.neilge.reflection.Person");
        System.out.println(clazz1 == clazz4);
    }
}
