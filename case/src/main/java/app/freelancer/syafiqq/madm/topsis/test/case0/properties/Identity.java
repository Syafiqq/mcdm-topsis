package app.freelancer.syafiqq.madm.topsis.test.case0.properties;

import app.freelancer.syafiqq.madm.topsis.core.factory.Properties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * This <topsis> created by : 
 * Name         : syafiq
 * Date / Time  : 13 April 2017, 8:51 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Identity extends Properties
{
    @NotNull private String name;

    public Identity(@NotNull String name)
    {
        this.name = name;
    }

    @NotNull public String getName()
    {
        return this.name;
    }

    public void setName(@NotNull String name)
    {
        this.name = name;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
