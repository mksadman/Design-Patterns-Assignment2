package operations;

import builder.Village;

/**
 * Context class for the Strategy pattern.
 * Holds a reference to the current strategy and executes it on villages.
 */
public class VillageOperationContext {
    private OperationStrategy strategy;

    public VillageOperationContext() {
        // Default strategy
        this.strategy = new CostCalculationStrategy();
    }

    public VillageOperationContext(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeOperation(Village village) {
        System.out.println("\n>>> Executing Operation: " + strategy.getOperationName() + " <<<\n");
        return strategy.execute(village);
    }

    public void executeAndPrint(Village village) {
        String result = executeOperation(village);
        System.out.println(result);
    }

    public String getCurrentStrategyName() {
        return strategy.getOperationName();
    }
}
