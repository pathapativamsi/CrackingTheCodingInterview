package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str: wordDict){
            set.add(str);
        }
        StringBuilder output = new StringBuilder();
        int p1=0;
        int p2=1;
        while(p2<=s.length()){
            String curr = s.substring(p1,p2);
            if(set.contains(curr)){
                output.append(curr);
                p1 = p2;
                p2++;
            }
            else{
                p2++;
            }
        }
        return output.length() == s.length();
    }

    private static boolean wordBreakRecursion(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String str = s.substring(start, end);
            if (wordDict.contains(str) && wordBreakRecursion(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    private static boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String str = s.substring(start, end);
            if (wordDict.contains(str) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
//       boolean b = wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));
        boolean b = wordBreakRecursion("catsandog",new HashSet<>(List.of("cats","dog","sand","and","cat")),0);
//        String s = "catsandog";
//        boolean b = wordBreakMemo(s,new HashSet<>(List.of("cats","dog","sand","and","cat")),0,new Boolean[s.length()]);
        System.out.println(b);

    }
}

