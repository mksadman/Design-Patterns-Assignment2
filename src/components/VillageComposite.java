package components;

import operations.VillageVisitor;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite class that can contain other VillageComponents.
 * Used for hierarchical structures like houses containing shapes.
 */
public class VillageComposite implements VillageComponent {
    private String name;
    private List<VillageComponent> children;
    private double additionalCost;
    private String resourceType;
    private int resourceAmount;

    public VillageComposite(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.additionalCost = 0;
        this.resourceType = "mixed";
        this.resourceAmount = 0;
    }

    public void add(VillageComponent component) {
        children.add(component);
    }

    public void remove(VillageComponent component) {
        children.remove(component);
    }

    public List<VillageComponent> getChildren() {
        return children;
    }

    public void setAdditionalCost(double cost) {
        this.additionalCost = cost;
    }

    public void setResourceType(String type) {
        this.resourceType = type;
    }

    public void setResourceAmount(int amount) {
        this.resourceAmount = amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "+ " + name);
        for (VillageComponent child : children) {
            child.display(indent + 2);
        }
    }

    @Override
    public void accept(VillageVisitor visitor) {
        visitor.visit(this);
        for (VillageComponent child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public double getBaseCost() {
        double totalCost = additionalCost;
        for (VillageComponent child : children) {
            totalCost += child.getBaseCost();
        }
        return totalCost;
    }

    @Override
    public String getResourceType() {
        return resourceType;
    }

    @Override
    public int getResourceAmount() {
        int total = resourceAmount;
        for (VillageComponent child : children) {
            total += child.getResourceAmount();
        }
        return total;
    }
}
