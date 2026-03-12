package factories;

import components.*;

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
