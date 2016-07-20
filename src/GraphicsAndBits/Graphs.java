/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicsAndBits;

/**
 *
 * @author M
 */
public class Graphs {
    
    /*Write a function that draws the upper eighth of a circle centered at (0, 0) with a given
    radius, where the upper eighth is defined as the portion starting at 12 and going to
    1:30 on a clock face. Use the following prototype:
    void drawEighthOfCircle( int radius );
    The coordinate system and an example of what you are to draw are shown in
    Figure 11-1. You will use a function with the following prototype to draw pixels:
    void setPixel( int xCoord, int yCoord ); */
    void drawEighthOfCircle( int radius ){
        int x = 0;
        int y = radius;
        while(x < y){
            y = (int)(Math.sqrt(Math.pow(radius,2)-Math.pow(x,2))+.5); //To round better
            setPixel (x,y);
            x++;
        }
    }
    
    void setPixel( int xCoord, int yCoord ){}
    
    /* You are given two rectangles, each defined by an upper left (UL) corner and a lower
    right (LR) corner. Both rectangles’ edges will always be parallel to the x or y axis, as
    shown in Figure 11-2. Write a function that determines whether the two rectangles
    overlap. The method should take two Rect objects and return true if they overlap, false if
    they don’t.*/
    public boolean overlap(Rect r1, Rect r2){
        int x1Left = r1.ul.x; //left
        int x1Right = r1.lr.x; //right
        int y1Up = r1.ul.y; //up
        int y1Low = r1.lr.y; //low
        int x2Left = r2.ul.x; //left
        int x2Right = r2.lr.x; //right
        int y2Up = r2.ul.y; //up
        int y2Low = r2.lr.y; //low
        if(y1Up < y2Low ||
           y1Low > y2Up ||
           x1Right < x2Left ||
           x1Left > x2Right)
            return false;
        return true;
    }
    
    /* No considera el caso en el que ninguna esquina este adentro //
    Point[] r2coord  = new Point[4];
        // 0           1
        // 3           2 
        r2coord[0] = r2.ul;
        r2coord[1] = new Point(r2.lr.x, r2.ul.y);
        r2coord[2] = r2.lr;
        r2coord[3] = new Point(r2.ul.x, r2.lr.y);
        
        for (int i=0; i<4; i++){
            Point p = r2coord[i];
            if(p.x>xLeft && p.x<xRight && p.y>yLow  && p.y < yUp)
                return true;
        }
        return false;
    */
    
}
