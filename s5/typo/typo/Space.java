package typo;

import java.awt.Graphics;

public class Space extends Box{
    private double width;
    private double stretchingCapacity;

    public Space(double minWidth, double stretchingCapacity){
        this.width = minWidth;
        this.stretchingCapacity = stretchingCapacity;
    }


    public double getWidth(){
        return this.width;
    }
    public double getAscent(){
        return 0;
    }
    public double getDescent(){
        return 0;
    }
    public double getStretchingCapacity(){
        return this.stretchingCapacity;
    }

    @Override
    public boolean doDraw(Graphics graph, double x, double y, double w){
        return true;
    }

    @Override
    public String toString(){
        return "Space" + super.toString();
    }
}
