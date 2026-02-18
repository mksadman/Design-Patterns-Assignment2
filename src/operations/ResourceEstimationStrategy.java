package operations;

import builder.Village;

/**
 * Concrete Strategy for resource estimation using the Visitor pattern.
 */
public class ResourceEstimationStrategy implements OperationStrategy {
    
    @Override
    public String execute(Village village) {
        ResourceEstimationVisitor visitor = new ResourceEstimationVisitor();
        village.accept(visitor);
        return visitor.getResult();
    }

    @Override
    public String getOperationName() {
        return "Resource Estimation";
    }
}
