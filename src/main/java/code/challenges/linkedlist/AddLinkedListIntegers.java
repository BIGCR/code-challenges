package code.challenges.linkedlist;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;



/**
 *  [2,4,3]
    [5,6,4]

    [7, 0, 8]
 */
public class AddLinkedListIntegers {
    public static void AddIntegers(){
        ListNode a = initializeNode("1");
        ListNode b = initializeNode("99");

        ListNode result = findSum(a, b, 0);

        while(result != null){
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }

    public static ListNode initializeNode(String first){
        ListNode currentNode = null;
        ListNode head = null;

        for(char value : first.toCharArray()){
            ListNode newNode = new ListNode(Integer.valueOf(String.valueOf(value)));
            newNode.next = null;
            if(head == null){
                head = newNode;
                currentNode = head; 
            } else {
                currentNode.next = newNode;
                currentNode = currentNode.next;
            }
        }
        return head;            
    }

    public static ListNode findSum(ListNode a, ListNode b, int carry){
        Optional<ListNode> result = Optional.empty();
        Optional<ListNode> aNode = Optional.ofNullable(a);
        Optional<ListNode> bNode = Optional.ofNullable(b);

        int sum, newVal;

        if(aNode.isEmpty() && bNode.isEmpty()){
            if(carry > 0){
                return new ListNode(carry);
            }
            return null;
        }

        sum = carry + aNode.map(e -> e.val).orElseGet(() -> Integer.valueOf(0)) + bNode.map(e -> e.val).orElseGet(() -> Integer.valueOf(0));
        carry = sum / 10;
        newVal = sum % 10;
        result = Optional.of(new ListNode(newVal));

        if(carry > 0 || aNode.isPresent() || bNode.isPresent()) {
            result.get().next = findSum(aNode.map(e -> e.next).orElseGet(() -> null), bNode.map(e -> e.next).orElseGet(() -> null), carry);
        }

        return result.get();
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}