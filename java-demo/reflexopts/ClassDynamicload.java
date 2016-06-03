package reflexopts;

/**
 * Created by wxmimperio on 2016/6/3.
 */
public class ClassDynamicload {
    public static void main(String[] args) {

        /**
         * 动态加载类，编译时不会发生任何问题，在运行时才会加载
         */
        try {
            Class class1 = Class.forName("reflexopts.Dynamic1");
            Class class2 = Class.forName("reflexopts.Dynamic2");

            try {
                Able ableDyn1 = (Able) class1.newInstance();
                Able ableDyn2 = (Able) class2.newInstance();

                ableDyn1.start();
                ableDyn2.start();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //通过类类型创建对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//制定通用标准接口
interface Able {
    public void start();
}

class Dynamic1 implements Able {

    @Override
    public void start() {
        System.out.println("This is Dynamic1!");
    }
}

class Dynamic2 implements Able {

    @Override
    public void start() {
        System.out.println("This is Dynamic2!");
    }
}
