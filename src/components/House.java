package components;

/**
 * Abstract House class - extended by specific house types.
 * Houses are composites containing simple shapes.
 */
public abstract class House extends VillageComposite {
    protected String houseType;
    protected String material;

    public House(String name, String houseType, String material) {
        super(name);
        this.houseType = houseType;
        this.material = material;
    }

    public String getHouseType() {
        return houseType;
    }

    public String getMaterial() {
        return material;
    }

    protected abstract void buildStructure();
}
