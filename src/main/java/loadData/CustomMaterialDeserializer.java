package loadData;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomMaterialDeserializer extends StdDeserializer<Material>
{

  public CustomMaterialDeserializer()
  {
    this(null);
  }

  public CustomMaterialDeserializer(Class<?> vc)
  {
    super(vc);
  }

  @Override public Material deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext)
      throws IOException, JacksonException
  {
    Material material = new Material();
    ObjectCodec codec = jsonParser.getCodec();
    JsonNode node = codec.readTree(jsonParser);

    //id
    JsonNode idNode = node.get("ID");
    int id = idNode.asInt();
    material.setId(id);


    //name
    JsonNode nameNode = node.get("Name");
    String name = nameNode.asText();
    material.setName(name);

    //vendor id
    JsonNode vendorNode = node.get("VendorID");
    int vendor = vendorNode.asInt();
    material.setVendorId(vendor);

    //color
    JsonNode colorNode = node.get("Color");
    String color = colorNode.asText();
    material.setColor(color);

    //price per unit
    JsonNode priceNode = node.get("PricePerUnit");
    double price = priceNode.asDouble();
    material.setPricePerUnit(price);

    //currency
    JsonNode currencyNode = node.get("Currency");
    String currency = currencyNode.asText();
    material.setCurrency(currency);

    //unit
    JsonNode unitNode = node.get("Unit");
    String unit = unitNode.asText();
    material.setUnit(unit);

    //melting point
    JsonNode meltingPNode = node.get("MeltingPoint");
    double meltingP = priceNode.asDouble();
    material.setMeltingPoint(meltingP);

    //temp unit
    JsonNode tempNode = node.get("TempUnit");
    String temp = tempNode.asText();
    material.setTempUnit(temp);

    //delivery time
    JsonNode deliveryNode = node.get("DeliveryTimeDays");
    int delivery = deliveryNode.asInt();
    material.setDeliveryTimeDays(delivery);


    return material;
  }
}
