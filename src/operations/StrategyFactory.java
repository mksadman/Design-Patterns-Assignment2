package operations;

/**
 * Factory for creating Strategy objects.
 * Centralizes strategy creation to avoid using 'new' keyword directly.
 */
public class StrategyFactory {
    
    public enum StrategyType {
        COST_CALCULATION, RESOURCE_ESTIMATION, REPORT_GENERATION
    }
    
    private static StrategyFactory instance;
    
    private StrategyFactory() {}
    
    public static StrategyFactory getInstance() {
        if (instance == null) {
            instance = new StrategyFactory();
        }
        return instance;
    }
    
    public OperationStrategy createStrategy(StrategyType type) {
        switch (type) {
            case COST_CALCULATION:
                return new CostCalculationStrategy();
            case RESOURCE_ESTIMATION:
                return new ResourceEstimationStrategy();
            case REPORT_GENERATION:
                return new ReportGenerationStrategy();
            default:
                return new CostCalculationStrategy();
        }
    }
    
    public CostCalculationStrategy createCostCalculationStrategy() {
        return new CostCalculationStrategy();
    }
    
    public ResourceEstimationStrategy createResourceEstimationStrategy() {
        return new ResourceEstimationStrategy();
    }
    
    public ReportGenerationStrategy createReportGenerationStrategy() {
        return new ReportGenerationStrategy();
    }
    
    public VillageOperationContext createOperationContext() {
        return new VillageOperationContext();
    }
    
    public VillageOperationContext createOperationContext(OperationStrategy strategy) {
        return new VillageOperationContext(strategy);
    }
}
