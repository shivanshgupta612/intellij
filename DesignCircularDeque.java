
//https://leetcode.com/problems/design-circular-deque/description/
public class DesignCircularDeque {
    class Dll{
        int val;
        Dll next;
        Dll prev;
        public Dll(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }
    Dll front;
    Dll back;
    int size;
    int k;
    public DesignCircularDeque(int k) {
        front = new Dll(-1);
        back=new Dll(-1);
        front.next=back;
        back.prev=front;
        size=0;
        this.k=k;
    }

    public boolean insertFront(int value) {
        if(size==k)return false;
        Dll newnode=new Dll(value);
        newnode.next=front.next;
        newnode.prev=front;
        front.next.prev=newnode;
        front.next=newnode;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(size==k)return false;
        Dll newnode=new Dll(value);
        newnode.next=back;
        newnode.prev=back.prev;
        back.prev.next=newnode;
        back.prev=newnode;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(size==0)return false;
        Dll todelete=front.next;
        front.next=todelete.next;
        todelete.next.prev=front;
        todelete.next=null;
        todelete.prev=null;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(size==0)return false;
        Dll todelete=back.prev;
        todelete.prev.next=todelete.next;
        todelete.next.prev=todelete.prev;;
        todelete.next=null;
        todelete.prev=null;
        size--;
        return true;
    }

    public int getFront() {
        return front.next.val;
    }

    public int getRear() {
        return back.prev.val;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
