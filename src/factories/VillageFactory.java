package factories;

import components.House;
import components.Tree;
import components.WaterSource;

public interface VillageFactory {
    House createHouse();
    Tree createTree();
    WaterSource createWaterSource();
    String getVillageStyle();
}
