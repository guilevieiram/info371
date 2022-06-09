public class HMap {
    EntryList[] t;
    int nbEntries = 0;

    HMap(int n){
        t = new EntryList [n];
    }
    HMap(){
        t = new EntryList [20];
    }

    void print (){
        for (int i = 0; i < t.length; i++){
            EntryList el = t[i];
            if(el == null) System.out.println("null");
            else{
                for(EntryList cur = el; cur != null; cur = cur.next){
                    cur.head.key.print();
                    System.out.print( ": ");
                    System.out.print(cur.head.value.print());
                    System.out.print(" | ");
                }
                System.out.println();
            }
        }
    }

    WordList find(Prefix key){
        int hashIndex = key.hashCode(t.length);
        EntryList list = t[hashIndex];

        EntryList cur = list;
        while(cur != null){
            if(Prefix.eq(cur.head.key, key))
                break;
            cur = cur.next;
        }
        if(cur == null) return null;
        return cur.head.value;
    }

    void addSimple(Prefix key, String w){
        // preparing word list
        WordList l = find(key);
        if(l != null){
            l.addLast(w);
            return;
        }
        nbEntries ++;
        l = new WordList();
        l.addLast(w);
        int hashKey = key.hashCode(t.length);
        if(t[hashKey] == null){
            t[hashKey] = new EntryList(new Entry(key, l), null);
        }
        else {
            // adding in the end
            EntryList cur;
            for(cur = t[hashKey]; cur.next != null; cur = cur.next ){}
            cur.next = new EntryList(new Entry(key, l), null);
        }
    }

    void rehash(int n) {

        EntryList[] tmp = t;
        t = new EntryList[n];
        nbEntries = 0;
        for(int i = 0; i < tmp.length; i++){
            for(EntryList cur = tmp[i]; cur != null; cur = cur.next){
                String[] wl = cur.head.value.toArray();
                for(int j = 0; j < wl.length; j++)
                    addSimple(cur.head.key, wl[j]);
            }
        }
    }

    void add(Prefix key, String w){
        addSimple(key, w);
        if(nbEntries >= (3 * t.length)/4) rehash(2 * t.length);
    }
    
}
