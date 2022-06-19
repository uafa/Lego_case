import loadData.InitialData;
import loadData.Material;
import loadData.Vendor;
import logic.BestOfferForMaterial;
import logic.CheapestOffer;
import logic.FilterVendors;
import logic.SortMaterials;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class DisplayResults
{
  public static void main(String[] args) throws IOException
  {

    FileOutputStream fileOutputStream = new FileOutputStream("results.txt");
    PrintWriter writer = new PrintWriter(fileOutputStream);


    InitialData initialData = new InitialData();

    ArrayList<Material> materialArrayList = initialData.getAllMaterials();
    ArrayList<Vendor> vendorArrayList = initialData.getAllVendors();

    //1.

    //the comparison is based on vendor id
    Comparator<Material> materialComparator = Material::compareTo;
    Comparator<Vendor> vendorComparator = Vendor::compareTo; //to make sure the ids are in order

    Collections.sort(materialArrayList, materialComparator);
    Collections.sort(vendorArrayList, vendorComparator);

    ArrayList<ArrayList<Material>> sortedMaterials = SortMaterials.sortMaterialsWithVendors(
        vendorArrayList, materialArrayList);


    writer.println("1. Question\n");
    for (int i = 0; i < vendorArrayList.size(); i++)
    {
      writer.println(vendorArrayList.get(i).getName()+ " :");
      writer.println(sortedMaterials.get(i) +"\n");
    }


    // 2.

    writer.println("2. Question\n");

    ///Grouped materials by name
    Map map = CheapestOffer.separateMaterials(materialArrayList);

    //get all key values (names)
    ArrayList<String> names = CheapestOffer.extractNames(materialArrayList);

    //get cheapest offers
    Map<String, Material> cheapest = CheapestOffer.findCheapest(map, names);

    //display material name, vendor and delivery date

    String str = "Best offers:\n";
    for (String name : names)
    {
      String vendorName = "";

      for (int i = 0; i < vendorArrayList.size(); i++)
      {
        if (vendorArrayList.get(i).getId() == cheapest.get(name).getVendorId())
        {
          vendorName = vendorArrayList.get(i).getName();
          break;
        }
      }
      str += "Material: " + cheapest.get(name).getName() + " | Vendor: "
          + vendorName + " | Delivery time: " + cheapest.get(name)
          .getDeliveryTimeDays() + "\n";
    }

    writer.println(str);

    //3.

    writer.println("3. Question\n");
    Material bestOffer = BestOfferForMaterial.getBestOfferForMaterial(materialArrayList,
        vendorArrayList, "Polymethyl Methacrylate (PMMA)");

    writer.println("Best offer: \n" + bestOffer + "\nVendor:\n" +
        FilterVendors.getVendorById(vendorArrayList, bestOffer.getVendorId()));

  writer.close();
  }

}
