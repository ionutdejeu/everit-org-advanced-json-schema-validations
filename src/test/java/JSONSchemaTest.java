import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;
import sun.misc.IOUtils;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.sql.Struct;

public class JSONSchemaTest {
    @Test
    public void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/schema.json")));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/obj_invalid.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException e){
            Schema s= e.getViolatedSchema();

            String msg= e.getMessage();
        }
    }

    @Test
    public void any_off_json_schema_test() throws ValidationException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/any_of_json_schema.json")));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/obj_invalid_any_of.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException e){
            Schema s= e.getViolatedSchema();

            String msg= e.getMessage();
        }
    }

    @Test
    public void ifthen_test() throws ValidationException, URISyntaxException, IOException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/ifthen/schema.json")));
        java.nio.file.Path i= java.nio.file.Paths.get(getClass().getClassLoader().getResource("ifthen/obj.json").toURI());

        String theString = new String(Files.readAllBytes(i));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(theString.toLowerCase()));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException e){
            Schema s= e.getViolatedSchema();

            String msg= e.getMessage();
        }
    }

    @Test
    public void regex_attribute_test() throws ValidationException, URISyntaxException, IOException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/obj_properties_regex/schema.json")));
        java.nio.file.Path i= java.nio.file.Paths.get(getClass().getClassLoader().getResource("obj_properties_regex/obj.json").toURI());

        String theString = new String(Files.readAllBytes(i));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(theString.toLowerCase()));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException e){
            Schema s= e.getViolatedSchema();

            String msg= e.getMessage();
        }
    }

    @Test
    public void format_attribute_test() throws ValidationException, URISyntaxException, IOException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/format/schema.json")));
        java.nio.file.Path i= java.nio.file.Paths.get(getClass().getClassLoader().getResource("format/obj.json").toURI());

        String theString = new String(Files.readAllBytes(i));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(theString.toLowerCase()));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException e){
            Schema s= e.getViolatedSchema();

            String msg= e.getMessage();
        }
    }

    @Test
    public void attribute_type_validation() throws ValidationException, URISyntaxException, IOException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/type_validations/schema.json")));
        java.nio.file.Path i= java.nio.file.Paths.get(getClass().getClassLoader().getResource("type_validations/obj.json").toURI());

        String theString = new String(Files.readAllBytes(i));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(theString.toLowerCase()));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException e){
            Schema s= e.getViolatedSchema();

            String msg= e.getMessage();
        }
    }

    @Test
    public void attribute_enumeration_validation() throws ValidationException, URISyntaxException, IOException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(JSONSchemaTest.class.getResourceAsStream("/type_enum/schema.json")));
        java.nio.file.Path i= java.nio.file.Paths.get(getClass().getClassLoader().getResource("type_enum/obj.json").toURI());

        String theString = new String(Files.readAllBytes(i));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(theString.toLowerCase()));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException e){
            Schema s= e.getViolatedSchema();

            String msg= e.getMessage();
        }
    }

}
