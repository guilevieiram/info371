public class Bovary {
    static HMap buildTable(String[] files, int n){
        HMap hm = new HMap();
        for(int i = 0; i < files.length; i++){
            WordReader text = new WordReader(files[i]);
            String word = text.read();
            Prefix p = new Prefix(n);
            hm.add(p, word);
            while(word != null){
                p = p.addShift(word);
                word = text.read();
                if(word != null)
                    hm.add(p, word);
                else
                    hm.add(p, Prefix.end);
            }
        }
        return hm;
    }
    
    static void generate(HMap t, int n){
        Prefix p = new Prefix(n);
        while(true){
            String [] words = t.find(p).toArray();
            int index = (int) (Math.random() * words.length);
            String word = words[index];
            switch(word){
                case Prefix.par:
                    System.out.println();
                    break;
                case Prefix.end:
                    System.out.println();
                    break;
                default:
                    System.out.print(word + " ");
            }
            p = p.addShift(word);
            if(word.equals(Prefix.end)) break;
        }
    }

    public static void main(String[] args){
        int numberTexts = 35;
        int n = 3;
        String[] texts = new String[numberTexts];
        for (int i = 1; i < numberTexts + 1; i++ ){
            if (i < 10)
                texts[i - 1 ] = "bovary/0" + i + ".txt";
            else 
                texts[i - 1] = "bovary/" + i + ".txt";
        }
        generate(buildTable(texts, n), n);
    }
}
