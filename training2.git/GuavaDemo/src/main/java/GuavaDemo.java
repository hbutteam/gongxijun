import com.google.common.collect.ImmutableSet;

import java.util.Map;
import java.util.Set;

/**
 * Created by gongxijun on 16-3-15.
 */
public class GuavaDemo < E > {


    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "Red",
            "Orange",
            "yellow",
            "green",
            "blue",
            "purple"
    );

    class Foo <E>{

        Set< E > bars;
       public Foo( Set<E>bars ){
            this.bars = ImmutableSet.copyOf(bars) ;
        }
    }

}
