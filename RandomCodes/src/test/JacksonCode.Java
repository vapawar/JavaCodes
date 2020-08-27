package org.vpz.test;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JacksonCode {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        String json = "{\"name\":\"vpz\",\"num\":24}";

        // standard way
        Student student = mapper.readValue(json, Student.class);
        String str = mapper.writeValueAsString(student);
        System.out.println("Raw format:-" + str);

        mapper.writeValue(new File("test.json"), student);
        student = mapper.readValue(new File("test.json"), Student.class);
        System.out.println(student);

        // tree node way
        JsonNode root = mapper.readTree(json);
        JsonNode nameNode = root.path("name");
        System.out.print(nameNode.getTextValue());
        JsonNode numNode = root.path("num");
        System.out.println(numNode.getIntValue() + 1);

        // stream way
        JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createJsonGenerator(new File("test.json"), JsonEncoding.UTF8);
        generator.writeStartObject();
        generator.writeStringField("Name", "Vinod");
        generator.writeNumberField("Number", 3212);
        generator.writeEndObject();
        generator.close();

        JsonParser parser = factory.createJsonParser(new File("test.json"));
        parser.nextToken();
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String nodeName = parser.getCurrentName();
            System.out.println(parser.getText());
        }
    }
}

class Student {

    String name = "NA";
    int num = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "name:" + name + ", num:" + num;
    }
}
