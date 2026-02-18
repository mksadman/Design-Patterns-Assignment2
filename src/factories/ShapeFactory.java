package factories;

import components.SimpleShape;

/**
 * Factory for creating SimpleShape objects.
 * Centralizes shape creation to avoid using 'new' keyword directly.
 */
public class ShapeFactory {
    
    private static ShapeFactory instance;
    
    private ShapeFactory() {}
    
    public static ShapeFactory getInstance() {
        if (instance == null) {
            instance = new ShapeFactory();
        }
        return instance;
    }
    
    public SimpleShape createShape(String name, SimpleShape.ShapeType shapeType, 
                                   String color, double cost, 
                                   String resourceType, int resourceAmount) {
        return new SimpleShape(name, shapeType, color, cost, resourceType, resourceAmount);
    }
    
    public SimpleShape createRectangle(String name, String color, double cost, 
                                       String resourceType, int resourceAmount) {
        return createShape(name, SimpleShape.ShapeType.RECTANGLE, color, cost, resourceType, resourceAmount);
    }
    
    public SimpleShape createTriangle(String name, String color, double cost,
                                      String resourceType, int resourceAmount) {
        return createShape(name, SimpleShape.ShapeType.TRIANGLE, color, cost, resourceType, resourceAmount);
    }
    
    public SimpleShape createCircle(String name, String color, double cost,
                                    String resourceType, int resourceAmount) {
        return createShape(name, SimpleShape.ShapeType.CIRCLE, color, cost, resourceType, resourceAmount);
    }
    
    public SimpleShape createOval(String name, String color, double cost,
                                  String resourceType, int resourceAmount) {
        return createShape(name, SimpleShape.ShapeType.OVAL, color, cost, resourceType, resourceAmount);
    }
    
    public SimpleShape createLine(String name, String color, double cost,
                                  String resourceType, int resourceAmount) {
        return createShape(name, SimpleShape.ShapeType.LINE, color, cost, resourceType, resourceAmount);
    }
}
