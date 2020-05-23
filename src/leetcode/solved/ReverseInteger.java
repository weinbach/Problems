package leetcode.solved;

public class ReverseInteger {
    //#7 Reverse Integer
    public static void main(String[] args) {
        System.out.println("res: " + reverse(-2147483648));
    }

    public static int reverse(int x) {
        int result = 0;
        if(Double.isNaN((Math.log10(Math.abs(x)))))
            return 0;
        int power = (int)(Math.log10(Math.abs(x)));
        while(x!=0){
            try{
                result = Math.addExact(result, (int)((x%10)*Math.pow(10, power)));
            } catch (Exception e){
                return 0;
            }
            x=x/10;
            power--;
        }
        return result;
    }

}
