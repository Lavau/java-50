package algorithm.problem.anser;

import org.junit.Test;

/**
 * description
 *
 * @author Leet
 * @date 2020-12-01 12:29
 **/
public class PartOne {
    @Test
    public void testAns2() {
        int m = 100;
        int n = 200;
        int count = 0;
        //统计素数个数
        for (int i = m; i < n; i++) {
            if (isPrime(i)) {
                count++;
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println("在" + m + "和" + n + "之间共有" + count + "个素数");
    }

    //判断素数
    private static boolean isPrime(int n) {
        boolean flag = true;
        if (n == 1)
            flag = false;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if ((n % i) == 0 || n == 1) {
                    flag = false;
                    break;
                } else
                    flag = true;
            }
        }
        return flag;
    }

    @Test
    public void testAns3() {
        for (int i = 100; i < 1000; i++) {
            if (isLotus(i))
                System.out.print(i + " ");
        }
    }

    //判断水仙花数
    private static boolean isLotus(int lotus) {
        int m = 0;
        int n = lotus;
        int sum = 0;
        m = n / 100;
        n -= m * 100;
        sum = m * m * m;
        m = n / 10;
        n -= m * 10;
        sum += m * m * m + n * n * n;
        if (sum == lotus) return true;
        else {
            return false;
        }
    }

}
