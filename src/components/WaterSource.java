package components;

/**
 * Abstract WaterSource class - extended by specific water source types.
 * Water sources are composites containing simple shapes.
 */
public abstract class WaterSource extends VillageComposite {
    protected String waterType;
    protected int capacity; // in liters

    public WaterSource(String name, String waterType, int capacity) {
        super(name);
        this.waterType = waterType;
        this.capacity = capacity;
    }

    public String getWaterType() {
        return waterType;
    }

    public int getCapacity() {
        return capacity;
    }

    protected abstract void buildStructure();
}
