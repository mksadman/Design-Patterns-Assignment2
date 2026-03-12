package components;

public abstract class WaterSource extends VillageComposite {
    protected String waterType;
    protected int capacity;

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
