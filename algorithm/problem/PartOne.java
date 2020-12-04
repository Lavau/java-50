package algorithm.problem;

import org.junit.Test;

import java.util.*;

/**
 * description 第一部分
 *      包含：2、3、4、5、6、7、8、9、10
 *
 * @author Leet
 * @date 2020-11-29 17:59
 **/
public class PartOne {
    /**
     * ⒉指定范围包含的素数
     *   判断101-200之间有多少个素数，并输出所有素数。
     */
    @Test
    public void testTwo() {
        List<Integer> list = new ArrayList<>(20);
        for (int i = 100; i < 200; i++) {
            int n = 0;
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    n ++;
                }
            }
            if (n == 0) {
                list.add(i);
            }
        }
        System.out.println("共 " + list.size() + " 个");
        list.forEach(System.out::println);
    }

    /**
     * 第3题
     */
    @Test
    public void testThree() {
        for (int i = 100; i < 1000; i++) {
            int a = i % 10;  // 个位
            int b = i / 10 % 10;  // 十位
            int c = i / 100;  // 百位
            if (i == (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3))) {
                System.out.println(i);
            }
        }
    }

    /**
     * 4.分解质因数
     *   将一个正整数分解质因数。例如:输入90,打印出90=2*3*3*5。
     */
    @Test
    // 采用分治法
    // 整数先用它的最小质因子分解后，从头循环，直至等于它等于1
    public void testFourMethodTwo() {
        int num = 25;
        while (num != 1) {
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                    i = 2;
                    break;
                }
            }
        }
    }

    @Test
    public void testFour() {
//        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个整数：");
//        int num = in.nextInt();
        int num = 90;
        List<Integer> primeList = getPrimeList(num); // num 以内的所有质数
        List<Integer> factorList = new ArrayList<>(10); // num 的质数因子
        int i = 0;
        // 外层循环所有质数
        for (int prime : primeList) {
            // 内层循环判断质数是否是 num 的因子
            while (num != 0) {
                if (num % prime == 0) {
                    factorList.add(prime);
                } else {
                    break;
                }
                num /= prime;
            }
        }
        System.out.println(Arrays.toString(factorList.toArray(new Integer[0])).replace(",", " *"));
    }

    private List<Integer> getPrimeList(int num) {
        List<Integer> list = new ArrayList<>(num / 2);
        list.add(2);

        // 外层循环：i 若是质数就添加到 list
        for (int i = 3; i <= num / 2; i++) {
            int n = 0;
            // 内层循环判断 i 是否是质数
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    n ++;
                }
            }
            if (n == 0) {
                list.add(i);
            }
        }

        if (list.size() == 1) {
            list.add(num);
        }

        return list;
    }

    /**
     * 5.条件运算符使用
     *   利用条件运算符的嵌套来完成此题:学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
     */
    @Test
    public void testFive() {
        int score = (int)(Math.random() * 100);
        System.out.println(score);
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 60 && score <= 89) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
    }

    /**
     * 6.公约数和公倍数
     *   输入两个正整数m和n，求其最大公约数和最小公倍数。
     *   辗转相除法求两个正整数的最大公约数
     */
    @Test
    public void testSix() {
        // num1 必须大于 num2
        int num1 = 56;
        int num2 = 24;
        int n1C = num1;
        int n2C = num2;

        // 辗转相除法求两个正整数的最大公约数
        int reminder = num1 % num2;
        num1 = num2;
        num2 = reminder;
        while (reminder != 0) {
            reminder = num1 % num2;
            num1 = num2;
            num2 = reminder;
        }

        System.out.println("最大公约数为：" + num1);
        System.out.println("最小公倍数为：" + n1C * n2C / num1);
    }

    /**
     * 7.统计字符串中类型个数
     *   输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     */
    @Test
    public void testSeven() {
        // 输入的字符串
        String str = "reg = /\\d+(\\s+)\\d+/;";
        int numCharacter = 0;
        int numSpace = 0;
        int numDigits = 0;
        int numOthers = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                numCharacter ++;
            } else if (c == ' ') {
                numSpace ++;
            } else if (Character.isDigit(c)) {
                numDigits ++;
            } else {
                numOthers ++;
            }
        }
        System.out.printf("character: %d, space: %d, digits: %d, others: %d", numCharacter, numSpace, numDigits, numOthers);
    }

    /**
     * 8.求s=a+aa+aaa+aaaa+aa...a的值
     *   求s=a+aa+aaa+aaaa +aa...a的值，其中a是一个数字。例如
     *   2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
     */
    @Test
    public void testEight() {
        int a = 1; // a 的值
        int n = 9; // n 个数相加
        long sum = 0;

        long max = a; // 这 n 相加的数中的最大值
        for (int i = 0; i < n - 1; i++) {
            max = max * 10 + a;
        }

        for (int i = 0; i < n; i++) {
            sum += max;
            max /= 10;
        }

        System.out.println(sum);
    }

    /**
     * 9.指定范围的完数
     * 一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1+2+3.编程找出1000以内的所有完数。
     */
    @Test
    public void testNine() {
        List<Integer> list;
        for (int i = 1; i < 1001; i++) {
            list = getFactorList(i);
            int sum = list.stream().mapToInt(item -> item).sum();
            if (i == sum) {
                System.out.println(i);
            }
        }
    }

    private List<Integer> getFactorList(int num) {
        List<Integer> list = new ArrayList<>(num / 2);
        list.add(1);
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 10.反指数计算
     *    一球从100米高度自由落下，每次落地后反跳回原高度的一半;再落下,求它在第10次落地时，共经过多少米?第10次反弹多高?
     */
    @Test
    public void testTen() {
        double height = 100;
        double sum = height;

        // 循环第 i 次落地
        for (int i = 2; i < 11; i++) {
            sum += height;
            height /= 2;
        }

        System.out.printf("一共经过: %.2f\n", sum);
        System.out.printf("第 10 落地反弹: %.2f", height * 2);
    }
}
