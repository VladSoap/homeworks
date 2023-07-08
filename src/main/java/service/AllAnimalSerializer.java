package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AllAnimalSerializer<T extends Animal> {

    private ObjectMapper jsonMapper;
    private XmlMapper xmlMapper;
    private YAMLMapper yamlMapper;
    private Class<T> animalClass;

    public AllAnimalSerializer(Class<T> animalClass) {
        jsonMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
        yamlMapper = new YAMLMapper();
        this.animalClass = animalClass;
    }

    public void serializeToJson(T animal) {
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create JSON file");
            e.printStackTrace();
        }
    }

    public void serializeToJson(List<T> animals) {
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create JSON file");
            e.printStackTrace();
        }
    }

    public Optional<T> deserializeFromJson() {
        try {
            T animal = jsonMapper.readValue(new File("src/main/resources/animal.json"), animalClass);
            return Optional.ofNullable(animal);
        } catch (IOException e) {
            System.out.println("Cannot read JSON file");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void serializeToXml(T animal) {
        try {
            xmlMapper.writeValue(new File("src/main/resources/animal.xml"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create XML file");
            e.printStackTrace();
        }
    }

    public Optional<T> deserializeFromXml() {
        try {
            T animal = xmlMapper.readValue(new File("src/main/resources/animal.xml"), animalClass);
            return Optional.ofNullable(animal);
        } catch (IOException e) {
            System.out.println("Cannot read XML file");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void serializeToYaml(T animal) {
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create YAML file");
            e.printStackTrace();
        }
    }

    public void serializeToYaml(List<T> animals) {
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create YAML file");
            e.printStackTrace();
        }
    }

    public Optional<T> deserializeFromYaml() {
        try {
            T animal = yamlMapper.readValue(new File("src/main/resources/animal.yaml"), animalClass);
            return Optional.ofNullable(animal);
        } catch (IOException e) {
            System.out.println("Cannot read YAML file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}


