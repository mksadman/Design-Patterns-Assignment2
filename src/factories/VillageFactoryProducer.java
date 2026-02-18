package factories;

/**
 * Factory Producer for creating VillageFactory instances.
 * Uses Factory Method pattern to return the appropriate factory.
 */
public class VillageFactoryProducer {
    
    public enum VillageType {
        MODERN, TRADITIONAL
    }
    
    private static VillageFactoryProducer instance;
    
    private VillageFactoryProducer() {}
    
    public static VillageFactoryProducer getInstance() {
        if (instance == null) {
            instance = new VillageFactoryProducer();
        }
        return instance;
    }
    
    public VillageFactory getFactory(VillageType type) {
        switch (type) {
            case MODERN:
                return ModernVillageFactory.getInstance();
            case TRADITIONAL:
                return TraditionalVillageFactory.getInstance();
            default:
                return ModernVillageFactory.getInstance();
        }
    }
    
    public VillageFactory getFactory(int choice) {
        if (choice == 2) {
            return TraditionalVillageFactory.getInstance();
        }
        return ModernVillageFactory.getInstance();
    }
}
