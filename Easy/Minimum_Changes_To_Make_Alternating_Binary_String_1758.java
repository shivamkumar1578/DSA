public class Minimum_Changes_To_Make_Alternating_Binary_String_1758 {
    public int minOperations(String s) {
        int mismatch0 = 0;
        int mismatch1 = 0;

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            char expect0 = (i % 2 == 0) ? '0' : '1';
            char expect1 = (i % 2 == 0) ? '1' : '0';
            if(ch != expect0) mismatch0++;
            if(ch != expect1) mismatch1++;
        }
        return Math.min(mismatch0, mismatch1);
    }
}
