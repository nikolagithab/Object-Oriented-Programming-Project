///////////////////////////////////////////////////////////////////////////////
// Line.java
// =========
// This class models a line for the "Star" application.
//
//  AUTHOR: Nikola Petrovski (petrovsn@sheridancollege.ca)
// CREATED: 2017-04-18
// UPDATED: 2017-04-19
///////////////////////////////////////////////////////////////////////////////
package nikola;

//  1  to create line class
public class Line{
    
// 2  instance vavrs
    private Vector2 point = new Vector2();
    private Vector2 direction = new Vector2();

///////////////////////////////////////////////////////////////////////////////
// CTORS
///////////////////////////////////////////////////////////////////////////////
// 3a  
    public Line(){
        point.x = 0.0f;
        point.y = 0.0f;
        direction.x = 1.0f;
        direction.y = 1.0f;
    }
// 3b  
    public Line(Vector2 point, Vector2 direction){
        this.point = point;
        this.direction = direction;
    }
// 3c 
    public Line(float slope, float intercept){
        point.x = 0;
        point.y = intercept;
        direction.x = 1;
        direction.y = intercept + slope;
    }
// 3d
    public Line(float x1, float y1, float x2, float y2){
        Vector2 v1 = new Vector2(x1, y1);
        Vector2 v2 = new Vector2(x2, y2);
        this.point = v1;
        this.direction = v2;
    }
    

///////////////////////////////////////////////////////////////////////////////
// METHS
///////////////////////////////////////////////////////////////////////////////
// 4a  setter.
    public void set(Vector2 point, Vector2 direction){
        this.point = point;
        this.direction = direction;
    }
// 4b  setter.
    public void set(float slope, float intercept){
        this.point.x = 0;
        this.point.y = intercept;
        this.direction.x = 1;
        this.direction.y = intercept + slope;
    }
// 4c  setter.
    public void set(float x1, float y1, float x2, float y2){
        this.point.x = x1;
        this.point.y = y1;
        this.direction.x = x2;
        this.direction.y = y2;
    }
    
// 5a  vector form and line equation.
    public void setPoint (Vector2 point){
        this.point = point;
    }
// 5b 
    public Vector2 getPoint(){
        return this.point;
    }  
     
// 6a  
    public void setDirection(Vector2 direction){
        this.direction = direction;
    }
// 6b  
    public Vector2 getDirection(){
        return this.direction;
    }
    
// 7 
    @Override
    public String toString(){
        String lineParameters = "Line\n" + "====\n" + "Point: (" + this.point.x + ", " + this.point.y + ")\n" + "Direction: (" + this.direction.x + ", " + this.direction.y + ")";
        return lineParameters;
    }
    
// 8  find intersection point
    public Vector2 intersect(Line line){//choose better name..
        Vector2 intersectPoint = new Vector2(); 
        if (this.isIntersected(line)){
            // define vars for standard equation
            float c = (this.direction.y - this.point.y)*this.point.x - (this.direction.x - this.point.x)*this.point.y; 
            float a = direction.y - point.y;
            float b = point.x - direction.x;
            // line 2
            float f = (line.direction.y - line.point.y)*line.point.x - (line.direction.x - line.point.x)*line.point.y; ;
            float d = line.direction.y - line.point.y;
            float e = line.point.x - line.direction.x;
            
            intersectPoint.x = (c*e - b*f) / (a*e - b*d);
            intersectPoint.y = (a*f - c*d) / (a*e - b*d);
                        
        } else {
            intersectPoint.x = Float.NaN;
            intersectPoint.y = Float.NaN;
        }
        return intersectPoint;   
        }
        
        
// 9  are lines intersecting?
        public boolean isIntersected(Line line){
            // define vars for standard equation
            // line 1
            float c = (this.direction.y - this.point.y)*this.point.x - (this.direction.x - this.point.x)*this.point.y; 
            float a = this.direction.y - this.point.y;
            float b = this.direction.x - this.point.x;
                
            // line2
            float f = (line.direction.y - line.point.y)*line.point.x - (line.direction.x - line.point.x)*line.point.y; ;
            float d = line.direction.y - line.point.y;
            float e = line.direction.x - line.point.x;
        
            if ((a*e - b*d) == 0){
                return false;
            } else {
                return true;
        }
        }
    }
}
