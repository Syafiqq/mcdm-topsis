package app.freelancer.syafiqq.madm.topsis.core.factory;

import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 7:57 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Alternative implements Comparable<Alternative>
{
    public abstract void collectData(@NotNull AccumulatorContainer container);

    public abstract void calculateDecisionMatrix(@NotNull AccumulatorContainer container);

    public abstract void calculateWeightedDecisionMatrix(@NotNull WeightContainer container);

    public abstract ProfitContainer adaptWeightedDecisionMatrix();

    public abstract void getProfit(@NotNull ProfitContainer container);

    public abstract void getLoss(@NotNull ProfitContainer container);

    public abstract void calculateProfitDistance(@NotNull ProfitContainer container);

    public abstract void calculateLossDistance(@NotNull ProfitContainer container);

    public abstract void calculatePreferences();
}
