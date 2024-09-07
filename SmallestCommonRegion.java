import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.lintcode.com/problem/3669/description
public class SmallestCommonRegion {

    private String findLCA(Map<String, List<String>> adj, String root, String r1, String r2){
        if(root.isEmpty())return "";

        if(root.equals(r1) || root.equals(r2)) return root;

        if(!adj.containsKey(root))return "";

        List<String>childrenAnswers = new ArrayList<>();
        int cnt=0;
        for(String neighbor : adj.get(root)){
            String temp = findLCA(adj,neighbor,r1,r2);
            childrenAnswers.add(temp);
            if(!temp.isEmpty()){cnt++;}
        }
        if(cnt==2) return root;

        for(String neighbor:childrenAnswers){
            if(!neighbor.isEmpty())return neighbor;
        }
        return "";
    }

    /**
     * @param regions: The list of regions.
     * @param region1: One of regions.
     * @param region2: One of regions.
     * @return: The smallest common region.
     */
    public String smallestCommonRegion(String[][] regions, String region1, String region2) {
        Map<String,List<String>>adj=new HashMap<>();
        for(int i=0;i<regions.length;i++){
            String head=regions[i][0];
            List<String>neighbors = adj.getOrDefault(head,new ArrayList<>());
            for(int j=1;j<regions[i].length;j++){
                neighbors.add(regions[i][j]);
            }
            adj.put(head,neighbors);
        }
        for(Map.Entry<String,List<String>>entry : adj.entrySet()){
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
        return findLCA(adj,regions[0][0],region1,region2);
    }
}