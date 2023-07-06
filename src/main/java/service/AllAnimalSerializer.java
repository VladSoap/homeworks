package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AllAnimalSerializer {

    private ObjectMapper jsonMapper;
    private XmlMapper xmlMapper;
    private YAMLMapper yamlMapper;

    public AllAnimalSerializer() {
        jsonMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
        yamlMapper = new YAMLMapper();
    }

    public void serializeToJson(Animal animal) {
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create JSON file");
            e.printStackTrace();
        }
    }

    public void serializeToJson(List<Animal> animals) {
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create JSON file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserializeFromJson() {
        try {
            return Optional.of(jsonMapper.readValue(new File("src/main/resources/animal.json"), Animal.class));
        } catch (IOException e) {
            System.out.println("Cannot read JSON file");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void serializeToXml(Animal animal) {
        try {
            xmlMapper.writeValue(new File("src/main/resources/animal.xml"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create XML file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserializeFromXml() {
        try {
            return Optional.of(xmlMapper.readValue(new File("src/main/resources/animal.xml"), Animal.class));
        } catch (IOException e) {
            System.out.println("Cannot read XML file");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void serializeToYaml(Animal animal) {
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create YAML file");
            e.printStackTrace();
        }
    }

    public void serializeToYaml(List<Animal> animals) {
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create YAML file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserializeFromYaml() {
        try {
            return Optional.of(yamlMapper.readValue(new File("src/main/resources/animal.yaml"), Animal.class));
        } catch (IOException e) {
            System.out.println("Cannot read YAML file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
