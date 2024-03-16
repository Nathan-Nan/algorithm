package double_weekly.number_126.problem_3;

public class Solution2 {
    public String minimizeStringValue(String s) {
        int[] cou = new int[27];
        int n = s.length();
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                x++;
            } else {
                cou[s.charAt(i) - 97]++;
            }
        }
        int[] rep = new int[27];
        for (int i = 0; i < x; i++) {
            int min = cou[0];
            int mi = 0;
            for (int k = 1; k < 26; k++) {
                if (cou[k] < min) {
                    min = cou[k];
                    mi = k;
                }
            }
            cou[mi]++;
            rep[mi]++;
        }
        int y = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                while (rep[y] == 0) {
                    y++;
                }
                sb.append((char) (y + 97));
                rep[y]--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
