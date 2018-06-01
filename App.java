///////////////////////////////////////////////////////////////////////////////
// App.java
// =========
// Main application driver for OpenGL application
//
//  AUTHOR: Song Ho Ahn (song.ahn@gmail.com)
// CREATED: 2010-11-18
// UPDATED: 2017-03-24
///////////////////////////////////////////////////////////////////////////////

// imports
import nikola.Line;
import nikola.Vector2;// separate than your package locations..



import java.awt.*;
import java.awt.event.*;
//import java.awt.geom.*;                 // Rectangle2D
import com.jogamp.opengl.*;             // OpenGL
import com.jogamp.opengl.glu.*;         // GLU
import com.jogamp.opengl.fixedfunc.*;   // OpenGL fixed pipeline
import com.jogamp.opengl.awt.*;         // GLCanvas
import com.jogamp.opengl.util.*;        // FPSAnimator
import com.jogamp.opengl.util.awt.*;    // TextRenderer



public class App implements GLEventListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    // constants
    private static final int SCREEN_WIDTH = 512;
    private static final int SCREEN_HEIGHT = 512;
    private static final int FPS = 60;              // frames per second
    private static final float CAMERA_DISTANCE = 20.0f;

    // static vars
    private static GLCanvas canvas;
    private static FPSAnimator animator;
    private static GLU glu;
    private static Frame frame;

    // instance vars //////////////////////////////////////////////////////////
    private int screenWidth;
    private int screenHeight;
    private boolean mouseLeftDown;
    private boolean mouseRightDown;
    private int mouseX;
    private int mouseY;
    private float cameraAngleX;
    private float cameraAngleY;
    private float cameraDistance;

    private float gameTime;     // sec
    private float frameTime;    // sec
    private long  prevTime;     // nano sec

    //@@VARS
    // insert your variables here*********************************
//6.1
    //6.2
    //6.3 here instance array..
    
    private Vector2[] vertices;//infor acout color vertex aka point some renderable infor in 2d or 3d space!
    


    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] args)
    {
        App app = new App();
    }



    ///////////////////////////////////////////////////////////////////////////
    // ctor
    public App()
    {
        System.out.println("Starting Application...");

        init();
        initJOGL();

        // reset timer
        prevTime = System.nanoTime();
        gameTime = frameTime = 0;
    }



    ///////////////////////////////////////////////////////////////////////////
    // initialize
    private void init()
    {
        cameraDistance = CAMERA_DISTANCE;
        cameraAngleX = 0;
        cameraAngleY = 0;

        //degree to rad:
        final float D2R = Math.PI / 180;//for sin and cos..
        
        
        //@@INIT
        // initialize your variables here
    }
//here goes 6.4
    vertices = new Vector2[10];// 5+5 inner outer
    // define 1st pint
    vertices[0] = new Vector2(0,10)//inside array is empty..have to create content object in the empty space.
//define 3rd point
        vertices[2] = new Vector2(10 * Math.sin(D2R*72), 10 * Math.cos(D2R * 72))//sin and cos degree to rad..
