package app.freelancer.syafiqq.madm.topsis.core.factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:11 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Criterion
{
    public abstract void collect(@NotNull Accumulator accumulator);

    public abstract void calculate(@NotNull Accumulator accumulator);

    public abstract void normalize(@NotNull Weight weight);

    public abstract void searchProfit(@NotNull Profit profit);

    public abstract void searchLoss(@NotNull Profit profit);

    public abstract void profitDistance(@NotNull Profit profit);

    public abstract void lossDistance(@NotNull Profit profit);
}
