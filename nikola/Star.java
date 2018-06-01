///////////////////////////////////////////////////////////////////////////////
// Star.java
// =========
// This class models a star for the "Star" application.
//
//  AUTHOR: Nikola Petrovski (petrovsn@sheridancollege.ca)
// CREATED: 2018-06-01
// UPDATED: 2018-06-01
///////////////////////////////////////////////////////////////////////////////
package nikola;
public class Star {
    
    final public double D2R = Math.PI / 180;
    
    // instance vars   
    public Vector2[] vertices = new Vector2[10]; 
    public float angle = 72; // angle in degrees
    
///////////////////////////////////////////////////////////////////////////////
// CTORS
///////////////////////////////////////////////////////////////////////////////
    // default star has 5 points and a radius of 10
    public Star(){

        vertices[0] = new Vector2(0.0f, 10.0f);
        
        // calculate outer points
        double D2R = Math.PI / 180;
        float defaultAngle = 72; // angle in degrees
               
        // Outer Points 
        for (int i = 2; i < 10; i+=2) {
             
            // determine angle for calculations
            if (i == 2) {
                angle = defaultAngle;
            } else {
                angle = angle + 72;
            }
                        
            float x = 10 * (float)Math.sin(D2R * angle);
            float y = 10 * (float)Math.cos(D2R * angle);
            Vector2 point = new Vector2(x, y);
            vertices[i] = point;
            
        }
                          
        // inner points    
        Line l1 = new Line(vertices[0].x, vertices[0].y, vertices[4].x, vertices[4].y); // p0 to p4
        Line l2 = new Line(vertices[2].x, vertices[2].y, vertices[8].x, vertices[8].y); // p2 to p8
        vertices[1] = l1.intersect(l2);
  
        Line l3 = new Line(vertices[2].x, vertices[2].y, vertices[6].x, vertices[6].y); // p2 to p6
        vertices[3] = l1.intersect(l3);
        
        Line l4 = new Line(vertices[4].x, vertices[4].y, vertices[8].x, vertices[8].y); // p4 to p8
        vertices[5] = l3.intersect(l4);
      
        Line l5 = new Line(vertices[0].x, vertices[0].y, vertices[6].x, vertices[6].y); // p0 to p6
        vertices[7] = l4.intersect(l5);
      
        vertices[9] = l2.intersect(l5);
        
    }
    
    // 5 point star with set radius
    public Star(float radius){
            
        // top point
        vertices[0] = new Vector2(0.0f, radius);; 

        // calculate outer points
        double D2R = Math.PI / 180;
        float defaultAngle = 360 / 5; // angle in degrees
               
        // Outer Points 
        for (int i = 2; i < vertices.length; i+=2) {
             
            // determine angle for calculations
            if (i == 2) {
                angle = defaultAngle;
            } else {
                angle = angle + defaultAngle;
            }
                        
            float x = radius * (float)Math.sin(D2R * angle);
            float y = radius * (float)Math.cos(D2R * angle);
            Vector2 point = new Vector2(x, y);
            vertices[i] = point;
            
        }
                          
        // inner points  
        
        Line l1 = new Line(vertices[0].x, vertices[0].y, vertices[4].x, vertices[4].y); // p0 to p4
        Line l2 = new Line(vertices[2].x, vertices[2].y, vertices[8].x, vertices[8].y); // p2 to p8
        vertices[1] = l1.intersect(l2);
  
        Line l3 = new Line(vertices[2].x, vertices[2].y, vertices[6].x, vertices[6].y); // p2 to p6
        vertices[3] = l1.intersect(l3);
        
        Line l4 = new Line(vertices[4].x, vertices[4].y, vertices[8].x, vertices[8].y); // p4 to p8
        vertices[5] = l3.intersect(l4);
      
        Line l5 = new Line(vertices[0].x, vertices[0].y, vertices[6].x, vertices[6].y); // p0 to p6
        vertices[7] = l4.intersect(l5);
      
        vertices[9] = l2.intersect(l5);
        
    }
        
///////////////////////////////////////////////////////////////////////////////
// METHS
///////////////////////////////////////////////////////////////////////////////
    // fill in star
    public void fillStar(Vector2 points) {
        
    }
    
    
    
}
