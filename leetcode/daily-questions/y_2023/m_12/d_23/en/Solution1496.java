package y_2023.m_12.d_23.en;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/path-crossing/description/?envType=daily-question&envId=2023-12-23">...</a>
 */
public class Solution1496 {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        visited.add(x + "_" + y);
        for (char direction : path.toCharArray()) {
            switch (direction) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
            }
            String coordinates = x + "_" + y;
            if (visited.contains(coordinates)) {
                return true;
            }
            visited.add(coordinates);
        }
        return false;
    }
}
