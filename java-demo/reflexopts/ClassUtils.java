package reflexopts;

import java.lang.reflect.Method;

/**
 * Created by wxmimperio on 2016/6/3.
 *
 * 获取类基本信息的封装
 */
public class ClassUtils {
    /**
     * 打印类的基本信息，包括成员变量、成员函数
     *
     * @param object
     */
    public static void printClassInfo(Object object) {
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
}
