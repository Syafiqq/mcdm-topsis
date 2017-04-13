package app.freelancer.syafiqq.madm.topsis.test.case0.weight.container;

import app.freelancer.syafiqq.madm.topsis.core.factory.WeightContainer;
import app.freelancer.syafiqq.madm.topsis.test.case0.weight.DoubleWeight;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:44 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class ContinuousWeightContainer extends WeightContainer
{
    @NotNull private DoubleWeight marketDistance;
    @NotNull private DoubleWeight socialDensity;
    @NotNull private DoubleWeight factoryDistance;
    @NotNull private DoubleWeight warehouseDistance;
    @NotNull private DoubleWeight soilCost;

    public ContinuousWeightContainer(@NotNull DoubleWeight marketDistance, @NotNull DoubleWeight socialDensity, @NotNull DoubleWeight factoryDistance, @NotNull DoubleWeight warehouseDistance, @NotNull DoubleWeight soilCost)
    {
        this.marketDistance = marketDistance;
        this.socialDensity = socialDensity;
        this.factoryDistance = factoryDistance;
        this.warehouseDistance = warehouseDistance;
        this.soilCost = soilCost;
    }

    @NotNull public DoubleWeight getMarketDistance()
    {
        return this.marketDistance;
    }

    public void setMarketDistance(@NotNull DoubleWeight marketDistance)
    {
        this.marketDistance = marketDistance;
    }

    @NotNull public DoubleWeight getSocialDensity()
    {
        return this.socialDensity;
    }

    public void setSocialDensity(@NotNull DoubleWeight socialDensity)
    {
        this.socialDensity = socialDensity;
    }

    @NotNull public DoubleWeight getFactoryDistance()
    {
        return this.factoryDistance;
    }

    public void setFactoryDistance(@NotNull DoubleWeight factoryDistance)
    {
        this.factoryDistance = factoryDistance;
    }

    @NotNull public DoubleWeight getWarehouseDistance()
    {
        return this.warehouseDistance;
    }

    public void setWarehouseDistance(@NotNull DoubleWeight warehouseDistance)
    {
        this.warehouseDistance = warehouseDistance;
    }

    @NotNull public DoubleWeight getSoilCost()
    {
        return this.soilCost;
    }

    public void setSoilCost(@NotNull DoubleWeight soilCost)
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
