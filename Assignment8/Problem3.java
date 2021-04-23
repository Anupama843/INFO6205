package Assignment8;

import java.util.*;
/*
3. https://leetcode.com/problems/word-ladder/
 */


public class Problem3 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)){
                    return count;
                }
                List<String> adjacent = adjacency(currentWord);
                for(String adj: adjacent){
                    if(words.contains(adj)){
                        words.remove(adj);
                        queue.add(adj);
                    }
                }
            }
        }
        return 0;
    }
    public List<String> adjacency(String string){
        char[] chars = string.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            char temp = chars[i];
            for (char c = 'a'; c <='z'; c++){
                chars[i] = c;
                String neighbor = new String(chars);
                result.add(neighbor);
            }
            chars[i] = temp;
        }
        return result;
    }


    public static void main(String[] args) {
        Problem3 p = new Problem3();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(p.ladderLength(beginWord, endWord, wordList));

    }
}
