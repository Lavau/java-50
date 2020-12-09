package algorithm.problem;

import org.junit.Test;

import java.util.*;

/**
 * description 第三部分
 *      包括：21，22，23，24，25，27，28，30
 *
 * @author Leet
 * @date 2020-12-04 20:32
 **/
public class PartThree {
    /**
     * 21.求1+2!+3!+...+20!的和
     */
    @Test
    public void testTwentyOne() {
        long sum = 0;
        int num = 1;
        for (int i = 1; i < 21; i++) {
            num *= i;
            sum += num;
        }
        System.out.println(sum);
    }

    /**
     * 22.利用递归方法求5!
     */
    @Test
    public void testTwentyTwo() {
        System.out.println(func(5));
    }

    private int func(int i) {
        if (i == 0) {
            return 1;
        }

        return func(i - 1) * i;
    }

    /**
     * 23.递归计算
     *    有5个人坐在一起，问第五个人多少岁.他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。
     *    问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。
     *    请问第五个人多大
     */
    @Test
    public void testTwentyThree() {
        System.out.println(func2(5));
    }

    private int func2(int i) {
        if (i == 1) {
            return 10;
        }

        return func2(i - 1) + 2;
    }

    /**
     * 24.倒序打印
     *    给一个不多于5位的正整数，
     *    要求: 一、求它是几位数，
     *         二、逆序打印出各位数字
     */
    @Test
    public void testTwentyFour() {
        int num = new Random().nextInt(100000);
        String numStr = String.valueOf(num);
        System.out.printf("%d 是 %d 位数\n", num, numStr.length());
        for (int i = numStr.length() - 1; i >= 0 ; i--) {
            System.out.print(numStr.charAt(i));
        }
    }

    /**
     * 25.回文数
     *    一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
     */
    @Test
    public void testTwentyFive() {
        int num = new Random().nextInt(100000);
        String numStr = String.valueOf(num);
        System.out.println(num);
        System.out.println(numStr.charAt(0) == numStr.charAt(4) && numStr.charAt(1) == numStr.charAt(3));
    }

    /**
     * 27.求100以内的素数
     */
    @Test
    public void testTwentySeven() {
        for (int i = 2; i < 100; i++) {
            // i 整除数的个数
            int number = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    number ++;
                }
            }
            if (number == 0) {
                System.out.printf("%d ", i);
            }
        }
    }

    /**
     * 28.对 10 个数排序
     */
    @Test
    public void testTwentyEight() {
        int seed = 50;
        Random random = new Random();
        int[] nums = {random.nextInt(seed), random.nextInt(seed), random.nextInt(seed), random.nextInt(seed),
                random.nextInt(seed), random.nextInt(seed), random.nextInt(seed), random.nextInt(seed),
                random.nextInt(seed), random.nextInt(seed),};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 30.比较排序
     */
    @Test
    public void test() {
        int seed = 50;
        Random random = new Random();
        int[] nums = {random.nextInt(seed), random.nextInt(seed), random.nextInt(seed), random.nextInt(seed),
                random.nextInt(seed), random.nextInt(seed), random.nextInt(seed), random.nextInt(seed),
                random.nextInt(seed), random.nextInt(seed),};
        System.out.println(Arrays.toString(nums));

        int t;
        for (int i = 1, j; i < nums.length; i++) {
            t = nums[i];
            for (j =  i - 1; j >= 0; j--) {
                if (nums[j] > t) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            if (j + 1 != i) {
                nums[j + 1] = t;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
