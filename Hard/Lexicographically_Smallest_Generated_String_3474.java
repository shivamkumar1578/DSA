package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexicographically_Smallest_Generated_String_3474 {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];
        Arrays.fill(word, '?');

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?') {
                        word[i + j] = str2.charAt(j);
                    } else if (word[i + j] != str2.charAt(j)) {
                        return "";
                    }
                }
            }
        }

        int[] lastQ = new int[n];
        Arrays.fill(lastQ, -1);
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                for (int j = m - 1; j >= 0; j--) {
                    if (word[i + j] == '?') {
                        lastQ[i] = i + j;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F' && lastQ[i] == -1) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    return "";
            }
        }

        List<List<Integer>> endAt = new ArrayList<>(len);
        for (int k = 0; k < len; k++) {
            endAt.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F' && lastQ[i] != -1) {
                endAt.get(lastQ[i]).add(i);
            }
        }

        for (int k = 0; k < len; k++) {
            if (word[k] == '?') {
                boolean[] forbidden = new boolean[26];

                for (int i : endAt.get(k)) {
                    boolean match = true;
                    for (int j = 0; j < m; j++) {
                        if (i + j == k)
                            continue;
                        if (word[i + j] != str2.charAt(j)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        forbidden[str2.charAt(k - i) - 'a'] = true;
                    }
                }

                char chosen = '?';
                for (int c = 0; c < 26; c++) {
                    if (!forbidden[c]) {
                        chosen = (char) ('a' + c);
                        break;
                    }
                }

                if (chosen == '?')
                    return "";

                word[k] = chosen;
            }
        }

        return new String(word);
    }
}
