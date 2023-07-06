import model.Animal;
import org.junit.Assert;
import org.junit.Test;
import service.AnimalJsonSerializer;

import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalJsonSerializerTest {

    private final AnimalJsonSerializer animalJsonSerializer = new AnimalJsonSerializer();
    private final Animal dog = new Animal("sharik", "2015.03.11", 7, false, "doberman");
    private final Animal cat = new Animal("myrka", "2016.04.20", 7, false, "persian");


    @Test
    public void serializeTest() {
        animalJsonSerializer.serialize(dog);
    }

    @Test
    public void serializeListTest() {
        animalJsonSerializer.serialize(List.of(cat, dog));
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalJsonSerializer.deserialize();
        Assert.assertEquals(dog, deserialize.orElse(null));
    }
}
