package operations;

import components.SimpleShape;
import components.VillageComposite;

public interface VillageVisitor {
    void visit(VillageComposite composite);
    void visit(SimpleShape shape);
    String getResult();
    void reset();
}
