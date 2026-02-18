package operations;

import builder.Village;

/**
 * Concrete Strategy for report generation using the Visitor pattern.
 */
public class ReportGenerationStrategy implements OperationStrategy {
    
    @Override
    public String execute(Village village) {
        ReportGenerationVisitor visitor = new ReportGenerationVisitor();
        village.accept(visitor);
        return visitor.getResult();
    }

    @Override
    public String getOperationName() {
        return "Report Generation";
    }
}
