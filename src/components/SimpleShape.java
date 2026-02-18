package components;

import operations.VillageVisitor;

/**
 * Leaf component representing basic shapes.
 * Used as building blocks for houses, trees, and water sources.
 */
public class SimpleShape implements VillageComponent {
    public enum ShapeType {
        RECTANGLE, TRIANGLE, CIRCLE, OVAL, LINE
    }

    private String name;
    private ShapeType shapeType;
    private String color;
    private double cost;
    private String resourceType;
    private int resourceAmount;

    public SimpleShape(String name, ShapeType shapeType, String color, double cost, String resourceType, int resourceAmount) {
        this.name = name;
        this.shapeType = shapeType;
        this.color = color;
        this.cost = cost;
        this.resourceType = resourceType;
        this.resourceAmount = resourceAmount;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "- " + name + " [" + shapeType + ", " + color + "]");
    }

    @Override
    public void accept(VillageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double getBaseCost() {
        return cost;
    }

    @Override
    public String getResourceType() {
        return resourceType;
    }

    @Override
    public int getResourceAmount() {
        return resourceAmount;
    }
}
