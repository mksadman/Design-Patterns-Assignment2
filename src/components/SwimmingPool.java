package components;

import factories.ShapeFactory;

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
        add(shapeFactory.createRectangle("Pool Basin", "Light Blue", 500, "concrete", 200));
        add(shapeFactory.createRectangle("Pool Border", "White", 150, "tiles", 80));
        add(shapeFactory.createLine("Ladder Left Rail", "Silver", 30, "steel", 5));
        add(shapeFactory.createLine("Ladder Right Rail", "Silver", 30, "steel", 5));
        add(shapeFactory.createRectangle("Diving Board", "Blue", 80, "fiberglass", 10));
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
