package typo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;

import javax.swing.plaf.FontUIResource;

import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

public class Glyph extends Box {

    final private static FontRenderContext frc = new FontRenderContext(null, false, false);

    final private Font font;
    final private char[] chars;
    final private Rectangle2D bounds;

    public Glyph(Font font, char c){
        chars = new char[1];
        chars[0] = c;
        this.font = font;
        TextLayout layout = new TextLayout("" + chars[0], font, frc);
        bounds = layout.getBounds();
    }

    public double getStretchingCapacity() {
        return 0;
    }

    public double getWidth(){
        return  bounds.getWidth();
    }
    public double getAscent(){
        return - bounds.getY();
    }
    public double getDescent(){
        return bounds.getHeight() + bounds.getY();
    }

    @Override
    public boolean doDraw(Graphics graph, double x, double y, double w){
        graph.setFont(font);
        graph.drawChars(chars, 0, chars.length, (int)(x - bounds.getX()), (int) (y - bounds.getY()));
        return true;
    }

    @Override
    public String toString() {
        return String.format("Glyph(%s)", chars[0]) + super.toString();
    }
    
}
