import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/map-sum-pairs/
public class MapSumPairs {
    class Trie{
        Trie child[]= new Trie[26];
        int count;
    }
    Map<String,Integer> present ;
    Trie trie;
    public MapSumPairs() {
        present = new HashMap<>();
        trie=new Trie();
    }

    public void insert(String key, int val) {
        Trie curr=trie;
        if(present.containsKey(key)){
            int prev=present.get(key);
            int n=key.length();
            for(int i=0;i<n;i++){
                int ind=key.charAt(i)-'a';
                curr=curr.child[ind];
                curr.count-=prev;
                curr.count+=val;
            }
        }else{
            int n=key.length();
            for(int i=0;i<n;i++){
                int ind=key.charAt(i)-'a';
                if(curr.child[ind]==null)
                    curr.child[ind]=new Trie();
                curr=curr.child[ind];
                curr.count+=val;
            }
        }
        present.put(key,val);
    }

    public int sum(String prefix) {
        int n=prefix.length();
        int sum=0;
        Trie curr=trie;
        for(int i=0;i<n;i++){
            int ind=prefix.charAt(i)-'a';
            if(curr.child[ind]==null){
                return 0;
            }
            curr=curr.child[ind];
            sum=curr.count;
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
