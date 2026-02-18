package components;

import factories.ShapeFactory;

/**
 * Pond - A natural water source.
 * Part of the Traditional Village combination.
 */
public class Pond extends WaterSource {
    
    private static final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    private Pond() {
        super("Pond", "Natural Water", 20000);
        setResourceType("natural");
        setAdditionalCost(50);
        buildStructure();
    }
    
    public static Pond create() {
        return new Pond();
    }

    @Override
    protected void buildStructure() {
        // Pond shape (oval)
        add(shapeFactory.createOval("Pond Basin", "Dark Blue", 30, "earth", 50));
        // Water (oval)
        add(shapeFactory.createOval("Water Body", "Blue", 0, "water", 20000));
        // Rocks around edge (circles)
        add(shapeFactory.createCircle("Rock 1", "Gray", 5, "stone", 3));
        add(shapeFactory.createCircle("Rock 2", "Dark Gray", 5, "stone", 3));
        add(shapeFactory.createCircle("Rock 3", "Gray", 5, "stone", 3));
        // Lily pad (circle)
        add(shapeFactory.createCircle("Lily Pad", "Green", 2, "plant", 1));
        // Lotus flower (circle)
        add(shapeFactory.createCircle("Lotus Flower", "Pink", 3, "plant", 1));
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
