package components;

import operations.VillageVisitor;

public interface VillageComponent {
    String getName();
    void display(int indent);
    void accept(VillageVisitor visitor);
    double getBaseCost();
    String getResourceType();
    int getResourceAmount();
}
