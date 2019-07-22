package linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

    ListNode(int[] arr){
        if(arr == null || arr.length < 0){
            throw new IllegalArgumentException("arr is null.");
        }

        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        res.append(cur.val);
        while(cur.next != null){
            res.append("->" + cur.next.val);
            cur = cur.next;
        }
        res.append("->NULL");
        return res.toString();
    }
}
