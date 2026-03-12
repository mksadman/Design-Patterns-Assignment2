import builder.*;
import factories.*;
import operations.*;
import java.util.Scanner;

public class Main {

    private static final VillageFactoryProducer factoryProducer = VillageFactoryProducer.getInstance();
    private static final BuilderFactory builderFactory = BuilderFactory.getInstance();
    private static final VisitorFactory visitorFactory = VisitorFactory.getInstance();
    private static final StrategyFactory strategyFactory = StrategyFactory.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO AGE OF VILLAGERS (AoV)");
        System.out.println("Build Your Dream Village from Different Eras!");
        System.out.println();

        demonstrateAllPatterns();

        System.out.println("\nInteractive Mode");
        System.out.println("----------------");

        Village userVillage = interactiveVillageCreation(scanner);

        if (userVillage != null) {
            performOperationsInteractively(scanner, userVillage);
        }

        System.out.println("\nThank you for playing Age of Villagers!");
        scanner.close();
    }

    private static void demonstrateAllPatterns() {
        System.out.println("DEMONSTRATION: All Design Patterns in Action");
        System.out.println("--------------------------------------------");

        System.out.println("\n1. ABSTRACT FACTORY PATTERN");
        System.out.println("Creating two factory types for different village styles...\n");

        VillageFactory modernFactory = factoryProducer.getFactory(VillageFactoryProducer.VillageType.MODERN);
        VillageFactory traditionalFactory = factoryProducer.getFactory(VillageFactoryProducer.VillageType.TRADITIONAL);

        System.out.println("Modern Factory creates: " + modernFactory.getVillageStyle());
        System.out.println("  - House: " + modernFactory.createHouse().getName());
        System.out.println("  - Tree: " + modernFactory.createTree().getName());
        System.out.println("  - Water Source: " + modernFactory.createWaterSource().getName());

        System.out.println("\nTraditional Factory creates: " + traditionalFactory.getVillageStyle());
        System.out.println("  - House: " + traditionalFactory.createHouse().getName());
        System.out.println("  - Tree: " + traditionalFactory.createTree().getName());
        System.out.println("  - Water Source: " + traditionalFactory.createWaterSource().getName());

        System.out.println("\n2. BUILDER PATTERN");
        System.out.println("Using Director to construct villages with different configurations...\n");

        VillageBuilder modernBuilder = builderFactory.createBuilder(modernFactory);
        VillageDirector director = builderFactory.createDirector(modernBuilder);

        Village modernVillage = director.constructSmallVillage("Sunrise Modern Town");
        System.out.println("Built: " + modernVillage.getVillageName() + " (" + modernVillage.getVillageStyle() + ")");
        System.out.println("Components: " + modernVillage.getTotalComponents());

        VillageBuilder traditionalBuilder = builderFactory.createBuilder(traditionalFactory);
        director.setBuilder(traditionalBuilder);

        Village traditionalVillage = director.constructMediumVillage("Heritage Village");
        System.out.println("\nBuilt: " + traditionalVillage.getVillageName() + " (" + traditionalVillage.getVillageStyle() + ")");
        System.out.println("Components: " + traditionalVillage.getTotalComponents());

        System.out.println("\n3. COMPOSITE PATTERN");
        System.out.println("Displaying hierarchical structure of Modern Village...\n");

        modernVillage.display(0);

        System.out.println("\n4. VISITOR PATTERN");
        System.out.println("Applying different visitors to calculate costs and resources...\n");

        CostCalculationVisitor costVisitor = visitorFactory.createCostCalculationVisitor();
        modernVillage.accept(costVisitor);
        System.out.println("Cost Visitor Result:");
        System.out.println(costVisitor.getResult());

        System.out.println();
        ResourceEstimationVisitor resourceVisitor = visitorFactory.createResourceEstimationVisitor();
        traditionalVillage.accept(resourceVisitor);
        System.out.println("Resource Visitor Result for Traditional Village:");
        System.out.println(resourceVisitor.getResult());

        System.out.println("\n5. STRATEGY PATTERN");
        System.out.println("Switching between different operation strategies...\n");

        VillageOperationContext context = strategyFactory.createOperationContext();

        context.setStrategy(strategyFactory.createCostCalculationStrategy());
        System.out.println("Current Strategy: " + context.getCurrentStrategyName());

        context.setStrategy(strategyFactory.createResourceEstimationStrategy());
        System.out.println("Switched to: " + context.getCurrentStrategyName());

        context.setStrategy(strategyFactory.createReportGenerationStrategy());
        System.out.println("Switched to: " + context.getCurrentStrategyName());
        context.executeAndPrint(modernVillage);
    }

    private static Village interactiveVillageCreation(Scanner scanner) {
        System.out.println("\nCreate Your Own Village\n");

        System.out.println("Choose your village style:");
        System.out.println("1. Modern Village (Brick House, Mango Tree, Swimming Pool)");
        System.out.println("2. Traditional Village (Mud House, Banana Tree, Pond)");
        System.out.print("Enter choice (1 or 2): ");

        int styleChoice;
        try {
            styleChoice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            styleChoice = 1;
        }

        VillageFactory factory = factoryProducer.getFactory(styleChoice);

        System.out.print("\nEnter your village name: ");
        String villageName = scanner.nextLine().trim();
        if (villageName.isEmpty()) {
            villageName = "My Village";
        }

        System.out.println("\nChoose village size:");
        System.out.println("1. Small (1 house, 2 trees, 1 water source)");
        System.out.println("2. Medium (3 houses, 5 trees, 1 water source)");
        System.out.println("3. Large (5 houses, 10 trees, 2 water sources)");
        System.out.println("4. Custom");
        System.out.print("Enter choice (1-4): ");

        int sizeChoice;
        try {
            sizeChoice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            sizeChoice = 1;
        }

        VillageBuilder builder = builderFactory.createBuilder(factory);
        VillageDirector director = builderFactory.createDirector(builder);
        Village village;

        switch (sizeChoice) {
            case 2:
                village = director.constructMediumVillage(villageName);
                break;
            case 3:
                village = director.constructLargeVillage(villageName);
                break;
            case 4:
                System.out.print("Number of houses: ");
                int houses = parseIntSafe(scanner.nextLine(), 1);
                System.out.print("Number of trees: ");
                int trees = parseIntSafe(scanner.nextLine(), 1);
                System.out.print("Number of water sources: ");
                int waterSources = parseIntSafe(scanner.nextLine(), 1);
                village = director.constructCustomVillage(villageName, houses, trees, waterSources);
                break;
            default:
                village = director.constructSmallVillage(villageName);
        }

        System.out.println("\nVillage created successfully!");
        System.out.println("\nYour Village Structure:");
        village.display(0);

        return village;
    }

    private static void performOperationsInteractively(Scanner scanner, Village village) {
        VillageOperationContext context = strategyFactory.createOperationContext();

        while (true) {
            System.out.println("\nVillage Operations:");
            System.out.println("1. Calculate Total Cost");
            System.out.println("2. Estimate Resources");
            System.out.println("3. Generate Full Report");
            System.out.println("4. Display Village Structure");
            System.out.println("5. Exit");
            System.out.print("Choose operation (1-5): ");

            int opChoice;
            try {
                opChoice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opChoice = 0;
            }

            switch (opChoice) {
                case 1:
                    context.setStrategy(strategyFactory.createCostCalculationStrategy());
                    context.executeAndPrint(village);
                    break;
                case 2:
                    context.setStrategy(strategyFactory.createResourceEstimationStrategy());
                    context.executeAndPrint(village);
                    break;
                case 3:
                    context.setStrategy(strategyFactory.createReportGenerationStrategy());
                    context.executeAndPrint(village);
                    break;
                case 4:
                    System.out.println("\nVillage Structure:");
                    village.display(0);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int parseIntSafe(String input, int defaultValue) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
