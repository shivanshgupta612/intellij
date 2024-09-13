
//https://leetcode.com/problems/xor-queries-of-a-subarray/description/
public class XORQueriesofaSubarray {
    private int fetch(int ind,int l,int r,int start,int end,int[]seg){
        if(start<=l && r<=end){
            return seg[ind];
        }
        if(r<start || l>end){
            return 0;
        }
        int m = (l+r)/2;
        int left = fetch(2*ind+1,l,m,start,end,seg);
        int right = fetch(2*ind+2,m+1,r,start,end,seg);

        return left^right;
    }
    private void build(int ind, int l,int r,int[]arr,int[]seg){
        if(l==r){
            seg[ind]=arr[l];
            return;
        }
        int m=(l+r)/2;
        build(2*ind+1,l,m,arr,seg);
        build(2*ind+2,m+1,r,arr,seg);

        seg[ind]=seg[2*ind+1]^seg[2*ind+2];
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int []seg=new int[4*n];
        build(0,0,n-1,arr,seg);
        int[]res=new int[queries.length];
        int i=0;
        for(int[]query:queries){
            res[i]=fetch(0, 0, n - 1, query[0], query[1], seg);
            i++;
        }
        return res;
    }
}
