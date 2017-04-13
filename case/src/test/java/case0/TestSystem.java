package case0;

import case0.accumulator.container.ContinuousAccumulatorContainer;
import case0.alternative.Warehouse;
import case0.weight.container.ContinuousWeightContainer;
import factory.TOPSIS;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 10:14 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class TestSystem
{
    @Test public void it_success()
    {
        @NotNull Warehouse a1 = FactoryHelper.createWarehouse("a1", 0.75, 2000, 18, 50, 500);
        @NotNull Warehouse a2 = FactoryHelper.createWarehouse("a2", 0.50, 1500, 20, 40, 450);
        @NotNull Warehouse a3 = FactoryHelper.createWarehouse("a3", 0.90, 2050, 35, 35, 800);

        @NotNull ContinuousAccumulatorContainer cac = FactoryHelper.createAccumulatorContainer(0.0, 0.0, 0.0, 0.0, 0.0);
        @NotNull ContinuousWeightContainer      w   = FactoryHelper.createWeightContainer(5, 3, 4, 4, 2);

        TOPSIS wp = new TOPSIS();
        wp.addAlternative(a1);
        wp.addAlternative(a2);
        wp.addAlternative(a3);

        wp.setDecisionMatrixAccumulator(cac);
        wp.setWeight(w);

        wp.compile();
        wp.calculate();
        wp.ranking();
        wp.sort();

        System.out.println(wp.getBestAlternative());
    }
}
