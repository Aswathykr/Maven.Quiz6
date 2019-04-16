package rocks.zipcode.io.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leon on 10/01/2019.
 */
public class PowerSet<TypeOfSet> {
    protected final Set<TypeOfSet> originalSet;

    public PowerSet(TypeOfSet[] originalSet) {
        this.originalSet = new HashSet<>(Arrays.asList(originalSet));
    }

    /**
     * @return the powerset of `originalSet`
     */
    public Set<Set<TypeOfSet>> permute() {
        Set<Set<TypeOfSet>> output =  new HashSet<>();
        ArrayList<TypeOfSet> list = new ArrayList<>(originalSet);
        long pow_set_size =
                (long)Math.pow(2, originalSet.size());
        int counter, j;

        for(counter = 0; counter <
                pow_set_size; counter++)
        {
            Set<TypeOfSet> temp =  new HashSet<>();
            for(j = 0; j < originalSet.size(); j++)
            {
                if((counter & (1 << j)) > 0)
                    temp.add(list.get(j));
            }

            output.add(temp);
        }
        return output;
    }

    /**
     * @return `originalSet`
     */
    public Set<TypeOfSet> getOriginalSet() {
        return originalSet;
    }
}
