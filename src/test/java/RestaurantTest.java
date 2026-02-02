import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RestaurantTest {

    @Test
    void testAverageRating() {
        Restaurant r = new Restaurant("Test Restaurant");
        r.addRating(5);
        r.addRating(3);
        assertEquals(4.0, r.getAverageRating());
    }
}


