package case0.accumulator.container;

import case0.accumulator.DoubleAccumulator;
import factory.AccumulatorContainer;
import factory.interfaces.Compressable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:49 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class ContinuousAccumulatorContainer extends AccumulatorContainer implements Compressable
{
    @NotNull private DoubleAccumulator marketDistance;
    @NotNull private DoubleAccumulator socialDensity;
    @NotNull private DoubleAccumulator factoryDistance;
    @NotNull private DoubleAccumulator warehouseDistance;
    @NotNull private DoubleAccumulator soilCost;

    public ContinuousAccumulatorContainer(@NotNull DoubleAccumulator marketDistance, @NotNull DoubleAccumulator socialDensity, @NotNull DoubleAccumulator factoryDistance, @NotNull DoubleAccumulator warehouseDistance, @NotNull DoubleAccumulator soilCost)
    {
        this.marketDistance = marketDistance;
        this.socialDensity = socialDensity;
        this.factoryDistance = factoryDistance;
        this.warehouseDistance = warehouseDistance;
        this.soilCost = soilCost;
    }

    @Override public void compress()
    {
        this.marketDistance.compress();
        this.socialDensity.compress();
        this.factoryDistance.compress();
        this.warehouseDistance.compress();
        this.soilCost.compress();
    }

    @NotNull public DoubleAccumulator getMarketDistance()
    {
        return this.marketDistance;
    }

    public void setMarketDistance(@NotNull DoubleAccumulator marketDistance)
    {
        this.marketDistance = marketDistance;
    }

    @NotNull public DoubleAccumulator getSocialDensity()
    {
        return this.socialDensity;
    }

    public void setSocialDensity(@NotNull DoubleAccumulator socialDensity)
    {
        this.socialDensity = socialDensity;
    }

    @NotNull public DoubleAccumulator getFactoryDistance()
    {
        return this.factoryDistance;
    }

    public void setFactoryDistance(@NotNull DoubleAccumulator factoryDistance)
    {
        this.factoryDistance = factoryDistance;
    }

    @NotNull public DoubleAccumulator getWarehouseDistance()
    {
        return this.warehouseDistance;
    }

    public void setWarehouseDistance(@NotNull DoubleAccumulator warehouseDistance)
    {
        this.warehouseDistance = warehouseDistance;
    }

    @NotNull public DoubleAccumulator getSoilCost()
    {
        return this.soilCost;
    }

    public void setSoilCost(@NotNull DoubleAccumulator soilCost)
    {
        this.soilCost = soilCost;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("marketDistance", marketDistance)
                .append("socialDensity", socialDensity)
                .append("factoryDistance", factoryDistance)
                .append("warehouseDistance", warehouseDistance)
                .append("soilCost", soilCost)
                .toString();
    }
}
