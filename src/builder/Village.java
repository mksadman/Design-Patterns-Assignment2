package builder;

import components.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Product class representing a complete Village.
 * Contains houses, trees, and water sources as a composite structure.
 */
public class Village extends VillageComposite {
    private String villageName;
    private String villageStyle;
    private List<House> houses;
    private List<Tree> trees;
    private List<WaterSource> waterSources;

    public Village(String name) {
        super(name);
        this.villageName = name;
        this.houses = new ArrayList<>();
        this.trees = new ArrayList<>();
        this.waterSources = new ArrayList<>();
    }

    public void setVillageStyle(String style) {
        this.villageStyle = style;
    }

    public String getVillageStyle() {
        return villageStyle;
    }

    public void addHouse(House house) {
        houses.add(house);
        add(house);
    }

    public void addTree(Tree tree) {
        trees.add(tree);
        add(tree);
    }

    public void addWaterSource(WaterSource waterSource) {
        waterSources.add(waterSource);
        add(waterSource);
    }

    public List<House> getHouses() {
        return houses;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public List<WaterSource> getWaterSources() {
        return waterSources;
    }

    public int getTotalComponents() {
        return houses.size() + trees.size() + waterSources.size();
    }

    @Override
    public void display(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "=== " + villageName + " (" + villageStyle + ") ===");
        System.out.println(padding + "Houses: " + houses.size() + ", Trees: " + trees.size() + ", Water Sources: " + waterSources.size());
        System.out.println(padding + "Components:");
        for (VillageComponent child : getChildren()) {
            child.display(indent + 2);
        }
    }

    public String getVillageName() {
        return villageName;
    }
}
