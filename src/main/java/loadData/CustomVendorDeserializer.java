package loadData;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomVendorDeserializer extends StdDeserializer<Vendor>
{
  public CustomVendorDeserializer()
  {
    this(null);
  }

  public CustomVendorDeserializer(Class<?> vc)
  {
    super(vc);
  }

  @Override public Vendor deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext)
      throws IOException
  {
    Vendor vendor = new Vendor();
    ObjectCodec codec = jsonParser.getCodec();
    JsonNode node = codec.readTree(jsonParser);

    //id
    JsonNode idNode = node.get("ID");
    int id = idNode.asInt();
    vendor.setId(id);

    //name
    JsonNode nameNode = node.get("Name");
    String name = nameNode.asText();
    vendor.setName(name);

    //postalCode
    JsonNode codeNode = node.get("PostalCode");
    int code = codeNode.asInt();
    vendor.setPostalCode(code);

    //address
    JsonNode addressNode = node.get("Address");
    String address = addressNode.asText();
    vendor.setAddress(address);

    //contact person
    JsonNode contactNode = node.get("ContactPerson");
    String contact = contactNode.asText();
    vendor.setContactPerson(contact);

    //is ECO friendly
    JsonNode ecoNode = node.get("ECOFriendly");
    boolean isEcoFriendly = ecoNode.asBoolean();
    vendor.setEcoFriendly(isEcoFriendly);


    return vendor;
  }
}
