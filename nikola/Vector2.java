package nikola;

// 1 to create class
public class Vector2{ 
    
//  2  to declare instance variables for dot coordinates
    public float x;
    public float y;
    
//  3a  to define no-arg constructor
    public Vector2(){
        set(0, 0);
    }
    
//  3b  to define constructor with parameters 
    public Vector2(float x, float y){
        set(x, y);
    }
    
//  4b  to define method for initializing the x and y
//setters..this is reg method with void return type 
//to reference the hidden data fields of the object being constructed.
    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }
    
//  4a  
    public void set(Vector2 v){
        set(v.x, v.y);
    }
//override toString()..have to have same elements..
//if not.. then it is a new method!   
    
//  5 to print string
    @Override
    public String toString(){
        return "Vector2(" + x + "," + y + ")";
    }
    
//  6  make copy..deep copy vs shallow copy..
    public Vector2 clone(){
        return new Vector2(x.y);
    }
    
// 7  method for result of vector addition..aritmetics
    public Vector2 add(Vector2 v){
        x += v.x;//to reduce> x = x + v.x
        y += v.y;//singular scallar value!
        return this;//it return itself so you can keep adding.
    }
    
// 8  to subtruct vectors
    public Vector2 subtract(Vector2 v){
        x -= v.x;//
        y -= v.y;//
        return this;//
    }
    
// 9 to multiply scalar with vector
    public Vector2 scale(float scalar){
        //
        return this;//
    }
// 10  dot product
    public float dot(Vector2 v){
        return (x * v.x) + (y * v.y);
    }
    
// 11  math getlength.
    public float getLength() {
        return Math.sqrt(thix.x * this.x + this.y * this.y);
        float d = getLength();//
        x /= d;//
        y /= d;
    }
    
//  12  to make vector with unit length and return result.
    public Vector2 normalize() {
        return new Vector2((this.x/Math.sqrt(x * x + y * y)),
                           (this.y/Math.sqrt(x * x + y * y)));//
    }
    
}


