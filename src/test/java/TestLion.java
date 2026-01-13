import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TestLion {
    @Mock
    Feline feline;

    @Test
    public void shouldCallGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline); // инъекция зависимости
        lion.getKittens();//вызов метода
        Mockito.verify(feline).getKittens();//проверить факт вызова метода
    }

    @Test
    public void shouldReceiveGetKittensValue() throws Exception {
        //стаб
        Mockito.when(feline.getKittens()).thenReturn(1);
        // инъекция зависимости
        Lion lion = new Lion("Самка", feline);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCallDoesHaveManeTrue() throws Exception{
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
            }

    @Test
    public void shouldCallDoesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void shouldReturnGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        //стаб
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        // инъекция зависимости
        Lion lion = new Lion("Самец", feline);

        // вызов метода тестируемого класса
        List<String> actualFood = lion.getFood();

        // проверка результата
        assertEquals(expectedFood, actualFood);

        // проверка взаимодействия
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void shouldThrowExceptionForInvalidSex() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("полуденница", feline)
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }

    @ExtendWith(MockitoExtension.class)
    public static class TestLionParametrized {

        @Mock
        Feline feline;

        @ParameterizedTest
        @CsvSource({
                "самец, true",
                "самка, false"
        })
        void shouldReturnCorrectManeValue(String sex, boolean expected) throws Exception {
            Lion lion = new Lion(sex, feline);
            assertEquals(expected, lion.doesHaveMane());
        }
    }
}
///