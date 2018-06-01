
///////////////////////////////////////////////////////////////////////////////
// Vector2.java
// =========
// This class models a vector for the "Star" application.
//
//  AUTHOR: Nikola Petrovski (petrovsn@sheridancollege.ca)
// CREATED: 2017-04-18
// UPDATED: 2017-04-19
///////////////////////////////////////////////////////////////////////////////
package nikola;

// 1 to create class
public class Vector2{ 
    
//  2  to declare instance variables for dot coordinates
    public float x;
    public float y;
    
///////////////////////////////////////////////////////////////////////////////
// CTORS
///////////////////////////////////////////////////////////////////////////////
//  3a  to define no-arg constructor
    public Vector2(){
        set(0, 0);
    }
    
//  3b  to define constructor with parameters 
    public Vector2(float x, float y){
        set(x, y);
    }
    
///////////////////////////////////////////////////////////////////////////////
// METHS
///////////////////////////////////////////////////////////////////////////////
//  4a  
    public void set(Vector2 v){
        set(v.x, v.y);
    }
//  4b
    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }
    
//override toString()..has to have same elements..  
//  5 to print string
    @Override
    public String toString(){
        return "Vector2(" + this.x + "," + this.y + ")";
    }
    
//  6  make copy.
    public Vector2 clone(){
        return new Vector2(this.x, this.y);
    }
    
// 7  method for result of vector addition..aritmetics
    public Vector2 add(Vector2 v){
        this.x += v.x;//to reduce> x = x + v.x
        this.y += v.y;//singular scallar value!
        return this;//it return itself so you can keep adding.
    }
    
// 8  to subtruct vectors
    public Vector2 subtract(Vector2 v){
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }
    
// 9 to multiply scalar with vector
    public Vector2 scale(float scalar){
        this.x *= 2;
        this.y *= 2;
        return this;
    }
// 10  dot product
    public float dot(Vector2 v){
        return (this.x * v.x) + (this.y * v.y);
    }
    
// 11  math getlength.
    public float getLength() {
        return (float)Math.sqrt(thix.x * this.x + this.y * this.y);
    }
    
//  12  to make vector with unit length and return result.
    public Vector2 normalize() {
        float d = getLength();
        x /= d;
        y /= d;
        return this;
    }
    
}


