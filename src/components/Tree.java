package components;

public abstract class Tree extends VillageComposite {
    protected String treeType;
    protected String fruitType;

    public Tree(String name, String treeType, String fruitType) {
        super(name);
        this.treeType = treeType;
        this.fruitType = fruitType;
    }

    public String getTreeType() {
        return treeType;
    }

    public String getFruitType() {
        return fruitType;
    }

    protected abstract void buildStructure();
}
