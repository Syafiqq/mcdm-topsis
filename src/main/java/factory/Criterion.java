package factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:11 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Criterion<A extends Accumulator, W extends Weight, P extends Profit>
{
    public abstract void collect(@NotNull A accumulator);

    public abstract void calculate(@NotNull A accumulator);

    public abstract void normalize(@NotNull W weight);

    public abstract void searchProfit(@NotNull P profit);

    public abstract void searchLoss(@NotNull P profit);

    public abstract void profitDistance(@NotNull P profit);

    public abstract void lossDistance(@NotNull P profit);
}
