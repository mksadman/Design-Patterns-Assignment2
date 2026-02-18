package builder;

import components.*;

/**
 * Builder interface for constructing villages step by step.
 */
public interface VillageBuilder {
    void reset();
    void setVillageName(String name);
    void buildHouse();
    void buildTree();
    void buildWaterSource();
    void addMultipleHouses(int count);
    void addMultipleTrees(int count);
    Village getResult();
}
