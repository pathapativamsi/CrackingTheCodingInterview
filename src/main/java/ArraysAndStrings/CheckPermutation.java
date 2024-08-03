package ArraysAndStrings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckPermutation {

    private String sort(String str){
        var chArr = str.toCharArray();
        Arrays.sort(chArr);
        return new String(chArr);
    }

    public boolean sortingApproach(String str1, String str2){
        //o(N*logN) time complexity and constant space
        if(str1.length() != str2.length()) return false;
        return sort(str1).equals(sort(str2));
    }
    public static void main(String[] args) {
        var checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.sortingApproach("God","dog"));
        System.out.println(checkPermutation.sortingApproach("God","doG"));
        System.out.println(checkPermutation.sortingApproach("G od","doG"));
    }
}
