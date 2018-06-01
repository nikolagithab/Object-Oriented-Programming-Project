package nikola;

//  1  to create line class
public class Line{
    
// 2  instance vavrs
    private Vector2 point = new Vector2();
    private Vector2 direction = new Vector2();
    
// 3d  ctors he will cover 2 out of 2 handout
    public Line(float x1, float y1, float x2, float y2){
        set(x1, y1, x2, y2);
    }
    
// 3c  second contr.. where x = 0 intercept aka (0,b).. 
//DIRECTION at b is slope:
//slope m=rise/run.    run is projection....
//revrite slope in fraction  2=2/1..3/4=3/4/1...0.3=0.3/1  
    public Line(float slope, float intercept){
        set(slope, intercept);
    }
    
// 3b  
    public Line(Vector2 point, Vector2 direction){
        set(point, direction);
    }
    
// 3a  
    public Line(){
        //
    }
    
// 4c  setters..he choose first point..either works
    public void set(float x1, float y1, float x2, float y2){
        point.set(x1, y1);//use vector class inplementation see step 4
        direction.set(x2 - x1, y2 - y1);
    }
    
// 4b  second setter..slope intercept
    public void set(float slope, float intercept){
        point.set(0, intercept);//use 
        direction.set(1, slope); //when move 1, x/y movements
    } 
    
// 5a  convert standard form to parametric form
//because or class uses ;point form..
//abcd are unknown because we do not use coefficients..
//in vector form: P1 + t v==this is line equation.
//extract doe x and y components (you can do it) 
    
    public void setPoint (Vector2 point){
        //
    }
    
// 5b 
    public Vector2 getPoint(){
        //
    }  
    
    
// 6a  
    public void setDirection(Vector2 direction){
        //
    }
// 6b  
    public Vector2 getDirection(){
        //
    }
    
// 7 
    @Override
    public String toString(){
        //return "Line... ===... Point: (xy)  Direction: (xy)";
    }
    
// 8  find intersection point
    public Vector2 intersect(Line line){//choose better name..
        //
        Vector2 point = new Vector2(Float.Nan, Float.Nan, );//parrallel NaN
        //find coefficients   abcdef
        float a = direction.y;//Vy
        float b = -direction.x;//Vx NOTE NEGATIVE
        float c = direction.y * point.x - direction.x * point.y;
        
        float d = line.getDirection().y;//Vy
        float e = -line.getDirection().x;//Vx NOTE NEGATIVE
        float f = line.getDirection.y * line.getPoint.x - 
            line.getDirection.x * line.getPoint.y;//to find all coefficients
        //just plug them in now
        
        
        //find determinant: ae-bd
        float det = a * e - b * d;//evaluate parralel..not different!
        if(det == 0){
// or if(det != 0) > they intersect>> point.x = (c * e - b * f) / det;
//point.y = (a * f - c * d) / det;
            
            return point;//not intersect!   
        }
        
        
// 9  are lines intersecting?
        public boolean isIntersected(Line line){
            //
        }
    }
}