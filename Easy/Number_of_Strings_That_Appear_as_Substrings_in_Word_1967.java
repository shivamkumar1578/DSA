public class Number_of_Strings_That_Appear_as_Substrings_in_Word_1967 {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String str : patterns) {
            if (word.indexOf(str) != -1) {
                ans++;
            }
        }
        return ans;
    }
}
