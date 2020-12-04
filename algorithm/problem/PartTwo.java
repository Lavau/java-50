package algorithm.problem;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * description 第二部分
 *          包含：11, 12, 14, 15, 16, 17, 18, 20
 *
 * @author Leet
 * @date 2020-12-04 12:17
 **/
public class PartTwo {
    /**
     * 11.组合
     *    有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数?都是多少
     */
    @Test
    public void testEleven() {
        Deque<Integer> numStack = new ArrayDeque<>(4);
        List<Boolean> isUsedList = new ArrayList<>(Arrays.asList(false, false, false, false));
        for (int i = 0; i < 4; i++) {
            numStack.addLast(i + 1);
            isUsedList.set(i, true);
            dfs(isUsedList, numStack);
            numStack.removeLast();
            isUsedList.set(i, false);
        }
    }

    private void dfs(List<Boolean> isUsedList, Deque<Integer> numStack) {
        if (numStack.size() == 3) {
            numStack.forEach(System.out::print);
            System.out.println();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (isUsedList.get(i)) {
            } else {
                numStack.addLast(i + 1);
                isUsedList.set(i, true);
                dfs(isUsedList, numStack);
                numStack.removeLast();
                isUsedList.set(i, false);
            }
        }
    }

    /**
     * 12梯度计算
     *   企业发放的奖金根据利润提成。利润I)低于或等于10万元时，奖金可提10%;利润高于10万元，低于20万元时，低于10万元的部分按10%提成，
     *   高于10万元的部分，可可提成7.5%; 20万到40万之间时，高于20万元的部分，可提成5%;40万到60万之间时高于40万元的部分，可提成3%
     */
    @Test
    public void testTwelve() {
        // 假设利润为正整数，单位万元
        int profit = 52;
        if (profit <= 10) {
            System.out.println(profit * 0.1);
        } else if (profit <= 20) {
            System.out.println(1 + (profit - 10) * 0.075);
        } else if (profit <= 40) {
            System.out.println(1.75 + (profit - 20) * 0.05);
        } else if (profit <= 60) {
            System.out.println(2.75 + (profit - 40) * 0.03);
        }
    }

    /**
     * 14.日期计算
     *    输入某年某月某日，判断这—天是这—年的第几天
     */
    @Test
    public void testFourteen() throws ParseException {
        // 输入的 XXXX-XX-XX 样式的日期
        String dateString = "2020-05-23";
        // 根据输入的日期计算出第一天的日期
        String firstDateStringOfThisYear = dateString.substring(0, 4).concat("-01-00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long milliSecond = dateFormat.parse(dateString).getTime() - dateFormat.parse(firstDateStringOfThisYear).getTime();
        System.out.println(milliSecond / 1000 / 60 / 60 / 24);
    }

    /**
     * 15.排序
     *    输入三个整数x,y,z，请把这三个数由小到大输出
     */
    @Test
    public void testFifteen() {
        // 输入的整数
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 5, 0));
        integerList.stream().sorted().forEach(System.out::println);
    }

    /**
     * 16.输出 9 * 9 口诀
     */
    @Test
    public void testSixteen() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%d\t", j, i, i * j);
            }
            System.out.println();
        }
    }

    /**
     * 17.反推计算
     *   猴子吃桃问题:猴子第―天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个，第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     *   以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第—天共摘了多少
     */
    @Test
    public void testSeventeen() {
        // 第n天剩余的桃子数，现在为第10天
        int num = 1;
        for (int i = 9; i > 0; i--) {
            num = (num + 1) * 2;
        }
        System.out.println(num);
    }

    /**
     * 18.数组计算
     *    两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为xy,z三人。已抽签决定比赛名单。
     *    有人向队员打听比赛的名单。a说他不和x比，c说他不和xz比，请编程序找出三队赛手的名单。
     */
    @Test
    public void testEighteen() {
    }

    /**
     * 20.数列求和
     *    有一分数序列:2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
     */
    @Test
    public void test() {
        double sum = 0;
        // 分母
        double denominator = 2;
        // 分子
        double molecule = 1;
        for (int i = 0; i < 20; i++) {
            sum += (denominator / molecule);
            double temp = denominator;
            denominator += molecule;
            molecule = temp;
        }
        System.out.println(sum);
    }
}
