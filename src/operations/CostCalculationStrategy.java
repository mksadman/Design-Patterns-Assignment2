package operations;

import builder.Village;

/**
 * Concrete Strategy for cost calculation using the Visitor pattern.
 */
public class CostCalculationStrategy implements OperationStrategy {
    
    @Override
    public String execute(Village village) {
        CostCalculationVisitor visitor = new CostCalculationVisitor();
        village.accept(visitor);
        return visitor.getResult();
    }

    @Override
    public String getOperationName() {
        return "Cost Calculation";
    }
}
