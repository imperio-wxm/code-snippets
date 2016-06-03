package reflexopts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wxmimperio on 2016/6/3.
 */
public class Methodreflex {
    public static void main(String[] args) {
        //要获取print(int, int)方法

        /**
         * 1. 获取类的类类型，再获取类的信息
         * 2. 获取方法名称和参数列表
         *      getMethod获取的是public方法
         *      getDeclaredMethod获取所有自己声明的方法
         *
         */
        A a1 = new A();
        Class aClass = a1.getClass();

        try {
            Method m = aClass.getDeclaredMethod("print", new Class[]{int.class, int.class});
            //或者
            //Method m = aClass.getDeclaredMethod("print", int.class, int.class);

            //方法的反射操作是利用获得的 m 对象进行方法调用
            m.invoke(a1, new Object[]{10, 20});

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}
