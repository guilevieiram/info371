package typo;

import java.awt.Graphics;

public class Vbox extends Group{
    private double lineSkip;
    public Vbox (double lineSkip){
        this.lineSkip = lineSkip;
        this.stretchingCapacity = 0;
        this.width = 0;
        this.ascent = 0;
    }

    @Override
    public void add (Box b){
        if (b.getStretchingCapacity() > this.stretchingCapacity)
            this.stretchingCapacity = b.getStretchingCapacity();
        if(b.getWidth() > this.width)
            this.width = b.getWidth();
        this.descent = b.getDescent();
        if(list.isEmpty())
            this.ascent = b.getAscent();
        else 
            this.ascent += lineSkip + this.list.getLast().getDescent() + b.getAscent();
        super.add(b);
    }

    @Override
    public boolean doDraw(Graphics graph, double x, double y, double w) {
        double xInit = x;
        double yInit = y;

        for (Box b: this.list) {
            b.draw(graph, xInit, yInit, width);
            yInit += b.getAscent() + lineSkip;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Vbox" + super.toString();
    }
}
