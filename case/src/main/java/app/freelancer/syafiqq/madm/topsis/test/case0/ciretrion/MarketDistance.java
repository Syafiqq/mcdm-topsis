package app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion;

import app.freelancer.syafiqq.madm.topsis.core.factory.Accumulator;
import app.freelancer.syafiqq.madm.topsis.core.factory.Criterion;
import app.freelancer.syafiqq.madm.topsis.core.factory.Profit;
import app.freelancer.syafiqq.madm.topsis.core.factory.Weight;
import app.freelancer.syafiqq.madm.topsis.test.case0.CriterionType;
import app.freelancer.syafiqq.madm.topsis.test.case0.accumulator.DoubleAccumulator;
import app.freelancer.syafiqq.madm.topsis.test.case0.profit.DoubleProfit;
import app.freelancer.syafiqq.madm.topsis.test.case0.weight.DoubleWeight;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 9:43 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class MarketDistance extends Criterion
{
    private final static CriterionType TYPE = CriterionType.COST;

    private double value;
    private double normalized;
    private double profitDistance;
    private double lossDistance;

    public MarketDistance(double value)
    {
        this.setValue(value);
        this.setNormalized(0.0);
        this.setProfitDistance(0.0);
        this.setLossDistance(0.0);
    }

    @Override public void collect(@NotNull Accumulator accumulator)
    {
        @NotNull DoubleAccumulator _accumulator = (DoubleAccumulator) accumulator;
        final double               rootV        = FastMath.pow(this.getValue(), 2.0);
        _accumulator.setValue(_accumulator.getValue() + rootV);
    }

    @Override public void calculate(@NotNull Accumulator accumulator)
    {
        this.setNormalized(this.getValue() / ((DoubleAccumulator) accumulator).getValue());
    }

    @Override public void normalize(@NotNull Weight weight)
    {
        this.setNormalized(this.getNormalized() * ((DoubleWeight) weight).getValue());
    }

    @Override public void searchProfit(@NotNull Profit profit)
    {
        @NotNull final DoubleProfit _profit = (DoubleProfit) profit;
        switch(MarketDistance.TYPE)
        {
            case BENEFIT:
            {
                this.assignMax(_profit);
            }
            break;
            case COST:
            {
                this.assignMin(_profit);
            }
            break;
        }
    }

    @Override public void searchLoss(@NotNull Profit profit)
    {
        @NotNull final DoubleProfit _profit = (DoubleProfit) profit;
        switch(MarketDistance.TYPE)
        {
            case BENEFIT:
            {
                this.assignMin(_profit);
            }
            break;
            case COST:
            {
                this.assignMax(_profit);
            }
            break;
        }
    }

    @Override public void profitDistance(@NotNull Profit profit)
    {
        this.setProfitDistance(FastMath.pow(((DoubleProfit) profit).getValue() - this.getNormalized(), 2.0));
    }

    @Override public void lossDistance(@NotNull Profit profit)
    {
        this.setLossDistance(FastMath.pow(this.getNormalized() - ((DoubleProfit) profit).getValue(), 2.0));
    }

    private void assignMin(@NotNull DoubleProfit profit)
    {
        profit.setValue(FastMath.min(profit.getValue(), this.getNormalized()));
    }

    private void assignMax(@NotNull DoubleProfit profit)
    {
        profit.setValue(FastMath.max(profit.getValue(), this.getNormalized()));
    }

    public double getValue()
    {
        return this.value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public double getNormalized()
    {
        return this.normalized;
    }

    public void setNormalized(double normalized)
    {
        this.normalized = normalized;
    }

    public double getProfitDistance()
    {
        return this.profitDistance;
    }

    public void setProfitDistance(double profitDistance)
    {
        this.profitDistance = profitDistance;
    }

    public double getLossDistance()
    {
        return this.lossDistance;
    }

    public void setLossDistance(double lossDistance)
    {
        this.lossDistance = lossDistance;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("normalized", normalized)
                .append("profitDistance", profitDistance)
                .append("lossDistance", lossDistance)
                .toString();
    }
}