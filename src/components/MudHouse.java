package components;

import factories.ShapeFactory;

public class MudHouse extends House {

    private static final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    private MudHouse() {
        super("Mud House", "Traditional", "Mud");
        setResourceType("mud");
        setAdditionalCost(100);
        buildStructure();
    }

    public static MudHouse create() {
        return new MudHouse();
    }

    @Override
    protected void buildStructure() {
        add(shapeFactory.createOval("Main Wall", "Brown", 80, "mud", 60));
        add(shapeFactory.createTriangle("Thatched Roof", "Gold", 40, "straw", 40));
        add(shapeFactory.createRectangle("Wooden Door", "Dark Brown", 30, "wood", 8));
        add(shapeFactory.createCircle("Round Window", "Light Blue", 20, "glass", 2));
    }

    @Override
    public void display(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "+ " + getName() + " [" + houseType + " - " + material + "]");
        for (VillageComponent child : getChildren()) {
            child.display(indent + 2);
        }
    }
}
