package app.freelancer.syafiqq.madm.topsis.test.case0.alternative;

import app.freelancer.syafiqq.madm.topsis.core.factory.AccumulatorContainer;
import app.freelancer.syafiqq.madm.topsis.core.factory.Alternative;
import app.freelancer.syafiqq.madm.topsis.core.factory.ProfitContainer;
import app.freelancer.syafiqq.madm.topsis.core.factory.WeightContainer;
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
public class Warehouse extends Alternative
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

    @Override public void collectData(@NotNull AccumulatorContainer container)
    {
        @NotNull final ContinuousAccumulatorContainer _container = (ContinuousAccumulatorContainer) container;
        this.marketDistance.collect(_container.getMarketDistance());
        this.socialDensity.collect(_container.getSocialDensity());
        this.factoryDistance.collect(_container.getFactoryDistance());
        this.warehouseDistance.collect(_container.getWarehouseDistance());
        this.soilCost.collect(_container.getSoilCost());
    }

    @Override public void calculateDecisionMatrix(@NotNull AccumulatorContainer container)
    {
        @NotNull final ContinuousAccumulatorContainer _container = (ContinuousAccumulatorContainer) container;
        this.marketDistance.calculate(_container.getMarketDistance());
        this.socialDensity.calculate(_container.getSocialDensity());
        this.factoryDistance.calculate(_container.getFactoryDistance());
        this.warehouseDistance.calculate(_container.getWarehouseDistance());
        this.soilCost.calculate(_container.getSoilCost());
    }

    @Override public void calculateWeightedDecisionMatrix(@NotNull WeightContainer container)
    {
        @NotNull final ContinuousWeightContainer _container = (ContinuousWeightContainer) container;
        this.marketDistance.normalize(_container.getMarketDistance());
        this.socialDensity.normalize(_container.getSocialDensity());
        this.factoryDistance.normalize(_container.getFactoryDistance());
        this.warehouseDistance.normalize(_container.getWarehouseDistance());
        this.soilCost.normalize(_container.getSoilCost());
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

    @Override public void getProfit(@NotNull ProfitContainer container)
    {
        @NotNull final ContinuousProfitContainer _container = (ContinuousProfitContainer) container;
        this.marketDistance.searchProfit(_container.getMarketDistance());
        this.socialDensity.searchProfit(_container.getSocialDensity());
        this.factoryDistance.searchProfit(_container.getFactoryDistance());
        this.warehouseDistance.searchProfit(_container.getWarehouseDistance());
        this.soilCost.searchProfit(_container.getSoilCost());
    }

    @Override public void getLoss(@NotNull ProfitContainer container)
    {
        @NotNull final ContinuousProfitContainer _container = (ContinuousProfitContainer) container;
        this.marketDistance.searchLoss(_container.getMarketDistance());
        this.socialDensity.searchLoss(_container.getSocialDensity());
        this.factoryDistance.searchLoss(_container.getFactoryDistance());
        this.warehouseDistance.searchLoss(_container.getWarehouseDistance());
        this.soilCost.searchLoss(_container.getSoilCost());
    }

    @Override public void calculateProfitDistance(@NotNull ProfitContainer container)
    {
        @NotNull final ContinuousProfitContainer _container = (ContinuousProfitContainer) container;
        this.marketDistance.profitDistance(_container.getMarketDistance());
        this.socialDensity.profitDistance(_container.getSocialDensity());
        this.factoryDistance.profitDistance(_container.getFactoryDistance());
        this.warehouseDistance.profitDistance(_container.getWarehouseDistance());
        this.soilCost.profitDistance(_container.getSoilCost());
    }

    @Override public void calculateLossDistance(@NotNull ProfitContainer container)
    {
        @NotNull final ContinuousProfitContainer _container = (ContinuousProfitContainer) container;
        this.marketDistance.lossDistance(_container.getMarketDistance());
        this.socialDensity.lossDistance(_container.getSocialDensity());
        this.factoryDistance.lossDistance(_container.getFactoryDistance());
        this.warehouseDistance.lossDistance(_container.getWarehouseDistance());
        this.soilCost.lossDistance(_container.getSoilCost());
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
