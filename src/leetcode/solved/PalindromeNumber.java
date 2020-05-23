package leetcode.solved;

public class PalindromeNumber {
    //#9 Palindrome Number
    public static void main(String[] args) {
        System.out.println("res: " + isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;

        int powerMax = (int)(Math.log10(Math.abs(x)));
        int firstDigit;
        while (powerMax>0){
            firstDigit = (int) (x/(Math.pow(10, powerMax)));
            if(firstDigit != x%10)
                return false;
            x-=firstDigit*(Math.pow(10, powerMax));
            x=x/10;
            powerMax-=2;

        }
        return true;
    }

}
