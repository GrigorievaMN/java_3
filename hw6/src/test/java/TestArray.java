import hw6.Main;
import org.junit.Assert;
import org.junit.Test;

public class TestArray {
    @Test
    public void test1ArrAfterFour1(){
        int[] in = new int[] {1, 2 ,4, 4 ,2 ,3 ,4, 1, 7};
        int[] out = new int[] {1, 7};
        Assert.assertArrayEquals(out, Main.arrAfterFour(in));
    }
    @Test (expected = RuntimeException.class)
    public void test2ArrAfterFour1(){
        int[] in = new int[] {7, 5, 1};
        Main.arrAfterFour(in);
    }
}
