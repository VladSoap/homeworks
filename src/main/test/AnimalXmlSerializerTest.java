import model.Animal;
import model.Type;
import org.junit.Assert;
import org.junit.Test;
import service.AnimalXmlSerializer;

import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalXmlSerializerTest {

    private final AnimalXmlSerializer animalXmlSerializer = new AnimalXmlSerializer();
    private final Animal input = new Animal("sharik", "2015.03.11", 7,
            false, "doberman", new Type(1, "root", "text"));


    @Test
    public void serializeTest() {
        animalXmlSerializer.serialize(input);
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalXmlSerializer.deserialize();
        Assert.assertEquals(input, deserialize.orElse(null));
    }
}
