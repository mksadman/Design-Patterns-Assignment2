package builder;

import factories.VillageFactory;

/**
 * Director class that orchestrates the building process.
 * Defines different village configurations.
 */
public class VillageDirector {
    private VillageBuilder builder;

    public VillageDirector(VillageBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(VillageBuilder builder) {
        this.builder = builder;
    }

    /**
     * Constructs a small village with minimal components.
     * 1 house, 2 trees, 1 water source
     */
    public Village constructSmallVillage(String name) {
        builder.reset();
        builder.setVillageName(name);
        builder.buildHouse();
        builder.buildTree();
        builder.buildTree();
        builder.buildWaterSource();
        return builder.getResult();
    }

    /**
     * Constructs a medium village with moderate components.
     * 3 houses, 5 trees, 1 water source
     */
    public Village constructMediumVillage(String name) {
        builder.reset();
        builder.setVillageName(name);
        builder.addMultipleHouses(3);
        builder.addMultipleTrees(5);
        builder.buildWaterSource();
        return builder.getResult();
    }

    /**
     * Constructs a large village with many components.
     * 5 houses, 10 trees, 2 water sources
     */
    public Village constructLargeVillage(String name) {
        builder.reset();
        builder.setVillageName(name);
        builder.addMultipleHouses(5);
        builder.addMultipleTrees(10);
        builder.buildWaterSource();
        builder.buildWaterSource();
        return builder.getResult();
    }

    /**
     * Constructs a custom village with specified components.
     */
    public Village constructCustomVillage(String name, int houses, int trees, int waterSources) {
        builder.reset();
        builder.setVillageName(name);
        builder.addMultipleHouses(houses);
        builder.addMultipleTrees(trees);
        for (int i = 0; i < waterSources; i++) {
            builder.buildWaterSource();
        }
        return builder.getResult();
    }
}
