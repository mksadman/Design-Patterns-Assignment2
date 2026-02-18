package components;

import factories.ShapeFactory;

/**
 * Mango Tree - A tropical fruit tree.
 * Part of the Modern Village combination.
 */
public class MangoTree extends Tree {
    
    private static final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    private MangoTree() {
        super("Mango Tree", "Tropical", "Mango");
        setResourceType("wood");
        setAdditionalCost(50);
        buildStructure();
    }
    
    public static MangoTree create() {
        return new MangoTree();
    }

    @Override
    protected void buildStructure() {
        // Trunk (rectangle)
        add(shapeFactory.createRectangle("Trunk", "Brown", 20, "wood", 15));
        // Main canopy (large circle)
        add(shapeFactory.createCircle("Main Canopy", "Green", 30, "leaves", 30));
        // Secondary canopy (circle)
        add(shapeFactory.createCircle("Secondary Canopy", "Dark Green", 25, "leaves", 25));
        // Mangoes (small circles)
        add(shapeFactory.createCircle("Mango 1", "Yellow", 5, "fruit", 1));
        add(shapeFactory.createCircle("Mango 2", "Orange", 5, "fruit", 1));
        add(shapeFactory.createCircle("Mango 3", "Yellow-Green", 5, "fruit", 1));
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
