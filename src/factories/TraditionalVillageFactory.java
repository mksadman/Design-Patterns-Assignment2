package factories;

import components.*;

/**
 * Concrete Factory for creating Traditional Village components.
 * Creates: Mud House, Banana Tree, Pond
 * Uses Singleton pattern to ensure single factory instance.
 */
public class TraditionalVillageFactory implements VillageFactory {
    
    private static TraditionalVillageFactory instance;
    
    TraditionalVillageFactory() {}
    
    public static TraditionalVillageFactory getInstance() {
        if (instance == null) {
            instance = new TraditionalVillageFactory();
        }
        return instance;
    }

    @Override
    public House createHouse() {
        return MudHouse.create();
    }

    @Override
    public Tree createTree() {
        return BananaTree.create();
    }

    @Override
    public WaterSource createWaterSource() {
        return Pond.create();
    }

    @Override
    public String getVillageStyle() {
        return "Traditional Village";
    }
}
