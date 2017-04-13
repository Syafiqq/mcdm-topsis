package app.freelancer.syafiqq.madm.topsis.core.factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 7:57 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Alternative<AC extends AccumulatorContainer, WC extends WeightContainer, PC extends ProfitContainer> implements Comparable<Alternative>
{
    public abstract void collectData(@NotNull AC container);

    public abstract void calculateDecisionMatrix(@NotNull AC container);

    public abstract void calculateWeightedDecisionMatrix(@NotNull WC container);

    public abstract PC adaptWeightedDecisionMatrix();

    public abstract void getProfit(@NotNull PC container);

    public abstract void getLoss(@NotNull PC container);

    public abstract void calculateProfitDistance(@NotNull PC container);

    public abstract void calculateLossDistance(@NotNull PC container);

    public abstract void calculatePreferences();
}
