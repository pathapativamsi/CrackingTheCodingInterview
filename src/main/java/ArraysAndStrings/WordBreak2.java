package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {
    TrieNode root;
    List<String> ans;

    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public class TrieNode{
        HashMap<Character,TrieNode> map = new HashMap<>();
        boolean isEnd;

        TrieNode(){
            map = new HashMap<>();
            isEnd = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(root.map.containsKey(board[x][y])){
                    boolean[][] arr = new boolean[m][n];
                    arr[x][y] = true;
                    sol(board,x,y,arr,root.map.get(board[x][y]),"");
                }
            }
        }

        return ans;
    }

    public void sol(char[][] board,int row,int col,boolean[][] visited, TrieNode node,String str){
        if(node.isEnd){
            ans.add(str);
            node.isEnd = false;
        }

        for (int[] d: dir){
            int a = row + d[0];
            int b = col + d[1];
            if(a >=0 && b >= 0 && a<board.length && b<board[0].length && visited[a][b] == false && node.map.containsKey(board[a][b])){
                sol(board,a,b,visited,node.map.get(board[a][b]),str+board[a][b]);
                if (node.map.get(board[a][b]).map.isEmpty()) {
                    node.map.remove(board[a][b]);
                }
                visited[a][b] = false;
            }
        }

    }



    public void insert(String s){
        TrieNode temp = root;
        for(char ch: s.toCharArray()){
            if(temp.map.containsKey(ch)){
                temp = temp.map.get(ch);
            }
            else temp.map.put(ch,new TrieNode());
        }
        temp.isEnd = true;
    }

    public static void main(String[] args) {
        WordBreak2 wb2 = new WordBreak2();
        System.out.println(
                wb2.findWords(new char[][]{
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}
                }, new String[]{"oath","pea","eat","rain"})
        );

    }
}
