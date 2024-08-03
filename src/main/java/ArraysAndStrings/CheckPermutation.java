package ArraysAndStrings;

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

    public boolean characterCountApproach(String str1, String str2){
        if (str1.length() != str2.length()) return false;
        int[] asciichars = new int[128];
        for (Character ch: str1.toCharArray()){
            asciichars[ch]++;
        }

        for(Character c: str2.toCharArray()){
            asciichars[c]--;
            if(asciichars[c] < 0){
                return false;
            }
        }

        return  true;
    }
    public static void main(String[] args) {
        //Here one more easier approach would be to use set and store values which take o(n) space and o(n) time
        var checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.sortingApproach("God","dog"));
        System.out.println(checkPermutation.sortingApproach("God","doG"));
        System.out.println(checkPermutation.sortingApproach("G od","doG"));

        System.out.println(checkPermutation.characterCountApproach("God","dog"));
        System.out.println(checkPermutation.characterCountApproach("God","doG"));
        System.out.println(checkPermutation.characterCountApproach("G od","doG"));
    }
}