vertices[8] = new Vector2(-vertices[2].x, vertices[2].y);
    
    //do all outer points
    
    //for inner how!!!!!!!!!!!!!!!!!!!!
    
    
        
        
        
    ///////////////////////////////////////////////////////////////////////////
    // init Java OpenGL
    private void initJOGL()
    {
        // OpenGL capabilities
        GLCapabilities caps = new GLCapabilities(GLProfile.getDefault());
        caps.setDoubleBuffered(true);
        caps.setHardwareAccelerated(true);

        // create objects
        frame = new Frame("JOGL Application");      // window frame
        canvas = new GLCanvas(caps);                // OpenGL canvas
        animator = new FPSAnimator(canvas, FPS);    // game rendering loop

        // config frame
        frame.add(canvas);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLocation(100, 100);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        frame.setVisible(true);

        // attach event handlers to canvas
        canvas.addGLEventListener(this);
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        canvas.addMouseWheelListener(this);
        canvas.requestFocus();

        // start game loop
        animator.start();

        // debug
        System.out.println("Initialized JOGL.");
    }



    ///////////////////////////////////////////////////////////////////////////
    // terminate app
    public static void exit()
    {
        animator.stop();
        frame.remove(canvas);
        frame.dispose();

        System.out.println("Application is terminated.");
        System.exit(0);
    }



    ///////////////////////////////////////////////////////////////////////////
    // compute frame time in sec
    private float getFrameTime()
    {
        //static long prevTime = System.nanoTime();
        long currTime = System.nanoTime();
        float frameTime = (float)((currTime - prevTime) / 1000000000.0); // nanosec to sec
        prevTime = currTime;
        return frameTime;
    }



    ///////////////////////////////////////////////////////////////////////////
    private void update()
    {
    }



    ///////////////////////////////////////////////////////////////////////////
    // draw a frame
    private void drawFrame(GLAutoDrawable drawable)
    {
        final GL2 gl = drawable.getGL().getGL2();

        // clear screen
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        // tramsform camera
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -cameraDistance);
        gl.glRotatef(cameraAngleX, 1, 0, 0);   // pitch
        gl.glRotatef(cameraAngleY, 0, 1, 0);   // heading

        // draw scene
        drawGrid(gl, 10, 1);
        drawStar(gl);
    }



    ///////////////////////////////////////////////////////////////////////////
    // draw grid on the xy-plane
    ///////////////////////////////////////////////////////////////////////////
    private void drawGrid(GL2 gl, float size, float step)
    {
        gl.glDisable(GLLightingFunc.GL_LIGHTING);
        gl.glDisable(GL.GL_DEPTH_TEST);
        gl.glLineWidth(0.5f);

        gl.glBegin(GL.GL_LINES);

        gl.glColor4f(0.5f, 0.5f, 0.5f, 0.5f);
        for(float i=step; i <= size; i+= step)
        {
            gl.glVertex3f(-size,  i, 0);   // lines parallel to X-axis
            gl.glVertex3f( size,  i, 0);
            gl.glVertex3f(-size, -i, 0);   // lines parallel to X-axis
            gl.glVertex3f( size, -i, 0);

            gl.glVertex3f( i, -size, 0);   // lines parallel to Y-axis
            gl.glVertex3f( i,  size, 0);
            gl.glVertex3f(-i, -size, 0);   // lines parallel to Y-axis
            gl.glVertex3f(-i,  size, 0);
        }

        // x-axis
        gl.glColor4f(1.0f, 0, 0, 0.5f);
        gl.glVertex3f(-size, 0, 0);
        gl.glVertex3f( size, 0, 0);

        // y-axis
        gl.glColor4f(0, 0, 1.0f, 0.5f);
        gl.glVertex3f(0, -size, 0);
        gl.glVertex3f(0,  size, 0);

        gl.glEnd();

        gl.glLineWidth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glEnable(GLLightingFunc.GL_LIGHTING);
    }



    ///////////////////////////////////////////////////////////////////////////
    // draw a star on the xy-plane
    ///////////////////////////////////////////////////////////////////////////
    private void drawStar(GL2 gl)
    {
        //@@DRAW
        // modify the following code to draw lines to connect all 10 points#######

        gl.glDisable(GLLightingFunc.GL_LIGHTING);
        gl.glDisable(GL.GL_DEPTH_TEST);

        // draw lines
        gl.glLineWidth(3.0f);
        gl.glColor4f(0.3f, 0.5f, 1.0f, 1.0f);
        gl.glBegin(GL.GL_LINES);

        // line 1
        gl.glVertex2f(0, 10);
        gl.glVertex2f(8, -8);

        // line 2
        gl.glVertex2f( 8, -8);
        gl.glVertex2f(-8, -8);

        // line 3
        gl.glVertex2f(-8, -8);
        gl.glVertex2f( 0, 10);

        gl.glEnd();

        // draw points
        gl.glPointSize(10);
        gl.glColor3f(1, 0.5f, 0);
        gl.glBegin(gl.GL_POINTS);

        gl.glVertex2f( 0, 10);  // point 1
        gl.glVertex2f( 8, -8);  // point 2
        gl.glVertex2f(-8, -8);  // point 3

        gl.glEnd();

        gl.glLineWidth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glEnable(GLLightingFunc.GL_LIGHTING);
    }



    ///////////////////////////////////////////////////////////////////////////
    // Methods for the implementation of GLEventListener
    ///////////////////////////////////////////////////////////////////////////
    public void init(GLAutoDrawable drawable)
    {
        ((Component)drawable).addKeyListener(this);

        // init OpenGL
        GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h)
    {
        GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();

        screenWidth = w;
        screenHeight = h;

        gl.glViewport(0, 0, w, h);

        // set viewing frustum
        gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60.0f, (float)(w)/h, 1.0f, 1000.0f); // FOV, AspectRatio, NearClip, FarClip

        gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable)
    {
        // get frameTime
        frameTime = getFrameTime();
        gameTime += frameTime;

        drawFrame(drawable);
    }

    public void dispose(GLAutoDrawable gLDrawable)
    {
    }



    ///////////////////////////////////////////////////////////////////////////
    // KeyListener events
    ///////////////////////////////////////////////////////////////////////////
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            // exit program
            case KeyEvent.VK_ESCAPE:
                System.out.println("Escape key is pressed. Exiting Application...");
                exit();
                break;

            // reset camera
            case KeyEvent.VK_R:
                cameraDistance = CAMERA_DISTANCE;
                cameraAngleX = cameraAngleY = 0;
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Space key is down.");
                break;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_SPACE:
                System.out.println("Space key is up.");
                break;
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }



    ///////////////////////////////////////////////////////////////////////////
    // MouseListener events
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            mouseLeftDown = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3)
        {
            mouseRightDown = true;
        }
        // keep track of mouse position
        mouseX = e.getX();
        mouseY = e.getY();
        //System.out.println("Mouse Down at: (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            mouseLeftDown = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3)
        {
            mouseRightDown = false;
        }
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }



    ///////////////////////////////////////////////////////////////////////////
    // MouseMotionListener events
    public void mouseDragged(MouseEvent e)
    {
        final float SCALE = 0.5f;

        // update camera angles
        if(mouseLeftDown)
        {
            cameraAngleY += (e.getX() - mouseX) * SCALE;
            cameraAngleX += (e.getY() - mouseY) * SCALE;
            mouseX = e.getX();
            mouseY = e.getY();
        }
        // update camera distance
        else if(mouseRightDown)
        {
            cameraDistance -= (e.getY() - mouseY) * SCALE;
            mouseY = e.getY();
        }
    }

    public void mouseMoved(MouseEvent e)
    {
    }



    ///////////////////////////////////////////////////////////////////////////
    // MouseWheelListener events
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        final float SCALE = 0.5f;
        cameraDistance -= e.getWheelRotation() * SCALE;
    }
}
