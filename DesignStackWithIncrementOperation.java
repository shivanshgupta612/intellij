//https://leetcode.com/problems/design-a-stack-with-increment-operation/?envType=daily-question&envId=2024-09-30

public class DesignStackWithIncrementOperation {
        class DoublyLinkedList{
            DoublyLinkedList prev;
            DoublyLinkedList next;
            int val;
            public DoublyLinkedList(int val){
                this.val=val;
                this.prev=null;
                this.next=null;
            }
        }
        int maxSize;
        DoublyLinkedList front;
        DoublyLinkedList back;
        int size;
        int inc[];
        public DesignStackWithIncrementOperation(int maxSize) {
            this.size=0;
            this.maxSize=maxSize;
            front=new DoublyLinkedList(-1);
            back=new DoublyLinkedList(-1);
            front.next=back;
            back.prev=front;
            inc=new int[maxSize];
        }

        public void push(int x) {
            if(size==maxSize)return;
            DoublyLinkedList newNode = new DoublyLinkedList(x);
            newNode.next=front.next;
            newNode.prev=front;
            front.next.prev=newNode;
            front.next=newNode;
            size++;
        }

        public int pop() {
            if(size==0)return -1;
            int idx = size-1; // Calculate the index for the current size.
            int val=front.next.val + inc[idx]; // Apply the accumulated increment.
            if(idx>0){
                inc[idx-1]+=inc[idx]; // Carry over the increment to the next lower level.
            }
            inc[idx]=0; // Reset the increment for the current level.

            DoublyLinkedList toDeleteNode = front.next;

            front.next=front.next.next;
            front.next.prev=front;
            toDeleteNode.next=null;
            toDeleteNode.prev=null;
            size--;
            return val;
        }

        public void increment(int k, int val) {
            int idx=Math.min(k,size)-1; // Find the bottom k elements.
            if(idx>=0){
                inc[idx]+=val; // Add the increment lazily.
            }
        }
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
