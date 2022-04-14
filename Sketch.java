import processing.core.PApplet;
import processing.core.PImage;
/**
 * A program, "Sketch.java", that draws a person with objects circling around them
 * @author G. Lui
 */
public class Sketch extends PApplet {
  // global variables
  float personX = 0;
  float personY = 700;
  float personWidth = 100; 
  float personHeight = 100; 
  int personSpeed = 10;

  float circlingRotation = 1;
	
  // images
  PImage backgroundImage;

	PImage personRight;
  PImage personLeft;
  PImage person;
  PImage Block;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1000, 1000);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    frameRate(60);
    background(0, 0, 0);

    // load images
    backgroundImage = loadImage("Background Image.png");

    personRight = loadImage("Person Right.png");
    personLeft = loadImage("Person Left.png");
    person = personRight;
    Block = loadImage("Block.png");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  image(backgroundImage, 0, 0, width, height);
    personMoving();
    circlingShapes();
  }
  
  // define other methods down here.

  /**
   * Draws the person moves
   * @author G. Lui
   */
  public void personMoving(){

    personX += personSpeed;
    image(person, personX, personY, personWidth, personHeight);

    // right border collision
    if (personX + personWidth >= width){

      personSpeed *= -1;
      person = personLeft;
    }

    // left border collision
    if (personX <= 0){

      personSpeed *= -1;
      person = personRight;
    }  


  }

  /**
   * Draws the circling objects around the person
   * @author G. Lui
   */
  public void circlingShapes(){

    pushMatrix();
    translate(personX + (personWidth / 2) - 10, personY + (personHeight / 2) + 5);
    rotate(radians(circlingRotation));

    stroke(150, 11, 36);
    fill(171, 17, 45);
    ellipse(75, 75, 50, 50);
    image(Block, -115, -115, 50, 50);
    popMatrix();
    circlingRotation += 5;
  }
}