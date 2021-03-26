import hw6.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassTestArr2 {
    private int[] in;
    private boolean out;

    public MassTestArr2(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 4, 4, 1, 4, 4 } , true},
                {new int[]{1, 1, 1, 1, 1, 1 } , false},
                {new int[]{4, 4, 4, 4, 4} , false},
                {new int[]{1, 4, 4, 1, 1, 4, 3}, false}
        });
    }

    @Test
    public void MassTestArrOneAndFour(){
        Assert.assertEquals(out, Main.arrOneAndFour(in));
    }
}

