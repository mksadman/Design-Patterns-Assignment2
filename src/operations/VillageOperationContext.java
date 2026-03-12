package operations;

import builder.Village;

public class VillageOperationContext {
    private OperationStrategy strategy;

    public VillageOperationContext() {
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
