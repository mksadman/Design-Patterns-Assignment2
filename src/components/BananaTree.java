package components;

import factories.ShapeFactory;

/**
 * Banana Tree - A traditional fruit tree/plant.
 * Part of the Traditional Village combination.
 */
public class BananaTree extends Tree {
    
    private static final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    private BananaTree() {
        super("Banana Tree", "Tropical Plant", "Banana");
        setResourceType("plant");
        setAdditionalCost(20);
        buildStructure();
    }
    
    public static BananaTree create() {
        return new BananaTree();
    }

    @Override
    protected void buildStructure() {
        // Trunk/Stem (rectangle)
        add(shapeFactory.createRectangle("Stem", "Light Green", 15, "plant_fiber", 10));
        // Large leaves (ovals)
        add(shapeFactory.createOval("Leaf 1", "Green", 10, "leaves", 5));
        add(shapeFactory.createOval("Leaf 2", "Green", 10, "leaves", 5));
        add(shapeFactory.createOval("Leaf 3", "Dark Green", 10, "leaves", 5));
        add(shapeFactory.createOval("Leaf 4", "Green", 10, "leaves", 5));
        // Banana bunch (oval)
        add(shapeFactory.createOval("Banana Bunch", "Yellow", 8, "fruit", 12));
    }

    @Override
    public void display(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "+ " + getName() + " [" + treeType + " - " + fruitType + "]");
        for (VillageComponent child : getChildren()) {
            child.display(indent + 2);
        }
    }
}
