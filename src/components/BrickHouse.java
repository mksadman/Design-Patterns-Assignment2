package components;

import factories.ShapeFactory;

/**
 * Brick House - A modern house made of bricks.
 * Part of the Modern Village combination.
 */
public class BrickHouse extends House {
    
    private static final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    private BrickHouse() {
        super("Brick House", "Modern", "Brick");
        setResourceType("brick");
        setAdditionalCost(500);
        buildStructure();
    }
    
    public static BrickHouse create() {
        return new BrickHouse();
    }

    @Override
    protected void buildStructure() {
        // Main body (rectangle)
        add(shapeFactory.createRectangle("Main Wall", "Red", 200, "brick", 100));
        // Roof (triangle)
        add(shapeFactory.createTriangle("Roof", "Brown", 150, "tiles", 50));
        // Door (rectangle)
        add(shapeFactory.createRectangle("Door", "Dark Brown", 75, "wood", 10));
        // Windows (rectangles)
        add(shapeFactory.createRectangle("Left Window", "Light Blue", 50, "glass", 5));
        add(shapeFactory.createRectangle("Right Window", "Light Blue", 50, "glass", 5));
        // Chimney (rectangle)
        add(shapeFactory.createRectangle("Chimney", "Gray", 80, "brick", 20));
    }

    @Override
    public void display(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "+ " + getName() + " [" + houseType + " - " + material + "]");
        for (VillageComponent child : getChildren()) {
            child.display(indent + 2);
        }
    }
}
