 class Solution {  
        public ListNode reverseBetween(ListNode head, int left, int right) {  
                // Base case  
                        if (head == null || left == right) {  
                                    return head;  
                                            }  

                                                    // Create a dummy node that points to the head of the list  
                                                            ListNode dummy = new ListNode(0);  
                                                                    dummy.next = head;  
                                                                            ListNode prev = dummy;  

                                                                                    // Step 1: Move `prev` to the node just before `left`  
                                                                                            for (int i = 0; i < left - 1; i++) {  
                                                                                                        prev = prev.next;  
                                                                                                                }  

                                                                                                                        // `curr` will point to the first node of the sublist to reverse  
                                                                                                                                ListNode curr = prev.next;  
                                                                                                                                        // `tail` is the last node of the sublist to reverse  
                                                                                                                                                ListNode tail = curr;  

                                                                                                                                                        // Step 2: Reverse the sublist  
                                                                                                                                                                for (int i = 0; i < right - left + 1; i++) {  
                                                                                                                                                                            ListNode nextNode = curr.next;  
                                                                                                                                                                                        curr.next = prev.next; // Move `curr` to the front of the sublist  
                                                                                                                                                                                                    prev.next = curr;      // Re-link the previous node  
                                                                                                                                                                                                                curr = nextNode;       // Move `curr` forward  
                                                                                                                                                                                                                        }  

                                                                                                                                                                                                                                // Step 3: Connect the reversed sublist with the rest of the list  
                                                                                                                                                                                                                                        tail.next = curr;  

                                                                                                                                                                                                                                                // Return the new head, which is next to the dummy node  
                                                                                                                                                                                                                                                        return dummy.next;  
                                                                                                                                                                                                                                                            }  
                                                                                                                                                                                                                                                            }  
 