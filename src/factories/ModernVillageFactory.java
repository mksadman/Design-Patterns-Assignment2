package factories;

import components.*;

/**
 * Concrete Factory for creating Modern Village components.
 * Creates: Brick House, Mango Tree, Swimming Pool
 * Uses Singleton pattern to ensure single factory instance.
 */
public class ModernVillageFactory implements VillageFactory {
    
    private static ModernVillageFactory instance;
    
    ModernVillageFactory() {}
    
    public static ModernVillageFactory getInstance() {
        if (instance == null) {
            instance = new ModernVillageFactory();
        }
        return instance;
    }

    @Override
    public House createHouse() {
        return BrickHouse.create();
    }

    @Override
    public Tree createTree() {
        return MangoTree.create();
    }

    @Override
    public WaterSource createWaterSource() {
        return SwimmingPool.create();
    }

    @Override
    public String getVillageStyle() {
        return "Modern Village";
    }
}
