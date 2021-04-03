import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.PriorityQueue;
import java.util.stream.Stream;


public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider(){
        //  return stream
        return Stream.of(
                arguments(new int[]{3,7,6,4},new int[] {3,6,4,7}),
                arguments(new int[]{2,9,3,1},new int[] {1,3,2,9}),
                arguments(new int[]{8,4,6,5},new int[] {4,6,5,8}),
                arguments(new int[]{9,0,3,6},new int[] {0,6,3,9}),
                arguments(new int[]{4,2,5,6},new int[] {2,5,4,6})
        );
    }

    @ParameterizedTest(name="#{index} -Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int [] random_array,int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int [] result = new int[random_array.length];
        for (int i =0 ; i<random_array.length;i++){
            test.add(random_array[i]);
        }
        for(int i =0 ; i< random_array.length;i++){
            result[i] = test.poll();

        }
        assertArrayEquals(correct_array,result);
    }

    @Test
    public void initialCapacityTest() {
        // Throws: IllegalArgumentException - if initialCapacity is less than 1
        assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });
    }

    @Test
    public void offerTest() {
        // Throws: NullPointerException - if the specified element is null
        assertThrows(NullPointerException.class, () -> new PriorityQueue().offer(null));
    }

    @Test
    public void addTest() {
        // Throws: NullPointerException - if the specified element is null
        assertThrows(NullPointerException.class, () -> new PriorityQueue().add(null));
    }
}
