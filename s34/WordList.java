public class WordList {
    Node content;

    static WordList foobar = new WordList( new Node("foo", new Node("bar", new Node("baz", null))));

    WordList(){
        content = null;
    }
    WordList(Node l){
       content = l;
    }
    WordList(String[] t){
        Node ptr = new Node("", null);
        for(int i = 0; i < t.length; i++){
            ptr = Node.insert(t[i], ptr);
        }
        content = ptr.next;
    }

    int length(){
        return Node.length(content);
    }

    String print(){
        return Node.printNodes(content);
    }

    void addFirst(String w){
        content = new Node(w, content);
    }
    void addLast(String w){
        if (w == null) return;
        if(content == null) addFirst(w);
        else Node.addLast(w, content);
    }
    String removeFirst(){
        if(content == null) return null;
        String res = content.head;
        content = content.next;
        return res;
    }
    String removeLast(){
        if(content == null) return null;
        if(content.next == null) {
            String head = content.head; 
            content = null;
            return head;
        }
        Node cur;
        String res;
        for(cur = content; cur.next.next != null; cur = cur.next){}
        res = cur.next.head;
        cur.next = null;
        return res;
    }

    void insert(String s){
        content = Node.insert(s, content);
    }
    void insertionSort(){
        if(content == null) return;
        content = Node.insertionSort(content);
    }

    void mergeSort(){
        if(content == null) return;

        content = mergeRec(content);
    }

    private Node mergeRec(Node arr){
        System.out.println(Node.printNodes(arr));
        if(arr == null) return null;

        if(arr.next == null) return arr;

        // divides first in the middle
        Node ptr, cur = arr;
        for(int i = 0; i < (Node.length(arr) - 1)/2; i++) cur = cur.next;
        ptr = cur; 
        cur = cur.next;
        ptr.next = null;
        return Node.merge(mergeRec(arr), mergeRec(cur));
    }

    String[] toArray(){
        int length = 0;
        for(Node cur = content; cur != null; cur = cur.next) length++;

        String[] res = new String[length];
        int index = 0;

        for(Node cur = content; cur != null; cur = cur.next){
            res[index] = cur.head;
            index++;
        }
        return res;
    }

}
