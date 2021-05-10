import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestRandomNumbers {

    @Test
    public void testNextIntFromRange(){
        RandomNumbers rn = GenericTestFactory.getInstance(RandomNumbers.class);

        int min = 11;
        int max = 13;

        List<Integer> generated = GenericTestFactory.invokeMethod(rn,"nextIntFromRange",new Object[]{min,max}, true);

        if(generated.size() != 2)
            fail();

        boolean ok = false;
        for (Integer i: generated) {
            if (i != null && i >= min && i <= max) {
                ok = true;
                break;
            }
        }

        if(!ok)
            fail();
    }

    @Test
    public void textNextEvenIntFromRange(){
        RandomNumbers rn = GenericTestFactory.getInstance(RandomNumbers.class);

        int min = 9;
        int max = 13;

        List<Integer> generated = GenericTestFactory.invokeMethod(rn,"nextEvenIntFromRange",new Object[]{min,max}, true);

        if(generated.size() != 2)
            fail();

        boolean ok = false;
        for (Integer i: generated) {
            if (i != null && i >= min && i <= max && i % 2 == 0) {
                ok = true;
                break;
            }
        }

        if(!ok)
            fail();
    }
    @Test
    public void randomElement(){
        RandomNumbers rn = GenericTestFactory.getInstance(RandomNumbers.class);

        ArrayList<BigDecimal> decimals = new ArrayList<>();
        decimals.add(new BigDecimal(1200));
        decimals.add(new BigDecimal(125));
        decimals.add(new BigDecimal(12621));

        List<BigDecimal> generated = GenericTestFactory.invokeMethod(rn,"randomElement",new Object[]{decimals});

        if(generated.size() != 1)
            fail();

        assertTrue(decimals.contains(generated.get(0)));
    }
}
