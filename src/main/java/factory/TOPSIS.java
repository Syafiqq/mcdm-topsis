package factory;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 4:34 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class TOPSIS
{
    private @NotNull  List<Alternative>    alternatives;
    private @Nullable AccumulatorContainer decisionMatrixAccumulator;
    private @Nullable WeightContainer      weight;
    private @Nullable ProfitContainer      profit;
    private @Nullable ProfitContainer      loss;

    public TOPSIS()
    {
        this.alternatives = new LinkedList<>();
    }

    public void compile()
    {
        if(alternatives.size() > 0)
        {
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.collectData(this.decisionMatrixAccumulator);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }

    }

    public void calculate()
    {
        if(alternatives.size() > 0)
        {
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.calculateDecisionMatrix(this.decisionMatrixAccumulator);
                alternative.calculateWeightedDecisionMatrix(this.weight);
            }
            this.alternatives.get(0).collectWeightedDecisionMatrix(this.profit);
            this.alternatives.get(0).collectWeightedDecisionMatrix(this.loss);
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.getProfit(this.profit);
                alternative.getLoss(this.loss);
            }
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.calculateProfitDistance(this.profit);
                alternative.calculateLossDistance(this.loss);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void ranking()
    {
        if(this.alternatives.size() > 0)
        {
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.calculatePreferences();
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void sort()
    {
        this.alternatives.sort(Comparator.naturalOrder());
    }

    public void process()
    {
        this.compile();
        this.calculate();
        this.ranking();
        this.sort();
    }

    public Alternative getBestAlternative()
    {
        @Nullable Alternative best = null;
        if(alternatives.size() > 0)
        {
            @NotNull final Alternative first = this.alternatives.get(0);
            @NotNull final Alternative last  = this.alternatives.get(this.alternatives.size() - 1);
            best = first.compareTo(last) >= 0 ? last : first;
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
        return best;
    }

    public boolean addAlternative(@NotNull Alternative t)
    {
        return alternatives.add(t);
    }

    @NotNull public List<Alternative> getAlternatives()
    {
        return this.alternatives;
    }

    public AccumulatorContainer getDecisionMatrixAccumulator()
    {
        return this.decisionMatrixAccumulator;
    }

    public void setDecisionMatrixAccumulator(AccumulatorContainer decisionMatrixAccumulator)
    {
        this.decisionMatrixAccumulator = decisionMatrixAccumulator;
    }

    public WeightContainer getWeight()
    {
        return this.weight;
    }

    public void setWeight(WeightContainer weight)
    {
        this.weight = weight;
    }

    public ProfitContainer getProfit()
    {
        return this.profit;
    }

    public void setProfit(ProfitContainer profit)
    {
        this.profit = profit;
    }

    public ProfitContainer getLoss()
    {
        return this.loss;
    }

    public void setLoss(ProfitContainer loss)
    {
        this.loss = loss;
    }
}
