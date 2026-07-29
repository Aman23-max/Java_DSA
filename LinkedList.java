// import java.util.LinkedList;

public class LinkedList {
    public static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }
        //i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i < idx-2
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        
        while(temp != null) {
            if(temp.data == key) return i;  //key found
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    //Recursive approach
    public int recSearch(int key, int i, Node temp) {  //O(n)
        if(temp == null) {
            return -1;
        }
        if(temp.data == key) return i;  //key found
        i++;
        return recSearch(key, i, temp.next); 
    }

    //backtracking approach
    public int recSearch2(int key, Node temp) {  //O(n)
        if(temp == null) {
            return -1;
        }
        if(temp.data == key) {
            return 0;
        }
        int idx = recSearch2(key, temp.next);
        if(idx == -1) {
            return -1;
        }

        return idx+1;
    }

    public void reverse() {  //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        int iToEnd = sz-n;
        Node prev = head;
        while(i < iToEnd) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //Check ListNode is Palindrome or Not
    public static Node getMid(Node head) { //helper fn
        if(head == null) return head;

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseList(Node right) { //helper fn
        Node prev = null;
        Node curr = right;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(Node head) {
        //An empty list or single node is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the mid Node 
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        // 2. Reverse the right half
        Node left = head;
        Node right = reverseList(rightHead);

        // 3. Compare both halves
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        // 4. Custom Restoration Step
        mid.next = reverseList(right);
        
        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true; //cycle exists
            }
        }
        return false; //cycle doesn't exists
    }

    public static void removeCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        if(isCycle == false) {
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null; //last node
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove Cycle - last.next = null
        prev.next = null;
    }

    //mergeSort using Linked List
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        //remaining nodes
        temp.next = (head1 != null) ? head1 : head2;
        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        //left & right MS
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //Merge
        return merge(newLeft, newRight);
    }

    public void zigZag(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        //find mid
        Node mid = getMid(head);

        //reverse 2nd half
        Node left = head;
        Node right = reverseList(mid.next);

        mid.next = null;
        Node nextL, nextR;
        
        //alt merge - zig-Zag merge
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    //Practice Qs
    public Node getIntersectionNode(Node headA, Node headB) {
        // Boundary check
        if(headA == null || headB == null) {
            return null;
        }

        Node ptrA = headA;
        Node ptrB = headB;

        // Loop continues until the two pointers meet.
        // If there is no intersection, both will become null at the same time.
        while(ptrA != ptrB) {
            // If ptrA reaches the end of list A, redirect it to headB.
            // Otherwise, advance it to the next node.
            ptrA = (ptrA == null) ? headB : ptrA.next;
            // If ptrB reaches the end of list B, redirect it to headA.
            // Otherwise, advance it to the next node.
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        // ptrA will either hold the intersecting node or null.
        return ptrA;
    }

    public void delNNodesAfterMNodes(int M, int N) {
        // If the list is empty, M is 0 (retain nothing), or N is 0 (delete nothing)
        if (head == null || M <= 0 || N <= 0) {
            return;
        }

        Node current = head;

        // Loop until we reach the end of the linked list
        while (current != null) {
            
            // 1. Traverse to the M-th node
            for (int i = 1; i < M && current != null; i++) {
                current = current.next;
            }

            // If we ran out of nodes before retaining M nodes, we are done
            if (current == null) {
                return;
            }

            // 2. Start from the node right after the M-th node
            Node temp = current.next;
            
            // Traverse N nodes to find the reconnection point
            for (int j = 1; j <= N && temp != null; j++) {
                temp = temp.next;
            }
            
            // 3. Reconnect the M-th node to the node after the deletion block
            current.next = temp;

            // 4. Move current to the reconnection point to repeat the cycle
            current = temp;
        }
    }

    public void swapingNodes(int x, int y) {
        // 1. Base cases: empty list or identical keys
        if (head == null || x == y) {
            return;
        }

        // 2. Track nodes and their predecessors
        Node prevX = null, tempX = head;
        while (tempX != null && tempX.data != x) {
            prevX = tempX;
            tempX = tempX.next;
        }

        Node prevY = null, tempY = head;
        while (tempY != null && tempY.data != y) {
            prevY = tempY;
            tempY = tempY.next;
        }

        // 3. Safety Check: If either x or y is not found in the list
        if (tempX == null || tempY == null) {
            return;
        }

        // 4. Update the preceding links (or head pointer)
        if (prevX != null) {
            prevX.next = tempY;
        } else {
            head = tempY; // x was the head, so y becomes the new head
        }

        if (prevY != null) {
            prevY.next = tempX;
        } else {
            head = tempX; // y was the head, so x becomes the new head
        }

        // 5. Swap the 'next' links of the two nodes themselves
        Node tempNext = tempX.next;
        tempX.next = tempY.next;
        tempY.next = tempNext;
    }

    public Node segregateEvenOdd(Node head) {
        // Dummy heads to simplify list creation
        Node evenHead = new Node(0);
        Node oddHead = new Node(0);
        
        // Pointers to track the end of both lists
        Node evenTail = evenHead;
        Node oddTail = oddHead;
        
        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                evenTail.next = curr;
                evenTail = evenTail.next;
            } else {
                oddTail.next = curr;
                oddTail = oddTail.next;
            }
            curr = curr.next;
        }
        
        // Connect even list to odd list
        evenTail.next = oddHead.next;
        
        // Terminate the odd list to prevent cycles
        oddTail.next = null;
        
        // The real start is the node after the even dummy head
        return evenHead.next;
    }

    public Node mergeKLists(Node[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        //(iterative) Divide_Conquer Approach
        int end = lists.length-1;
        while(end > 0) {
            int begin = 0;
            while(begin < end) {
                lists[begin] = merge(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addAtIndex(2, 3);
        // ll.removeFirst();
        // ll.removeLast();
        // System.out.println(ll.size);

        ll.print(); //1->2->3->4->5

        // System.out.println(ll.itrSearch(4));
        // System.out.println(ll.itrSearch(9));
        // System.err.println(ll.recSearch(5, 0, head));
        // System.err.println(ll.recSearch2(5, head));

        // ll.reverse();
        // ll.deleteNthfromEnd(2);
        // System.out.println(ll.isPalindrome(head));
        
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // 1->2->3->2
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // Java Collections FrameWork
        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addFirst(0);
        // // 0->1->2
        // ll.removeLast();
        // ll.removeFirst();
        // System.out.println(ll);
        
        // head = ll.mergeSort(head);
        // ll.zigZag(head);
        
        // Practice Qs
        // ll.delNNodesAfterMNodes(3, 2);
        // ll.swapingNodes(2, 4);
        // head = ll.segregateEvenOdd(head);
        // ll.print();

    }
}
