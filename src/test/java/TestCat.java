import com.example.Cat;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.example.Feline;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.Predator;

@ExtendWith(MockitoExtension.class)
public class TestCat {

    @Mock
    Predator predator;

    @Test
    public void shouldReturnGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        //стаб
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        // инъекция зависимости
        Cat cat = new Cat(predator);

        // вызов метода тестируемого класса
        List<String> actualFood = cat.getFood();

        // проверка результата
        assertEquals(expectedFood, actualFood);

        // проверка взаимодействия
        Mockito.verify(predator).eatMeat();
    }

    @Test
    public void getSoundMyauReturnMyau(){
        Cat cat = new Cat(predator);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual);
    }
    }

