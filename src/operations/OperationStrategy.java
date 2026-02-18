package operations;

import builder.Village;

/**
 * Strategy interface for performing operations on villages.
 * Allows interchangeable algorithms for different operations.
 */
public interface OperationStrategy {
    String execute(Village village);
    String getOperationName();
}
