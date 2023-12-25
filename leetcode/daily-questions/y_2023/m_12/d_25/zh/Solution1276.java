package y_2023.m_12.d_25.zh;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/number-of-burgers-with-no-waste-of-ingredients/?envType=daily-question&envId=2023-12-25">...</a>
 */
public class Solution1276 {

    /**
     * 数学推导法
     * 巨无霸汉堡：tomatoSlices / 2 - cheeseSlices
     * 小皇堡：(cheeseSlices - (tomatoSlices / 2 - cheeseSlices)) = 2 * cheeseSlices - tomatoSlices / 2
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || tomatoSlices > cheeseSlices * 4) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(tomatoSlices / 2 - cheeseSlices);
        res.add(2 * cheeseSlices - tomatoSlices / 2);
        return res;
    }
}
