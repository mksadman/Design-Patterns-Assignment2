package operations;

import builder.Village;

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
