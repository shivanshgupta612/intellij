import java.util.PriorityQueue;

//https://leetcode.com/problems/construct-string-with-repeat-limit/
public class ConstructStringWithRepeatLimit {
    class Pair {
        char character;
        int value;

        Pair(char character, int value) {
            this.character = character;
            this.value = value;
        }
    }

    //this is actually a simple question utilizing the use of Priority Queue
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->Character.compare(b.character,a.character));
        int[]freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.add(new Pair((char)(i+97),freq[i]));
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!pq.isEmpty()) {
            Pair first = pq.poll();
            int count = Math.min(first.value, repeatLimit);
            for (int i = 0; i < count; i++) {
                sb.append(first.character);
            }
            if (first.value > count) {
                if (!pq.isEmpty()) {
                    Pair second = pq.poll();
                    sb.append(second.character);
                    if (--second.value > 0) {
                        pq.add(second);
                    }
                    first.value -= count;
                    pq.add(first);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
