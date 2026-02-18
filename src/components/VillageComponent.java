package components;

import operations.VillageVisitor;

/**
 * Component interface for the Composite pattern.
 * Represents any component that can be part of a village.
 */
public interface VillageComponent {
    String getName();
    void display(int indent);
    void accept(VillageVisitor visitor);
    double getBaseCost();
    String getResourceType();
    int getResourceAmount();
}
