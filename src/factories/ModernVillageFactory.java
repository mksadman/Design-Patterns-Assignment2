package factories;

import components.*;

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
