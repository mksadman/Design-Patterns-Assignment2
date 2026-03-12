package builder;

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
