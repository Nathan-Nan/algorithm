package od.interview_contest;

import java.util.ArrayList;
import java.util.List;

/**
 * 华为 OD 第二轮技术面算法题
 * 按奥运奖牌数量降序排序，当奖牌数量一致时，按国家名称字典序升序排序
 */
public class Solution2 {
    // 输入：
    // China 32 28 34
    // England 12 34 22
    // France 23 33 2
    // Japan 12 34 25
    // Rusia 23 43 0
    // 输出：
    // China
    // Rusia
    // France
    // Japan
    // England

    static class Country implements Comparable<Country> {
        String country;
        Integer gold;
        Integer silver;
        Integer bronze;

        Country(String country, Integer gold, Integer silver, Integer bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }


        @Override
        public int compareTo(Country o) {
            if (this.gold > o.gold) {
                return -1;
            }
            if (this.gold < o.gold) {
                return 1;
            }
            if (this.silver > o.silver) {
                return -1;
            }
            if (this.silver < o.silver) {
                return 1;
            }
            if (this.bronze > o.bronze) {
                return -1;
            }
            if (this.bronze < o.bronze) {
                return 1;
            }
            return this.country.compareTo(o.country);
        }
    }

    public static void main(String[] args) {
        List<Country> countries = new ArrayList<Country>() {{
            add(new Country("China", 32, 28, 34));
            add(new Country("England", 12, 34, 22));
            add(new Country("France", 23, 33, 2));
            add(new Country("Japan", 12, 34, 25));
            add(new Country("Rusia", 23, 43, 0));
            add(new Country("ASA", 23, 43, 0));
        }};
        countries.sort(Country::compareTo);
        countries.forEach(country -> System.out.println(country.country));
    }

}
