public class Check_if_Strings_Can_be_Made_Equal_With_Operations_I_2839 {
    eturn sameChars(s1.charAt(0), s1.charAt(2), s2.charAt(0), s2.charAt(2)) &&
               sameChars(s1.charAt(1), s1.charAt(3), s2.charAt(1), s2.charAt(3));
    }

    private boolean sameChars(char a, char b, char c, char d) {
        return (a == c && b == d) || (a == d && b == c);
    }
}
