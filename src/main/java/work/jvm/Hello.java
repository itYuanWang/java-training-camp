package work.jvm;
/**
 * 题目：
 * 自己写一个简单的 Hello.java，
 * 里面需要涉及基本类型，四则运行，if 和 for，
 * 然后自己分析一下对应的字节码，有问题群里讨论。
 */

/**
 * @Author: wangyuanyuan32
 * @Date: 2022/1/6 21:10
 */
public class Hello {


    public static void main(String[] arg) throws Exception {

        int[] arr = {1,2,3,4,5};
        int add = 0;
        int reduce = 100;
        int mul = 1;
        int division = 100;

        for (int i = 0; i < arr.length; i ++) {
            add += arr[i];
        }
        System.out.println("add = " + add);

        for (int i = arr.length - 1; i >= 0; i --) {
            reduce -= arr[i];
        }
        System.out.println("reduce = " + reduce);

        for (int i = arr.length - 1; i >= 0; i --) {
            mul *= arr[i];
        }
        System.out.println("mul = " + mul);

        for (int i = arr.length - 1; i >= 0; i --) {
            if ( arr[i] != 0) {
                division /= arr[i];
            }
        }
        System.out.println("division = " + division);
    }
}
