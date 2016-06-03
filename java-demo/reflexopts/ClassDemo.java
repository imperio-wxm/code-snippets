package reflexopts;

/**
 * Created by wxmimperio on 2016/6/3.
 */

public class ClassDemo {
    public static void main(String[] args) {
        //正常Foo的实例化
        Foo foo = new Foo();

        //任何一个类都是class的实例对象，这个实例对象有三种表示方式

        /**
         * 第一种表示方式
         * 实际告诉我们，任何一个类都有一个隐含的静态成员变量
         */
        Class class1 = Foo.class;

        /**
         * 第二种表示方式
         * 已知该类的对象，通过getClass方法
         */
        Class class2 = foo.getClass();

        /**
         * class1、class2表示了Foo类的类类型（class type）
         * 类也是对象，是Class类的实例对象
         * 一个类，只可能是Class的一个对象，所以class1 == class2 返回true
         */
        System.out.println(class1 == class2);


        /**
         * 第三种表达方式
         * 直接通过class的name
         */

        Class class3 = null;

        try {
            class3 = Class.forName("reflexopts.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(class2 == class3);

        /**
         * 可以根据类的类类型来创建改类的对象
         * 即通过class1、class2、class3来创建Foo的实例对象
         * 前提是需要有无参数的构造方法
         */
        try {
            Foo foo1 = (Foo) class1.newInstance();
            Foo foo2 = (Foo) class2.newInstance();
            Foo foo3 = (Foo) class3.newInstance();

            foo1.printDemo();
            foo2.printDemo();
            foo3.printDemo();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


class Foo {
    Foo() {

    }

    public void printDemo() {
        System.out.println("This is Foo!");
    }
}