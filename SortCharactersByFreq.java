import java.util.*;
public class SortCharactersByFreq{
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(); 
        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        for(char c : s.toCharArray()) {
            map.put(c, (map.getOrDefault(c, 0)) + 1);
        }
        for(char c : map.keySet()) {
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch = pq.poll();
            for(int i = 0; i<map.get(ch); i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}