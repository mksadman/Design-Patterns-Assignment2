package factories;

import components.House;
import components.Tree;
import components.WaterSource;

/**
 * Abstract Factory interface for creating village components.
 * Provides methods to create families of related objects (house, tree, water source).
 */
public interface VillageFactory {
    House createHouse();
    Tree createTree();
    WaterSource createWaterSource();
    String getVillageStyle();
}
