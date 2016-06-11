package arraysdemo;

/**
 * Created by wxmimperio on 2016/6/11.
 *
 * 可以把类型相同但个数可变的参数传递给方法
 * typenName... paramterName
 * 只能给方法中指定个一个可变参数，而且这个参数必须是最后一个
 * java将可变参数当做数组处理
 */
public class VarArgsDemo {
    public static void main(String[] args) {
        printMax(12.3, 5, 659.1, 100.2);
        printMax(new double[]{1, 2, 3, 4, 5});
    }

    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("no args!");
            return;
        }
        double reslut = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (reslut < numbers[i]) {
                reslut = numbers[i];
            }
        }
        System.out.println("Max：" + reslut);
    }
}
