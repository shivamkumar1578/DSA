public class Count_the_Number_of_Special_Characters_I_3120 {

    public int numberOfSpecialChars(String word) {

        boolean[] lc = new boolean[26];
        boolean[] uc = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lc[ch - 'a'] = true;
            } else if (Character.isUpperCase(ch)) {
                uc[ch - 'A'] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lc[i] && uc[i])
                count++;
        }
        return count;
    }

}
