package typo;

import java.awt.Graphics;

public class TestableGroup extends Group{
    TestableGroup(){
        ascent = 0;
        descent = 0;
        width = 0;
        stretchingCapacity = 0;
    }

    @Override
    public boolean doDraw(Graphics graph, double x, double y, double w) {
        return true;
    }
}
