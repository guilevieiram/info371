package typo;

import java.awt.Graphics;

public class Hbox extends Group{

    @Override
    public void add (Box b){
        super.add(b);
        stretchingCapacity += b.getStretchingCapacity();
        width += b.getWidth();
        if(b.getAscent() > this.ascent)
            this.ascent = b.getAscent();
        if(b.getDescent() > this.descent)
            this.descent = b.getDescent();
    }

    @Override
    public String toString() {
        return "Hbox"+super.toString();
    }

    @Override
    public boolean doDraw(Graphics graph, double x, double y, double w) {
        double mw = getWidth();
        double xInit = x;
        double yInit = y;
        if(mw > w){
            for(Box b : this.list){
                b.draw(graph, xInit, yInit + ascent - b.getAscent(), b.getWidth());
                xInit += b.getWidth();
            }
            return false;
        }
        else {
            double dif = w - mw;
            for(Box b : this.list){
                double stretchingFactor = (double) (dif * b.getStretchingCapacity() / stretchingCapacity);
                if(Double.isNaN(stretchingFactor)) stretchingFactor = 0;
                b.draw(graph, xInit, yInit + ascent - b.getAscent(), b.getWidth() + stretchingFactor);
                xInit += b.getWidth() + stretchingFactor;
            }

            return true;
        }

    }
    
}
