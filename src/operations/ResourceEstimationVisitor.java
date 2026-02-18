package operations;

import components.SimpleShape;
import components.VillageComposite;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete Visitor for estimating resources required to build a village.
 * Collects and aggregates resource requirements from all components.
 */
public class ResourceEstimationVisitor implements VillageVisitor {
    private Map<String, Integer> resourceMap;
    private StringBuilder breakdown;
    private String currentComponent;

    public ResourceEstimationVisitor() {
        reset();
    }

    @Override
    public void reset() {
        resourceMap = new HashMap<>();
        breakdown = new StringBuilder();
        currentComponent = "";
        breakdown.append("=== RESOURCE ESTIMATION REPORT ===\n\n");
    }

    @Override
    public void visit(VillageComposite composite) {
        String name = composite.getName();
        if (name.contains("House") || name.contains("Tree") || 
            name.contains("Pool") || name.contains("Pond")) {
            currentComponent = name;
            breakdown.append("Component: ").append(name).append("\n");
        }
    }

    @Override
    public void visit(SimpleShape shape) {
        String resourceType = shape.getResourceType();
        int amount = shape.getResourceAmount();
        
        // Aggregate resources
        resourceMap.merge(resourceType, amount, Integer::sum);
        
        // Add to breakdown if significant
        if (amount > 0) {
            breakdown.append("  - ").append(shape.getName())
                     .append(" requires ").append(amount)
                     .append(" units of ").append(resourceType).append("\n");
        }
    }

    @Override
    public String getResult() {
        StringBuilder result = new StringBuilder(breakdown);
        result.append("\n").append("=".repeat(50)).append("\n");
        result.append("TOTAL RESOURCE SUMMARY:\n");
        result.append("-".repeat(50)).append("\n");
        
        resourceMap.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> {
                result.append(String.format("%-20s: %,d units%n", 
                    entry.getKey(), entry.getValue()));
            });
        
        result.append("=".repeat(50));
        return result.toString();
    }

    public Map<String, Integer> getResourceMap() {
        return new HashMap<>(resourceMap);
    }
}
