package case0.profit.container;

import case0.profit.DoubleProfit;
import factory.ProfitContainer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:47 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class ContinuousProfitContainer extends ProfitContainer
{
    @NotNull private DoubleProfit marketDistance;
    @NotNull private DoubleProfit socialDensity;
    @NotNull private DoubleProfit factoryDistance;
    @NotNull private DoubleProfit warehouseDistance;
    @NotNull private DoubleProfit soilCost;

    public ContinuousProfitContainer(@NotNull DoubleProfit marketDistance, @NotNull DoubleProfit socialDensity, @NotNull DoubleProfit factoryDistance, @NotNull DoubleProfit warehouseDistance, @NotNull DoubleProfit soilCost)
    {
        this.marketDistance = marketDistance;
        this.socialDensity = socialDensity;
        this.factoryDistance = factoryDistance;
        this.warehouseDistance = warehouseDistance;
        this.soilCost = soilCost;
    }

    @NotNull public DoubleProfit getMarketDistance()
    {
        return this.marketDistance;
    }

    public void setMarketDistance(@NotNull DoubleProfit marketDistance)
    {
        this.marketDistance = marketDistance;
    }

    @NotNull public DoubleProfit getSocialDensity()
    {
        return this.socialDensity;
    }

    public void setSocialDensity(@NotNull DoubleProfit socialDensity)
    {
        this.socialDensity = socialDensity;
    }

    @NotNull public DoubleProfit getFactoryDistance()
    {
        return this.factoryDistance;
    }

    public void setFactoryDistance(@NotNull DoubleProfit factoryDistance)
    {
        this.factoryDistance = factoryDistance;
    }

    @NotNull public DoubleProfit getWarehouseDistance()
    {
        return this.warehouseDistance;
    }

    public void setWarehouseDistance(@NotNull DoubleProfit warehouseDistance)
    {
        this.warehouseDistance = warehouseDistance;
    }

    @NotNull public DoubleProfit getSoilCost()
    {
        return this.soilCost;
    }

    public void setSoilCost(@NotNull DoubleProfit soilCost)
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
