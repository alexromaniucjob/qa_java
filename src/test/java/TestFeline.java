import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFeline {
    @Test
    public void eatMeat() throws Exception{
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getFamilyPresetFelineReturnFeline(){
        Feline feline = new Feline();
String expected = "Кошачьи";
String actual = feline.getFamily();
assertEquals(expected, actual);
    }

    @Test
    public void getKittensPresetAmountOneReturnOne(){
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensTwoAmountReturnTwo(){
        Feline feline = new Feline();
        int expected = 2;
        int actual = feline.getKittens(2);
        assertEquals(expected, actual);
    }

    public static class TestFelineParametrized {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 5})
        void shouldReturnSameKittensCount(int kittensCount) {
            Feline feline = new Feline();
            assertEquals(kittensCount, feline.getKittens(kittensCount));
        }
    }

}


