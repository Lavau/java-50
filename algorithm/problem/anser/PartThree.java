package algorithm.problem.anser;

import org.junit.Test;

/**
 * description
 *
 * @author Leet
 * @date 2020-12-05 10:36
 **/
public class PartThree {
    @Test
    public void test() {
        long sum = 0;
        for (int i = 0; i < 20; i++)
            sum += factorial(i + 1);
        System.out.println(sum);
    }

    //阶乘
    private static long factorial(int n) {
        int mult = 1;
        for (int i = 1; i < n + 1; i++) mult *= i;
        return mult;
    }

}