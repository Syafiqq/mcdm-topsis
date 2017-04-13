package app.freelancer.syafiqq.madm.topsis.test.case0.alternative;

import app.freelancer.syafiqq.madm.topsis.core.factory.Alternative;
import app.freelancer.syafiqq.madm.topsis.test.case0.accumulator.container.ContinuousAccumulatorContainer;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.FactoryDistance;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.MarketDistance;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.SocialDensity;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.SoilCost;
import app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion.WarehouseDistance;
import app.freelancer.syafiqq.madm.topsis.test.case0.profit.DoubleProfit;
import app.freelancer.syafiqq.madm.topsis.test.case0.profit.container.ContinuousProfitContainer;
import app.freelancer.syafiqq.madm.topsis.test.case0.properties.Identity;
import app.freelancer.syafiqq.madm.topsis.test.case0.weight.container.ContinuousWeightContainer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 9:47 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Warehouse extends Alternative<ContinuousAccumulatorContainer, ContinuousWeightContainer, ContinuousProfitContainer>
{
    @NotNull private Identity          properties;
    @NotNull private MarketDistance    marketDistance;
    @NotNull private SocialDensity     socialDensity;
    @NotNull private FactoryDistance   factoryDistance;
    @NotNull private WarehouseDistance warehouseDistance;
    @NotNull private SoilCost          soilCost;
    private          double            value;

    public Warehouse(@NotNull Identity properties, @NotNull MarketDistance marketDistance, @NotNull SocialDensity socialDensity, @NotNull FactoryDistance factoryDistance, @NotNull WarehouseDistance warehouseDistance, @NotNull SoilCost soilCost)
    {
        this.properties = properties;
        this.marketDistance = marketDistance;
        this.socialDensity = socialDensity;
        this.factoryDistance = factoryDistance;
        this.warehouseDistance = warehouseDistance;
        this.soilCost = soilCost;
    }

    @Override public void collectData(@NotNull ContinuousAccumulatorContainer container)
    {
        this.marketDistance.collect(container.getMarketDistance());
        this.socialDensity.collect(container.getSocialDensity());
        this.factoryDistance.collect(container.getFactoryDistance());
        this.warehouseDistance.collect(container.getWarehouseDistance());
        this.soilCost.collect(container.getSoilCost());
    }

    @Override public void calculateDecisionMatrix(@NotNull ContinuousAccumulatorContainer container)
    {
        this.marketDistance.calculate(container.getMarketDistance());
        this.socialDensity.calculate(container.getSocialDensity());
        this.factoryDistance.calculate(container.getFactoryDistance());
        this.warehouseDistance.calculate(container.getWarehouseDistance());
        this.soilCost.calculate(container.getSoilCost());
    }

    @Override public void calculateWeightedDecisionMatrix(@NotNull ContinuousWeightContainer container)
    {
        this.marketDistance.normalize(container.getMarketDistance());
        this.socialDensity.normalize(container.getSocialDensity());
        this.factoryDistance.normalize(container.getFactoryDistance());
        this.warehouseDistance.normalize(container.getWarehouseDistance());
        this.soilCost.normalize(container.getSoilCost());
    }

    @Override public ContinuousProfitContainer adaptWeightedDecisionMatrix()
    {
        return new ContinuousProfitContainer(
                new DoubleProfit(this.marketDistance.getNormalized()),
                new DoubleProfit(this.socialDensity.getNormalized()),
                new DoubleProfit(this.factoryDistance.getNormalized()),
                new DoubleProfit(this.warehouseDistance.getNormalized()),
                new DoubleProfit(this.soilCost.getNormalized())
        );
    }

    @Override public void getProfit(@NotNull ContinuousProfitContainer container)
    {
        this.marketDistance.searchProfit(container.getMarketDistance());
        this.socialDensity.searchProfit(container.getSocialDensity());
        this.factoryDistance.searchProfit(container.getFactoryDistance());
        this.warehouseDistance.searchProfit(container.getWarehouseDistance());
        this.soilCost.searchProfit(container.getSoilCost());
    }

    @Override public void getLoss(@NotNull ContinuousProfitContainer container)
    {
        this.marketDistance.searchLoss(container.getMarketDistance());
        this.socialDensity.searchLoss(container.getSocialDensity());
        this.factoryDistance.searchLoss(container.getFactoryDistance());
        this.warehouseDistance.searchLoss(container.getWarehouseDistance());
        this.soilCost.searchLoss(container.getSoilCost());
    }

    @Override public void calculateProfitDistance(@NotNull ContinuousProfitContainer container)
    {
        this.marketDistance.profitDistance(container.getMarketDistance());
        this.socialDensity.profitDistance(container.getSocialDensity());
        this.factoryDistance.profitDistance(container.getFactoryDistance());
        this.warehouseDistance.profitDistance(container.getWarehouseDistance());
        this.soilCost.profitDistance(container.getSoilCost());
    }

    @Override public void calculateLossDistance(@NotNull ContinuousProfitContainer container)
    {
        this.marketDistance.lossDistance(container.getMarketDistance());
        this.socialDensity.lossDistance(container.getSocialDensity());
        this.factoryDistance.lossDistance(container.getFactoryDistance());
        this.warehouseDistance.lossDistance(container.getWarehouseDistance());
        this.soilCost.lossDistance(container.getSoilCost());
    }

    @Override public void calculatePreferences()
    {
        final double profitDistance = FastMath.sqrt(this.marketDistance.getProfitDistance() +
                this.socialDensity.getProfitDistance() +
                this.factoryDistance.getProfitDistance() +
                this.warehouseDistance.getProfitDistance() +
                this.soilCost.getProfitDistance()
        );

        final double lossDistance = FastMath.sqrt(this.marketDistance.getLossDistance() +
                this.socialDensity.getLossDistance() +
                this.factoryDistance.getLossDistance() +
                this.warehouseDistance.getLossDistance() +
                this.soilCost.getLossDistance()
        );

        this.setValue(lossDistance / (lossDistance + profitDistance));
    }

    @Override public int compareTo(@NotNull Alternative o)
    {
        return -Double.compare(this.getValue(), ((Warehouse) o).getValue());
    }

    public Identity getProperties()
    {
        return this.properties;
    }

    public void setProperties(Identity properties)
    {
        this.properties = properties;
    }

    public MarketDistance getMarketDistance()
    {
        return this.marketDistance;
    }

    public void setMarketDistance(MarketDistance marketDistance)
    {
        this.marketDistance = marketDistance;
    }

    public SocialDensity getSocialDensity()
    {
        return this.socialDensity;
    }

    public void setSocialDensity(SocialDensity socialDensity)
    {
        this.socialDensity = socialDensity;
    }

    public FactoryDistance getFactoryDistance()
    {
        return this.factoryDistance;
    }

    public void setFactoryDistance(FactoryDistance factoryDistance)
    {
        this.factoryDistance = factoryDistance;
    }

    public WarehouseDistance getWarehouseDistance()
    {
        return this.warehouseDistance;
    }

    public void setWarehouseDistance(WarehouseDistance warehouseDistance)
    {
        this.warehouseDistance = warehouseDistance;
    }

    public SoilCost getSoilCost()
    {
        return this.soilCost;
    }

    public void setSoilCost(SoilCost soilCost)
    {
        this.soilCost = soilCost;
    }

    public double getValue()
    {
        return this.value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("properties", properties)
                .append("marketDistance", marketDistance)
                .append("socialDensity", socialDensity)
                .append("factoryDistance", factoryDistance)
                .append("warehouseDistance", warehouseDistance)
                .append("soilCost", soilCost)
                .append("value", value)
                .toString();
    }
}
