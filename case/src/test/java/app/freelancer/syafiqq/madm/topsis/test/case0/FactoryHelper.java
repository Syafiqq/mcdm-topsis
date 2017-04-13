package app.freelancer.syafiqq.madm.topsis.test.case0;

import app.freelancer.syafiqq.madm.topsis.test.case0.accumulator.DoubleAccumulator;
import app.freelancer.syafiqq.madm.topsis.test.case0.accumulator.container.ContinuousAccumulatorContainer;
import app.freelancer.syafiqq.madm.topsis.test.case0.alternative.Warehouse;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.FactoryDistance;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.MarketDistance;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.SocialDensity;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.SoilCost;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.WarehouseDistance;
import app.freelancer.syafiqq.madm.topsis.test.case0.properties.Identity;
import app.freelancer.syafiqq.madm.topsis.test.case0.weight.DoubleWeight;
import app.freelancer.syafiqq.madm.topsis.test.case0.weight.container.ContinuousWeightContainer;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 10:13 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class FactoryHelper
{
    public static Warehouse createWarehouse(String name, double marketDistance, double socialDensity, double factoryDistance, double warehouseDistance, double soilCost)
    {
        return new Warehouse(
                new Identity(name),
                new MarketDistance(marketDistance),
                new SocialDensity(socialDensity),
                new FactoryDistance(factoryDistance),
                new WarehouseDistance(warehouseDistance),
                new SoilCost(soilCost)
        );
    }

    public static ContinuousWeightContainer createWeightContainer(double marketDistance, double socialDensity, double factoryDistance, double warehouseDistance, double soilCost)
    {
        return new ContinuousWeightContainer(
                new DoubleWeight(marketDistance),
                new DoubleWeight(socialDensity),
                new DoubleWeight(factoryDistance),
                new DoubleWeight(warehouseDistance),
                new DoubleWeight(soilCost)
        );
    }

    public static ContinuousAccumulatorContainer createAccumulatorContainer(double marketDistance, double socialDensity, double factoryDistance, double warehouseDistance, double soilCost)
    {
        return new ContinuousAccumulatorContainer(
                new DoubleAccumulator(marketDistance),
                new DoubleAccumulator(socialDensity),
                new DoubleAccumulator(factoryDistance),
                new DoubleAccumulator(warehouseDistance),
                new DoubleAccumulator(soilCost)
        );
    }
}
