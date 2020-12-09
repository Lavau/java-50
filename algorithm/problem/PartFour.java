package algorithm.problem;

import org.junit.Test;

import java.util.*;

/**
 * description 第四部分
 *
 * @author Leet
 * @date 2020-12-06 19:05
 **/
public class PartFour {
    /**
     * 31.将一个数组逆序输出
     */
    @Test
    public void testThirtyOne() {
        int bound = 50;
        Random random = new Random();

        List<Integer> integerList = new ArrayList<>(Arrays.asList(random.nextInt(bound), random.nextInt(bound),
                random.nextInt(bound), random.nextInt(bound), random.nextInt(bound), random.nextInt(bound),
                random.nextInt(bound), random.nextInt(bound), random.nextInt(bound), random.nextInt(bound)));
        integerList.forEach(item -> System.out.printf("%d ", item));
        Collections.reverse(integerList);
        System.out.println();
        integerList.forEach(item -> System.out.printf("%d ", item));
    }

    /**
     * 33.打印出杨辉三角形（要求打印出10行如下)
     */
    @Test
    public void testThirtyThree() {
        int[][] ints = new int[10][];
        ints[0] = new int[]{1};
        ints[1] = new int[]{1, 1};
        for (int i = 2; i < 10; i++) {
            int[] nums = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    nums[j] = 1;
                } else {
                    nums[j] = ints[i - 1][j - 1] + ints[i - 1][j];
                }
            }
            ints[i] = nums;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }

    /**
     * 35.选择排序
     * 巧计：内外两循环，最大标记最大值
     */
    @Test
    public void testThirtyFive() {
        int bound = 50;
        Random random = new Random();
        int[] nums = {random.nextInt(bound), random.nextInt(bound), random.nextInt(bound), random.nextInt(bound),
                random.nextInt(bound), random.nextInt(bound), random.nextInt(bound), random.nextInt(bound),
                random.nextInt(bound), random.nextInt(bound)};
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < 10; i++) {
            int maxI = 0;
            int max = nums[maxI];
            for (int j = 1; j < 10 - i; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    maxI = j;
                }
            }
            nums[maxI] = nums[10 - i - 1];
            nums[10 - i - 1] = max;
        }
        System.out.print(Arrays.toString(nums));
    }

    /**
     * 36.交换位置
     *    有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
     */
    @Test
    public void testThirtySix() {
    }
}
