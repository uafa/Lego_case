package loadData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitialData
{

  private ObjectMapper objectMapper;
  private String jsonFilePath = "src/main/resources/material_vendor_data.json";
  private SimpleModule module;

  public InitialData()
  {
    objectMapper = new ObjectMapper();
    module = new SimpleModule();

    //set a custom deserializer for vendors
    module.addDeserializer(Vendor.class, new CustomVendorDeserializer());

    //set a custom deserializer for materials
    module.addDeserializer(Material.class, new CustomMaterialDeserializer());
    objectMapper.registerModule(module);

  }

  public ArrayList<Material> getAllMaterials() throws IOException
  {
    //extract all Materials
    Material[] materials = objectMapper.treeToValue
        (objectMapper.readTree(new File(jsonFilePath)).get("Materials"),
            Material[].class
        );

    return new ArrayList<>(List.of(materials));
  }

  public ArrayList<Vendor> getAllVendors() throws IOException
  {
    //extract all Vendors
    Vendor[] vendors = objectMapper.
        treeToValue(objectMapper.readTree(new File(jsonFilePath)).
        get("Vendors"), Vendor[].class);

    return new ArrayList<>(List.of(vendors));
  }
}
