//Programmer: Kiet Quan
//Program Description: Program randomly generates 100 points randomly ranging from [0,100). It then find and print the closest pair of points and the distance between the points. It then calculates and outputs running time of
//divide-and-conquer algorithm.
import java.util.*;

class Point implements Comparable<Point>{
	public double x;
	public double y;

	public int compareTo (Point point){			
		if (this.x > point.x) {
			return 1;
		}
		else if (this.x < point.x) {
			return -1;
		}
		else if (this.y > point.y) {
			return 1;
		}
		else if (this.y < point.y){
			return -1;
		}
		else {
			return 0;
		}
	}
}

class CompareY implements Comparator<Point>{
	public int compare (Point point1, Point point2) {	
		if (point1.y > point2.y) {
			return 1;
		}
		else if (point1.y < point2.y) {
			return -1;
		}
		else if (point1.x > point2.x) {
			return 1;
		}
		else if (point1.x < point2.x){
			return -1;
		}
		else {
			return 0;
		}
	}
}

class Pair{
	Point p1;
	Point p2;
	
	Pair(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	public double getDistance() {
		return Math.sqrt((p1.x -p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
	}
	public void printPoint() {
		 System.out.println("The shortest distance is " + this.getDistance() + " between the points" + " (" + this.p1.x + ", " + this.p1.y +") and (" + this.p2.x + ", " + this.p2.y + ")");
	}
}
public class FindClosestPairOfPoints {
	public static Pair findClosestPair(Point[] points) {
		Arrays.sort(points);
		CompareY temp = new CompareY();
		Point[] pointsOrderedOnY = points.clone();
		Arrays.sort(pointsOrderedOnY, temp);
		return Helper (points, pointsOrderedOnY, 0, points.length -1);
	}
	
	public static Pair Helper(Point[] points, Point[] pointsOrderedOnY, int low, int high) {
		
		if (low >= high) return null;
		else if (low + 1 == high) {
			return new Pair (points[high], points[low]);
		}
		int mid = (high+low)/2;
		Pair closest1 = Helper(points, pointsOrderedOnY, low, mid);
		Pair closest2 = Helper(points, pointsOrderedOnY, mid+1, high);
		double d = 0;
		Pair p = null;
		if (closest1 == null && closest2 == null) {
            d = 0;
            p = null;

        } else if (closest1 == null) {
            d = closest2.getDistance();
            p = closest2;
        } else if (closest2 == null) {
            d = closest1.getDistance();
            p = closest1;
        } else {

            d = Math.min(closest1.getDistance(), closest2.getDistance());

            if (closest1.getDistance() <= closest2.getDistance()) {
                p = closest1;
            } else {
                p = closest2;
            }

        }
		
		ArrayList<Point> stripL = new ArrayList<>();
		ArrayList<Point> stripR = new ArrayList<>();
		for (int i = 0; i < pointsOrderedOnY.length; i++){
			if (pointsOrderedOnY[i].x <= points[mid].x && points[mid].x - pointsOrderedOnY[i].x <= d) {
				stripL.add(pointsOrderedOnY[i]);
			}
			if (pointsOrderedOnY[i].x > points[mid].x && pointsOrderedOnY[i].x - points[mid].x <= d) {
				stripR.add(pointsOrderedOnY[i]);
			}
		}
		
		int r = 0;
		for(int i = 0; i < stripL.size(); i++) {
			while (r < stripR.size() && stripR.get(r).y <= stripL.get(i).y - d) {
				r++;
			}
			
			int r1 = r;
			while(r1 < stripR.size() && Math.abs(stripR.get(r1).y-stripL.get(i).y) <= d) {
				if (distance(stripL.get(i), stripR.get(r1)) < d) {
					d = distance(stripL.get(i), stripR.get(r1));
					p.p1 = stripL.get(i);
					p.p2 = stripR.get(r1);
				}
				r1 = r1 + 1;
			}
			
		}
		return p;
		
		}
	
	public static double distance (Point p1, Point p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
	}
	
	
	public static void main(String[] args) {
		Point[] points = new Point[100];
		
		
		for (int i = 0; i < 100; i++) {
			Point temp = new Point();
			temp.x = Math.random()*100;
			temp.y = Math.random()*100;
			points[i] = temp;
		}
		long startTime = System.currentTimeMillis();
		Pair closestPair = findClosestPair(points);
		long endTime = System.currentTimeMillis();
		closestPair.printPoint();
		long duration = endTime - startTime;
		System.out.println("Time spent on the divide-and-conquer algorithm is " + duration + " milliseconds.");
	}
}
