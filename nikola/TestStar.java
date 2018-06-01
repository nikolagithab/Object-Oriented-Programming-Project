///////////////////////////////////////////////////////////////////////////////
// TestStar.java
// =========
// This class has a Main method for the "Star" application.
//
//  AUTHOR: Nikola Petrovski (petrovsn@sheridancollege.ca)
// CREATED: 2018-06-01
// UPDATED: 2018-06-01
///////////////////////////////////////////////////////////////////////////////
package nikola;
import nikola.Vector2;
import nikola.Line;
import nikola.Star;

public class TestStar
{
    public static void main(String[] args)
    {
        // define a default star object
        Star myStar = new Star(10);
        for (int i = 0; i < myStar.vertices.length; i++){
            System.out.println(i + ": " + myStar.vertices[i]);
        }
        
        // array of stars
        Star[] astar = new Star[10];
        astar[0] = new Star();
        
        System.out.println(astar[0].vertices[0].y);
        
        
    }
}
