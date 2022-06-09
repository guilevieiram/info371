package typo;

import java.util.LinkedList;

public abstract class Group extends Box{
    protected final LinkedList<Box> list = new LinkedList<Box>();

    public double ascent;
    public double descent;
    public double width;
    public double stretchingCapacity;

    
    public void add (Box b){
        list.add(b);
    }

    public double getWidth(){return width;}
    public double getAscent(){return ascent;}
    public double getDescent(){return descent;}
    public double getStretchingCapacity(){return stretchingCapacity;}

    @Override
    public String toString() {
        String s = super.toString() + "{\n";
        for(Box b : list){
            String tmp = b.toString();
            tmp = tmp.replaceAll("\n", "\n   ");
            s += "   " + tmp + ",\n";
        }
        s += "}";

        return s;
    }
}
