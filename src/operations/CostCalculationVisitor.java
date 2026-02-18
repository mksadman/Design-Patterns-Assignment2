package operations;

import components.SimpleShape;
import components.VillageComposite;

/**
 * Concrete Visitor for calculating the total cost of a village.
 * Traverses all components and sums up their costs.
 */
public class CostCalculationVisitor implements VillageVisitor {
    private double totalCost;
    private StringBuilder breakdown;
    private int indent;

    public CostCalculationVisitor() {
        reset();
    }

    @Override
    public void reset() {
        totalCost = 0;
        breakdown = new StringBuilder();
        indent = 0;
        breakdown.append("=== COST CALCULATION REPORT ===\n\n");
    }

    @Override
    public void visit(VillageComposite composite) {
        String padding = "  ".repeat(indent);
        String name = composite.getName();
        
        // Only add breakdown entry for main components (not sub-components)
        if (name.contains("Village") || name.contains("House") || 
            name.contains("Tree") || name.contains("Pool") || name.contains("Pond")) {
            breakdown.append(padding).append("+ ").append(name).append("\n");
        }
        indent++;
    }

    @Override
    public void visit(SimpleShape shape) {
        String padding = "  ".repeat(indent);
        double cost = shape.getBaseCost();
        totalCost += cost;
        breakdown.append(padding).append("- ").append(shape.getName())
                 .append(": $").append(String.format("%.2f", cost)).append("\n");
    }

    @Override
    public String getResult() {
        StringBuilder result = new StringBuilder(breakdown);
        result.append("\n").append("=".repeat(40)).append("\n");
        result.append("TOTAL COST: $").append(String.format("%.2f", totalCost)).append("\n");
        result.append("=".repeat(40));
        return result.toString();
    }

    public double getTotalCost() {
        return totalCost;
    }
}
