import java.util.Scanner;

public class CircleWithException {
    private double radius;

    public CircleWithException(double radius) {
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    public double getArea() throws Exception {

        double area = Math.PI * radius * radius;
        if (area > 1000) {
            throw new Exception("Area must be less than 1000.");
        }
        return area;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter radius for circle: ");
            double radius = input.nextDouble();
            CircleWithException circle = new CircleWithException(radius);
            System.out.print("Area for circle is: " + circle.getArea());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
