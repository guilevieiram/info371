public class Node {
    String head; 
    Node next;

    Node (String head, Node next){
        this.head = head;
        this.next = next;
    }

    static int lengthRec(Node l){
        if(l == null) return 0;
        return 1 + lengthRec(l.next);
    }

    static int length(Node l){
        int len = 0;
        for(Node cur = l; cur != null; cur = cur.next)
            len++;
        return len;
    }

    static String printNodes(Node l){
        String nodeString = "[";
        for(Node cur = l; cur != null; cur = cur.next){
            nodeString += cur.head;
            if(cur.next != null) nodeString += ", ";
        }
        nodeString += "]";
        return nodeString;
    }
    
    static void addLast(String s, Node l){
        if(l == null) return;
        Node cur;
        for(cur = l; cur.next != null; cur = cur.next){}
        cur.next = new Node(s, null);
    }

    static Node copy(Node the){
        if(the == null) return the;

        Node res = new Node(the.head, null);
        for(Node cur = the.next; cur != null; cur = cur.next){
            addLast(cur.head, res);
        }
        return res;
    }

    static Node insert(String s, Node l){
        Node cur = l;
        Node prev = l;
        if(l == null) return new Node(s, null);
        if(s.compareTo(cur.head) < 0){
            l = new Node(s, l);
            return l;
        }
        cur = cur.next;
        while(cur != null && s.compareTo(cur.head) >= 0){
            prev = cur;
            cur = cur.next;
        }
        prev.next = new Node(s, cur);
        return l;
    }

    static Node insertionSort(Node l){
        Node res = new Node(l.head, null);
        for(Node cur = l.next; cur != null; cur = cur.next){
            res = insert(cur.head, res);
        }
        return res;
    }

    static Node merge(Node l1, Node l2){
        System.out.println("merging " + printNodes(l1) + printNodes(l2));
        Node ptr1 = l1;
        Node ptr2 = l2;
        Node res = new Node("", null);

        if(ptr1 == null) return ptr2;
        if(ptr2 == null) return ptr1;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.head.compareTo(ptr2.head) > 0){
                addLast(ptr2.head, res);
                if(ptr2 != null) ptr2 = ptr2.next;
            }
            else {
                addLast(ptr1.head, res);
                if(ptr1 != null) ptr1 = ptr1.next;
            }
        }
        if(ptr1 == null) {
            Node cur = res;
            for(cur = res; cur.next != null; cur = cur.next){}
            cur.next = ptr2;
        }
        if(ptr2 == null) {
            Node cur = res;
            for(cur = res; cur.next != null; cur = cur.next){}
            cur.next = ptr1;
        }
        System.out.println("merged " + printNodes(res.next));
        return res.next;
    }


}
