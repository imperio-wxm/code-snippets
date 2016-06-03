package reflexopts;

/**
 * Created by wxmimperio on 2016/6/3.
 * 基本数据类型的类类型
 * 拿到类的基本信息
 */
public class ClassBasicdata {
    public static void main(String[] args) {

        //int的类类型
        Class intClass = int.class;
        //String的类类型
        Class strClass = String.class;
        //double的类类型
        Class doubleClass = double.class;
        //void关键字的类类型
        Class voidClass = void.class;

        //打印类的全称
        System.out.println(intClass.getName());
        System.out.println(strClass.getName());

        String str = "测试Class获取基本信息";
        ClassUtils.printClassInfo(str);
    }
}
