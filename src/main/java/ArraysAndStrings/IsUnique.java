package ArraysAndStrings;

public class IsUnique {

    public boolean bruteForce(String str){
        for (int i = 0; i < str.length(); i++){
            for(int j=i+1; j<str.length();j++ ){
                if(str.charAt(i) == str.charAt(j)){
                    return  false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.bruteForce("abcd10jk"));
        System.out.println(isUnique.bruteForce("hutg9mnd!nk9"));
    }
}
