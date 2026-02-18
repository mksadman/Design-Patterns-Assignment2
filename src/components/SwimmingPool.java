package components;

import factories.ShapeFactory;

/**
 * Swimming Pool - A modern water source.
 * Part of the Modern Village combination.
 */
public class SwimmingPool extends WaterSource {
    
    private static final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    private SwimmingPool() {
        super("Swimming Pool", "Treated Water", 50000);
        setResourceType("concrete");
        setAdditionalCost(1000);
        buildStructure();
    }
    
    public static SwimmingPool create() {
        return new SwimmingPool();
    }

    @Override
    protected void buildStructure() {
        // Pool basin (large rectangle)
        add(shapeFactory.createRectangle("Pool Basin", "Light Blue", 500, "concrete", 200));
        // Pool edge/border (rectangle frame)
        add(shapeFactory.createRectangle("Pool Border", "White", 150, "tiles", 80));
        // Ladder (lines)
        add(shapeFactory.createLine("Ladder Left Rail", "Silver", 30, "steel", 5));
        add(shapeFactory.createLine("Ladder Right Rail", "Silver", 30, "steel", 5));
        // Diving board (rectangle)
        add(shapeFactory.createRectangle("Diving Board", "Blue", 80, "fiberglass", 10));
        // Water (oval representing water surface)
        add(shapeFactory.createOval("Water Surface", "Cyan", 0, "water", 50000));
    }

    @Override
    public void display(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "+ " + getName() + " [" + waterType + ", " + capacity + "L]");
        for (VillageComponent child : getChildren()) {
            child.display(indent + 2);
        }
    }
}
