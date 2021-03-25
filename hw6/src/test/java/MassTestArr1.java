import hw6.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassTestArr1 {
    private int[] in;
    private int[] out;

    public MassTestArr1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7 } , new int[]{1, 7}},
            {new int[]{1, 2, 4, 4 } , new int[] {}},
            {new int[]{4, 4, 2, 3, 4, 1, 7, 5, 1} , new int[]{1, 7, 5, 1}},
            {new int[]{7, 5, 4, 1 } , new int[]{1}}
        });
    }
    @Test
    public void MassTestArrAfterFour(){
        Assert.assertArrayEquals(out, Main.arrAfterFour(in));
    }
}
