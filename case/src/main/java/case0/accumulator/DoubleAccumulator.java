package case0.accumulator;

import factory.Accumulator;
import factory.interfaces.Compressable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:51 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class DoubleAccumulator extends Accumulator implements Compressable
{
    private double value;

    public DoubleAccumulator(double value)
    {
        this.value = value;
    }

    @Override public void compress()
    {
        this.value = FastMath.sqrt(this.value);
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
