package week1_design_pattern_cts;

public class FactoryMethodExercise {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw() { System.out.println("Drawing a Circle"); }
    }

    static class Square implements Shape {
        public void draw() { System.out.println("Drawing a Square"); }
    }

    static class Triangle implements Shape {
        public void draw() { System.out.println("Drawing a Triangle"); }
    }

    static class ShapeFactory {
        public Shape getShape(String shapeType) {
            if (shapeType == null) return null;
            switch (shapeType.toUpperCase()) {
                case "CIRCLE": return new Circle();
                case "SQUARE": return new Square();
                case "TRIANGLE": return new Triangle();
                default: throw new IllegalArgumentException("Unknown shape: " + shapeType);
            }
        }
    }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        factory.getShape("CIRCLE").draw();
        factory.getShape("SQUARE").draw();
        factory.getShape("TRIANGLE").draw();
    }
}