package Algorthm.LeetCode;//127 word Ladder

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;




public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        int ans =k.ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ans);
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> wordlst = new LinkedList<>(wordList);
        wordlst.add(beginWord); //it seems the wordList does not contain the begin word
        Map<String, Set<String>> graph = buildGraph(wordlst); //
        System.out.println(graph);

        //clasic bfs starts here
        int len = 1;
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(curr.equals(endWord))
                    return len;
                for(String nei: graph.get(curr)){
                    if(!seen.contains(nei)){
                        seen.add(nei);
                        q.add(nei);
                    }
                }
            }

            len++;
        }

        return 0;
    }
    private Map<String, Set<String>> buildGraph(List<String> wordList){
        Map<String, List<String>> adjGroup = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();

        //for each word generate all posibile keys while keeping track words that have a common key
        for(String word: wordList){
            for(int i = 0; i < word.length(); ++i){
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                System.out.println(key);
                adjGroup.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            }
        }
        System.out.println(adjGroup);
        for(String word: wordList){
            graph.put(word, new HashSet<>());
            for(int i = 0; i < word.length(); ++i){
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> neighbours = adjGroup.get(key);
                graph.get(word).addAll(neighbours);
            }
        }
        return graph;
    }
}