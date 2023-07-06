
import model.Animal;
import org.junit.Assert;
import org.junit.Test;
import service.AnimalYamlSerializer;

import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalYamlSerializerTest {

    private final AnimalYamlSerializer animalYamlSerializer = new AnimalYamlSerializer();
    private final Animal dog = new Animal("sharik", "2015.03.11", 7, false, "doberman");
    private final Animal cat = new Animal("myrka", "2016.04.20", 7, false, "persian");


    @Test
    public void serializeTest() {
        animalYamlSerializer.serialize(dog);
    }

    @Test
    public void serializeListTest() {
        animalYamlSerializer.serialize(List.of(cat, dog));
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalYamlSerializer.deserialize();
        Assert.assertEquals(dog, deserialize.orElse(null));
    }
}
