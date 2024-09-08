
// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//https://leetcode.com/problems/split-linked-list-in-parts/

public class SplitLinkedListinParts {
    //k=7 count=27
    // 27/7 = 3 27%7 = 6
    // 1234 5678 9101112 13141516 17181920 21222324 252627 4444443
    //k=7 count=11
    // 11/7 = 1 11%7 = 4
    // 12 34 56 78 9 10 11 2222111
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        ListNode[] res=new ListNode[k];
        int i=0;
        if(count>k){
            int multiple = count/k;
            int modulo = count%k;
            for(int j=0;j<modulo;j++){
                ListNode prev=null;
                curr=head;
                for(int p=0;p<multiple+1;p++){
                    prev=curr;
                    curr=curr.next;
                }
                res[i]=head;
                head=curr;
                prev.next=null;
                i++;
            }
            int rem=count-(modulo  * (multiple+1));
            for(int j=0;j<rem/multiple;j++){
                ListNode prev=null;
                curr=head;
                for(int p=0;p<multiple && curr!=null;p++){
                    prev=curr;
                    curr=curr.next;
                }
                res[i]=head;
                head=curr;
                prev.next=null;
                i++;
            }
        }else{
            while(head!=null){
                res[i]=head;
                head=head.next;
                res[i].next=null;
                i++;
            }
            while(i<k){
                // res[i]=new ListNode();
                i++;
            }
        }
        return res;
    }
}
