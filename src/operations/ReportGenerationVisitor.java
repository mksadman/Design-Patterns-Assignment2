package operations;

import components.SimpleShape;
import components.VillageComposite;
import components.House;
import components.Tree;
import components.WaterSource;

/**
 * Concrete Visitor for generating a comprehensive report of a village.
 * Creates a detailed summary of the village structure and statistics.
 */
public class ReportGenerationVisitor implements VillageVisitor {
    private StringBuilder report;
    private int componentCount;
    private int shapeCount;
    private int houseCount;
    private int treeCount;
    private int waterSourceCount;
    private String villageName;
    private String villageStyle;
    private int indent;

    public ReportGenerationVisitor() {
        reset();
    }

    @Override
    public void reset() {
        report = new StringBuilder();
        componentCount = 0;
        shapeCount = 0;
        houseCount = 0;
        treeCount = 0;
        waterSourceCount = 0;
        villageName = "Unknown";
        villageStyle = "Unknown";
        indent = 0;
    }

    @Override
    public void visit(VillageComposite composite) {
        String name = composite.getName();
        String padding = "  ".repeat(indent);

        if (name.contains("Village")) {
            villageName = name;
            if (composite instanceof builder.Village) {
                villageStyle = ((builder.Village) composite).getVillageStyle();
            }
        } else if (composite instanceof House) {
            houseCount++;
            componentCount++;
            House house = (House) composite;
            report.append(padding).append("[HOUSE] ").append(name)
                  .append(" (").append(house.getHouseType()).append(" - ")
                  .append(house.getMaterial()).append(")\n");
        } else if (composite instanceof Tree) {
            treeCount++;
            componentCount++;
            Tree tree = (Tree) composite;
            report.append(padding).append("[TREE] ").append(name)
                  .append(" (").append(tree.getTreeType()).append(" - ")
                  .append(tree.getFruitType()).append(")\n");
        } else if (composite instanceof WaterSource) {
            waterSourceCount++;
            componentCount++;
            WaterSource ws = (WaterSource) composite;
            report.append(padding).append("[WATER] ").append(name)
                  .append(" (").append(ws.getWaterType()).append(" - ")
                  .append(ws.getCapacity()).append("L)\n");
        }
        indent++;
    }

    @Override
    public void visit(SimpleShape shape) {
        shapeCount++;
        String padding = "  ".repeat(indent);
        report.append(padding).append("* ").append(shape.getName())
              .append(" [").append(shape.getShapeType())
              .append(", ").append(shape.getColor()).append("]\n");
    }

    @Override
    public String getResult() {
        StringBuilder result = new StringBuilder();
        result.append("VILLAGE REPORT\n");
        result.append("==============\n\n");
        
        result.append("Village Name: ").append(villageName).append("\n");
        result.append("Village Style: ").append(villageStyle).append("\n\n");
        
        result.append("STATISTICS\n");
        result.append("----------\n");
        result.append("Total Main Components: ").append(componentCount).append("\n");
        result.append("  - Houses: ").append(houseCount).append("\n");
        result.append("  - Trees: ").append(treeCount).append("\n");
        result.append("  - Water Sources: ").append(waterSourceCount).append("\n");
        result.append("Total Shapes Used: ").append(shapeCount).append("\n\n");
        
        result.append("COMPONENT DETAILS\n");
        result.append("-----------------\n");
        result.append(report.toString());
        
        return result.toString();
    }
}
