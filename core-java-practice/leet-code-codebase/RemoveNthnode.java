//Remove nth node of linked list
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       int size =0;
       ListNode temp =  head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
         if (n == size) {
            return head.next;
        }
        n = size - n;
    ListNode  temp1 = head;
        while(n>1){
         temp1 = temp1.next;
         n--;
        }
        temp1.next = temp1.next.next;

        return head;
    }
}