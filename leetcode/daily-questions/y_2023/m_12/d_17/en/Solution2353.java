package y_2023.m_12.d_17.en;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/design-a-food-rating-system/description/?envType=daily-question&envId=2023-12-17">...</a>
 */
public class Solution2353 {
    /**
     * 懒删除堆
     * AC
     */
    static class FoodRatings {
        static class Food {
            String name;
            String cuisine;
            Integer rating;

            Food(String name, String cuisine, Integer rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }
        }

        private final Map<String, Food> foodMap = new HashMap<>();
        private final Map<String, Queue<Food>> cuisineMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], food);
                cuisineMap.computeIfAbsent(cuisines[i], f -> new PriorityQueue<>((o1, o2) -> {
                    if (Objects.equals(o1.rating, o2.rating)) {
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.rating.compareTo(o1.rating);
                })).offer(food);
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodMap.get(food).cuisine;
            Food f = new Food(food, cuisine, newRating);
            cuisineMap.get(cuisine).offer(f);
            foodMap.put(food, f);
        }

        public String highestRated(String cuisine) {
            Queue<Food> queue = cuisineMap.get(cuisine);
            while (!queue.isEmpty() && !Objects.equals(queue.peek().rating, foodMap.get(queue.peek().name).rating)) {
                queue.poll();
            }
            return queue.peek() == null ? "" : queue.peek().name;
        }

    }
}
