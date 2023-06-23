import java.util.*;

/*Programmer: Kiet Quan
 * Program Description: Program takes input from user for three sides of a triangle. If the input data can 
 * create a triangle, takes user input for the color and filled status of the triangle. Program calculates and 
 * prints out Area, Perimeter, Color and filled status of triangle. Also print a rectangle and a circle based on
 * pre-set values without user input.
 * Date: 02/06/2022
 */

public class TestGeometricObjects {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double side1, side2, side3;
		String color;
		Boolean filled;
		
		System.out.print("Please enter the sides of a triangle: "); 					//scan user input for 3 sides.
		side1 = scanner.nextDouble();
		side2 = scanner.nextDouble();
		side3 = scanner.nextDouble();
		while(side1 + side2 < side3 || side2 + side3 < side1 || side1+ side3 < side2) { //validation loop.
			System.out.println("Unable to create a triangle with those sides.");
			System.out.println();
			System.out.print("Please enter the sides of a triangle: ");
			side1 = scanner.nextDouble();
			side2 = scanner.nextDouble();
			side3 = scanner.nextDouble();
		}
		System.out.print("What is the color of the triangle: "); 						//scan user input for color.
		color = scanner.next();
		System.out.print("Is the triangle filled(true/false)?: "); 						//scan user input for filled status.
		filled = scanner.nextBoolean();
		System.out.println();
		
		Triangle tri = new Triangle (side1, side2, side3, color, filled); 				//create object tri with the inputed data. 
		System.out.println("Triangle");
		tri.print(); 																	//print object stats
		System.out.println();
		
		Circle cir = new Circle(); 														//create object cir with no inputed data
		System.out.println("Circle");
		cir.print(); 																	//print object stats
		System.out.println();
		
		Rectangle rec = new Rectangle(); 												//create object rec with no inputed data
		System.out.println("Rectangle");
		rec.print(); 																	//print object stats
		System.out.println();
		
		scanner.close();
	}
	
	
}

 abstract class GeometricObject {
	  private String color = "white";
	  private boolean filled;
	  private java.util.Date dateCreated;
	  /** Construct a default geometric object */
	  protected GeometricObject() {
	    dateCreated = new java.util.Date();
	  }
	  /** Construct a geometric object with color and filled value */
	  protected GeometricObject(String color, boolean filled) {
	    dateCreated = new java.util.Date();
	    this.color = color;
	    this.filled = filled;
	  }
	  /** Return color */
	  public String getColor() {
	    return color;
	  }
	  /** Set a new color */
	  public void setColor(String color) {
	    this.color = color;
	  }
	  /** Return filled. Since filled is boolean,
	   *  the get method is named isFilled */
	  public boolean isFilled() {
	    return filled;
	  }
	  /** Set a new filled */
	  public void setFilled(boolean filled) {
	    this.filled = filled;
	  }
	  /** Get dateCreated */
	  public java.util.Date getDateCreated() {
	    return dateCreated;
	  }
	  /** Return a string representation of this object */
	  public String toString() {
	    return "created on " + dateCreated + "\ncolor: " + color +
	      " and filled: " + filled;
	  }
	  /** Abstract method getArea */
	  public abstract double getArea();
	  /** Abstract method getPerimeter */
	  public abstract double getPerimeter();
	  
	  public void print() {															    //method to print object stats								
		    System.out.println("Area: " + this.getArea());		
		    System.out.println("Perimeter: " + this.getPerimeter());
		    System.out.println("Color: " + this.getColor());
		    System.out.println("Filled: " + this.isFilled());
	  }
	}
 
 	class Triangle extends GeometricObject {
		private double side1, side2, side3;
		
		public Triangle (double side1, double side2, double side3, String color, Boolean filled) {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
			this.setColor(color);
			this.setFilled(filled);
		}
		public double getArea() {
			double halfP = (side1 + side2 + side3)/2;
			return Math.sqrt(halfP*(halfP-side1)*(halfP-side2)*(halfP-side3)); 			//return area of triangle 
		}
		
		public double getPerimeter() {
			return side1 + side2 + side3;												//return perimeter of triangle
		}
		
		public double getSide1() {
			return side1;
		}
		
		public double getSide2() {
			return side2;
		}
		
		public double getSide3() {
			return side3;
		}
		
	}
 	
 	class Circle extends GeometricObject {												
 		  private double radius;

 		  public Circle() {																//default constructor
 			  this.radius = 2;
 			  this.setColor("yellow");
 			  this.setFilled(true);
 		  }
 		  

 		  public Circle(double radius) {
 		    this.radius = radius;
 		  }
 		  
 		  public Circle(double radius, String color, Boolean filled) {
 			  this.radius = radius;
 			  this.setColor(color);
 			  this.setFilled(filled);
 		  }

 		  /** Return radius */
 		  public double getRadius() {
 		    return radius;
 		  }

 		  /** Set a new radius */
 		  public void setRadius(double radius) {
 		    this.radius = radius;
 		  }

 		   /** Return area */
 		  public double getArea() {
 		    return radius * radius * Math.PI;
 		  }

 		  /** Return diameter */
 		  public double getDiameter() {
 		    return 2 * radius;
 		  }

 		  /** Return perimeter */
 		  public double getPerimeter() {
 		    return 2 * radius * Math.PI;
 		  }

 		  /* Print the circle info */
 		  public void printCircle() {
 			 System.out.println("The circle is created " + getDateCreated() +
 				      " and the radius is " + radius);
 		  }
 	}
 	
 	 class Rectangle extends GeometricObject {
 		  private double width;
 		  private double height;

 		  public Rectangle() {															//default constructor
 			  this.width = 4;
 			  this.height = 2;
 			  this.setColor("red");
 			  this.setFilled(false);
 		  }

 		  public Rectangle(double width, double height) {
 		    this.width = width;
 		    this.height = height;
 		  }

 		  /** Return width */
 		  public double getWidth() {
 		    return width;
 		  }

 		  /** Set a new width */
 		  public void setWidth(double width) {
 		    this.width = width;
 		  }

 		  /** Return height */
 		  public double getHeight() {
 		    return height;
 		  }

 		  /** Set a new height */
 		  public void setHeight(double height) {
 		    this.height = height;
 		  }

 		  /** Return area */
 		  public double getArea() {
 		    return width * height;
 		  }

 		  /** Return perimeter */
 		  public double getPerimeter() {
 		    return 2 * (width + height);
 		  }
 		  
 		}