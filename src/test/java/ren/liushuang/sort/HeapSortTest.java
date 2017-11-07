package ren.liushuang.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试堆排序
 *
 * @author liushuang
 * @create 2017-11-06 PM6:24
 */
public class HeapSortTest {
    @Test
    public void testSort() {
        Random random = new Random();
        int length = random.nextInt(1000);
        List<Integer> data = new ArrayList<Integer>(length);
        //for(int i = 0 ; i<length ;i++){
        //    data.add(i);
        //}
        for (int i = 0; i < length; i++) {
            data.add(random.nextInt());
        }
        HeapSort.sort(data);

        //for(int i = 0 ; i < data.size() ;i++){
        //    System.out.print(data.get(i) + " ");
        //}
        for (int i = 0; i < data.size() - 1; i++) {
            Assert.assertTrue(data.get(i) <= data.get(i + 1));
        }
    }
}
