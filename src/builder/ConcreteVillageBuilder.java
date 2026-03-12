package builder;

import components.*;
import factories.BuilderFactory;
import factories.VillageFactory;

public class ConcreteVillageBuilder implements VillageBuilder {
    private Village village;
    private VillageFactory factory;
    private static final BuilderFactory builderFactory = BuilderFactory.getInstance();

    public ConcreteVillageBuilder(VillageFactory factory) {
        this.factory = factory;
        reset();
    }

    @Override
    public void reset() {
        this.village = builderFactory.createVillage("New Village");
        this.village.setVillageStyle(factory.getVillageStyle());
    }

    @Override
    public void setVillageName(String name) {
        Village newVillage = builderFactory.createVillage(name);
        newVillage.setVillageStyle(factory.getVillageStyle());

        for (House house : village.getHouses()) {
            newVillage.addHouse(house);
        }
        for (Tree tree : village.getTrees()) {
            newVillage.addTree(tree);
        }
        for (WaterSource ws : village.getWaterSources()) {
            newVillage.addWaterSource(ws);
        }

        this.village = newVillage;
    }

    @Override
    public void buildHouse() {
        House house = factory.createHouse();
        village.addHouse(house);
    }

    @Override
    public void buildTree() {
        Tree tree = factory.createTree();
        village.addTree(tree);
    }

    @Override
    public void buildWaterSource() {
        WaterSource waterSource = factory.createWaterSource();
        village.addWaterSource(waterSource);
    }

    @Override
    public void addMultipleHouses(int count) {
        for (int i = 0; i < count; i++) {
            buildHouse();
        }
    }

    @Override
    public void addMultipleTrees(int count) {
        for (int i = 0; i < count; i++) {
            buildTree();
        }
    }

    @Override
    public Village getResult() {
        Village result = village;
        reset();
        return result;
    }

    public void setFactory(VillageFactory factory) {
        this.factory = factory;
        reset();
    }
}
