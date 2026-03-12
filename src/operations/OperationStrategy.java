package operations;

import builder.Village;

public interface OperationStrategy {
    String execute(Village village);
    String getOperationName();
}
