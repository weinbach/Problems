package leetcode.solved;

public class ZigZagConversion {
    //#6 ZigZag Conversion
    public static void main(String[] args) {

        System.out.println("this is it: " + convert2("ABСDEFGHIJKL", 5));

    }

    // fill array with 1,2,3,..n, n-1, n-2,..3,2,1
    // Example: n=5 -> 123454321
    // then for each i-n get index from string to resultString
    public static String convert(String s, int numRows) {

        String result = "";

        int[] res = new int[s.length()];
        int itemIndex = 0;

        int tempIterator = 0;
        boolean up = true;
        if (numRows > 1)
            while (itemIndex < s.length()) {
                res[itemIndex] = tempIterator;
                if (up) {
                    tempIterator++;
                    if (tempIterator > numRows - 1) {
                        up = false;
                        tempIterator -= 2;
                    }
                } else {
                    tempIterator--;
                    if (tempIterator < 0) {
                        up = true;
                        tempIterator += 2;
                    }
                }
                itemIndex++;
            }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < res.length; j++) {
                if (res[j] == i)
                    result += s.charAt(j);
            }
        }

        return result;
    }

    //faster than answer above
    public static String convert2(String s, int numRows) {
        StringBuilder res = new StringBuilder();

        int rowIndex = numRows;
        int itemIndex = 1;

        if(numRows==1)
            return s;

        while (rowIndex > 0) {
            int n = 1;
            while (true) {
                int a = itemIndex + (numRows * 2 - 2) * (n - 1) - 1;
                int b = a + (rowIndex * 2 - 2);

                if (a >= s.length())
                    break;
                res.append(s.charAt(a));

                if (b >= s.length())
                    break;
                if(a!=b)
                res.append(s.charAt(b));

                if(rowIndex==numRows)
                    n++;

                n++;
            }
            itemIndex++;
            rowIndex--;
        }
        return res.toString();
    }

}
