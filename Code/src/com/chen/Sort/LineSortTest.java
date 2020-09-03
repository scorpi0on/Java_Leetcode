package com.chen.Sort;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.Random;
@DisplayName("线性排序算法测试")
public class LineSortTest {

    private static int length = 100;

    private int[] array = new int[length];

    @BeforeEach
    public int[] beforeEach() {
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            // 随机生成 [1, 1000000] 的数据
            array[i] = rand.nextInt(length) + 1;
        }
        return array;

    }

    @DisplayName("桶排序")
    @Test
    public void testBucketSort() {
        // 100 数据，10 个桶
        LineSortTest lineSortTest = new LineSortTest();
        array = lineSortTest.beforeEach();
        Bucket_Sort.bucket_sort(array, 10);
        System.out.println(Arrays.toString(array));
    }

}
