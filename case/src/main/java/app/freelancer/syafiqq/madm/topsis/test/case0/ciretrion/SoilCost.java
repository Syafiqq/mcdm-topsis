package app.freelancer.syafiqq.madm.topsis.test.case0.ciretrion;

import app.freelancer.syafiqq.madm.topsis.core.factory.Criterion;
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
 * Date / Time  : 13 April 2017, 9:46 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class SoilCost extends Criterion<DoubleAccumulator, DoubleWeight, DoubleProfit>
{
    private final static CriterionType TYPE = CriterionType.COST;

    private double value;
    private double normalized;
    private double profitDistance;
    private double lossDistance;

    public SoilCost(double value)
    {
        this.setValue(value);
        this.setNormalized(0.0);
        this.setProfitDistance(0.0);
        this.setLossDistance(0.0);
    }

    @Override public void collect(@NotNull DoubleAccumulator accumulator)
    {
        final double rootV = FastMath.pow(this.getValue(), 2.0);
        accumulator.setValue(accumulator.getValue() + rootV);
    }

    @Override public void calculate(@NotNull DoubleAccumulator accumulator)
    {
        this.setNormalized(this.getValue() / accumulator.getValue());
    }

    @Override public void normalize(@NotNull DoubleWeight weight)
    {
        this.setNormalized(this.getNormalized() * weight.getValue());
    }

    @Override public void searchProfit(@NotNull DoubleProfit profit)
    {
        switch(SoilCost.TYPE)
        {
            case BENEFIT:
            {
                this.assignMax(profit);
            }
            break;
            case COST:
            {
                this.assignMin(profit);
            }
            break;
        }
    }

    @Override public void searchLoss(@NotNull DoubleProfit profit)
    {
        switch(SoilCost.TYPE)
        {
            case BENEFIT:
            {
                this.assignMin(profit);
            }
            break;
            case COST:
            {
                this.assignMax(profit);
            }
            break;
        }
    }

    @Override public void profitDistance(@NotNull DoubleProfit profit)
    {
        this.setProfitDistance(FastMath.pow(profit.getValue() - this.getNormalized(), 2.0));
    }

    @Override public void lossDistance(@NotNull DoubleProfit profit)
    {
        this.setLossDistance(FastMath.pow(this.getNormalized() - profit.getValue(), 2.0));
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