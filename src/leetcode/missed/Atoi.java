package leetcode.missed;

public class Atoi {

    public static int myAtoi(String str) {

        str = str.replace(" ", "").toLowerCase();
        if(str.length()==0)
            return 0;
        String a = "1234567890+-";
        if(a.indexOf(str.charAt(0))==-1){
            return 0;
        } else{
            for(int i=1;i<str.length();i++){
                if(!Character.isDigit(str.charAt(i))){
                    str = str.substring(0, i);
                    break;
                }
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e){
                if(str.charAt(0) == '-' && str.length()>1)
                    return Integer.MIN_VALUE;
                else if(str.charAt(0) == '+' && str.length()>1)
                    return Integer.MAX_VALUE;
                else
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("ss: " + myAtoi("-91283472332"));
    }

}
