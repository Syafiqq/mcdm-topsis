package case0.weight;

import factory.Weight;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:45 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class DoubleWeight extends Weight
{
    private double value;

    public DoubleWeight(double value)
    {
        this.value = value;
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
                .append("value", value)
                .toString();
    }
}
