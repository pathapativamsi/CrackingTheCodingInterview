package ArraysAndStrings;

import java.util.HashSet;

public class IsUnique {

    public boolean bruteForce(String str){
        //Takes O(n^2) complexity
        for (int i = 0; i < str.length(); i++){
            for(int j=i+1; j<str.length();j++ ){
                if(str.charAt(i) == str.charAt(j)){
                    return  false;
                }
            }
        }
        return true;
    }

    public boolean hashSetApproach(String str){
        //takes o(n) time and space
        HashSet<Character> set = new HashSet<>();
        for(char ch: str.toCharArray()){
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }

        return true;
    }

    public boolean checkWithAlphabetArray(String str){
        if(str.length() > 128) return false;
        //In ASCII there are 128 charcters only without duplicates string cant be more than length 128
        boolean[] charSet = new boolean[128];
        for(int x=0; x< str.length();x++){
            if(charSet[str.charAt(x)] == true){
                return false;
            }
            charSet[str.charAt(x)] = true;
        }
        return true;
    }
    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.bruteForce("abcd10jk"));
        System.out.println(isUnique.bruteForce("hutg9mnd!nk9"));

        System.out.println(isUnique.hashSetApproach("abcd10jk"));
        System.out.println(isUnique.hashSetApproach("hutg9mnd!nk9"));

        System.out.println(isUnique.checkWithAlphabetArray("abcd10jk"));
        System.out.println(isUnique.checkWithAlphabetArray("hutg9mnd!nk9"));
    }
}
