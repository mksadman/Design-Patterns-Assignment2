package factories;

import builder.*;

/**
 * Factory for creating Builder and Director objects.
 * Centralizes builder creation to avoid using 'new' keyword directly.
 */
public class BuilderFactory {
    
    private static BuilderFactory instance;
    
    private BuilderFactory() {}
    
    public static BuilderFactory getInstance() {
        if (instance == null) {
            instance = new BuilderFactory();
        }
        return instance;
    }
    
    public VillageBuilder createBuilder(VillageFactory factory) {
        return new ConcreteVillageBuilder(factory);
    }
    
    public VillageDirector createDirector(VillageBuilder builder) {
        return new VillageDirector(builder);
    }
    
    public Village createVillage(String name) {
        return new Village(name);
    }
}
