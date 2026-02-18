package operations;

import components.SimpleShape;
import components.VillageComposite;

/**
 * Visitor interface for performing operations on village components.
 * Implements the Visitor pattern to allow different operations without
 * modifying the component classes.
 */
public interface VillageVisitor {
    void visit(VillageComposite composite);
    void visit(SimpleShape shape);
    String getResult();
    void reset();
}
