public class Check_Divisibility_by_Digit_Sum_and_Product_3622 {
    public boolean checkDivisibility(int n) {
        int original = n;
        int digitSum = 0;
        int digitProduct = 1;

        while (n > 0) {
            int digit = n % 10;
            digitSum += digit;
            digitProduct *= digit;
            n /= 10;
        }

        int divisor = digitSum + digitProduct;
        return original % divisor == 0;
    }
}
