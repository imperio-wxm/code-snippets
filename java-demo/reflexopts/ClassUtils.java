package reflexopts;

import org.omg.CORBA.*;

import java.lang.Object;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wxmimperio on 2016/6/3.
 * <p/>
 * 获取类基本信息的封装
 */
public class ClassUtils {
    /**
     * 打印类的基本信息，包括成员变量、成员函数
     *
     * @param object
     */

    //获取类方法的信息
    public static void printMethodClassInfo(Object object) {
        //要获取类的基本信息，首先要获取类的类类型
        //传递的是哪个子类的对象，获取的就是该子类的类类型
        Class objClass = object.getClass();

        //获取类的名称
        System.out.println("类的名称是：" + objClass.getName());

        System.out.println("--------------------------------------------");

        /**
         * 获取类的方法，返回一个方法的列表
         * Method 类是方法的对象
         * 一个成员方法就是Method对象
         * getMethods方法获取的是所有的 public 函数，包括父类继承的
         * getDeclaredMethods方法获取的是，所有该类自己声明的方法，不包括父类继承的，没有访问权限限制
         */
        Method[] ms = objClass.getMethods();
        for (Method method : ms) {
            //得到方法的返回值类型的类类型
            Class returnType = method.getReturnType();
            System.out.println("返回值的类类型： " + returnType + " " + "返回值的类型名称：" + returnType.getName());

            //打印方法名
            System.out.println("返回方法的名称：" + method.getName());

            //得到参数列表的类类型
            Class[] paramsType = method.getParameterTypes();
            for (Class paramsClass : paramsType) {
                System.out.println("参数列表的类类型：" + paramsClass + " " + "参数列表的类型名称：" + paramsClass.getName());
            }

            System.out.println("--------------------------------------------");
        }
    }

    //获取类成员变量的信息
    public static void printClassParamsInfo(Object object) {
        //要获取类的基本信息，首先要获取类的类类型
        //传递的是哪个子类的对象，获取的就是该子类的类类型
        Class objClass = object.getClass();
        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field封装了关于成员变量的操作
         * getFields获取的是所有public的成员变量
         * getDeclaredFields获取所有自己声明的成员变量
         */
        //Field[] fs = objClass.getFields();
        Field[] fs = objClass.getDeclaredFields();

        for (Field field : fs) {
            //获取成员变量类型的类类型和类型的名称
            Class fieldType = field.getType();
            System.out.println("成员变量类型的类类型：" + fieldType + " " + "成员变量类型的名称：" + fieldType.getName());

            //得到成员变量的名字
            System.out.println("成员变量的名字：" + field.getName());

            System.out.println("--------------------------------------------");
        }
    }

    /**
     * 打印对象构造函数的信息
     *
     * @param object
     */
    public static void printClassConInfo(Object object) {
        //要获取类的基本信息，首先要获取类的类类型
        //传递的是哪个子类的对象，获取的就是该子类的类类型
        Class objClass = object.getClass();

        /**
         * 构造函数也是对象
         * java.lang.Constructor封装了构造函数的信息
         * getConstructors获得所public的构造方法
         * getDeclaredConstructors得到所有构造方法
         */
        //Constructor[] cs = objClass.getConstructors();
        Constructor[] cs = objClass.getDeclaredConstructors();

        for (Constructor constructor : cs) {
            //获取构造函数的名称
            System.out.println("构造函数的名称：" + constructor.getName());

            //获取构造函数的参数列表的类类型和参数类型的名称
            Class[] paramsTypes = constructor.getParameterTypes();

            for (Class param : paramsTypes) {
                //获取参数的名称
                System.out.println("构造函数参数的名称：" + param.getName());
            }
            System.out.println("--------------------------------------------");
        }
    }
}
