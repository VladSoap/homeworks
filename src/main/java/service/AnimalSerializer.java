package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AnimalSerializer {

    private ObjectMapper jsonMapper;
    private XmlMapper xmlMapper;
    private YAMLMapper yamlMapper;

    public AnimalSerializer() {
        this.jsonMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();
        this.yamlMapper = new YAMLMapper();
    }

    public void serialize(Animal animal, String format) {
        try {
            switch (format.toLowerCase()) {
                case "json":
                    jsonMapper.writeValue(new File("src/main/resources/animal." + format), animal);
                    break;
                case "xml":
                    xmlMapper.writeValue(new File("src/main/resources/animal." + format), animal);
                    break;
                case "yaml":
                    yamlMapper.writeValue(new File("src/main/resources/animal." + format), animal);
                    break;
                default:
                    System.out.println("Unsupported format");
                    break;
            }
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public void serialize(List<Animal> animals, String format) {
        try {
            switch (format.toLowerCase()) {
                case "json":
                    jsonMapper.writeValue(new File("src/main/resources/animal." + format), animals);
                    break;
                case "xml":
                    xmlMapper.writeValue(new File("src/main/resources/animal." + format), animals);
                    break;
                case "yaml":
                    yamlMapper.writeValue(new File("src/main/resources/animal." + format), animals);
                    break;
                default:
                    System.out.println("Unsupported format");
                    break;
            }
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserialize(String format) {
        try {
            switch (format.toLowerCase()) {
                case "json":
                    return Optional.of(jsonMapper.readValue(new File("src/main/resources/animal." + format), Animal.class));
                case "xml":
                    return Optional.of(xmlMapper.readValue(new File("src/main/resources/animal." + format), Animal.class));
                case "yaml":
                    return Optional.of(yamlMapper.readValue(new File("src/main/resources/animal." + format), Animal.class));
                default:
                    System.out.println("Unsupported format");
                    return Optional.empty();
            }
        } catch (IOException e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}

