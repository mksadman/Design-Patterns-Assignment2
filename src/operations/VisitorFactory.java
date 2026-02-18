package operations;

/**
 * Factory for creating Visitor objects.
 * Centralizes visitor creation to avoid using 'new' keyword directly.
 */
public class VisitorFactory {
    
    public enum VisitorType {
        COST_CALCULATION, RESOURCE_ESTIMATION, REPORT_GENERATION
    }
    
    private static VisitorFactory instance;
    
    private VisitorFactory() {}
    
    public static VisitorFactory getInstance() {
        if (instance == null) {
            instance = new VisitorFactory();
        }
        return instance;
    }
    
    public VillageVisitor createVisitor(VisitorType type) {
        switch (type) {
            case COST_CALCULATION:
                return new CostCalculationVisitor();
            case RESOURCE_ESTIMATION:
                return new ResourceEstimationVisitor();
            case REPORT_GENERATION:
                return new ReportGenerationVisitor();
            default:
                return new CostCalculationVisitor();
        }
    }
    
    public CostCalculationVisitor createCostCalculationVisitor() {
        return new CostCalculationVisitor();
    }
    
    public ResourceEstimationVisitor createResourceEstimationVisitor() {
        return new ResourceEstimationVisitor();
    }
    
    public ReportGenerationVisitor createReportGenerationVisitor() {
        return new ReportGenerationVisitor();
    }
}
