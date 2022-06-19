package logic;

import loadData.Material;
import loadData.Vendor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestOfferForMaterial
{

  public static Material getBestOfferForMaterial(ArrayList<Material> materials,
      ArrayList<Vendor> vendors, String name)
  {
    //sorted so the cheapest offers with the fastest delivery date are in the
    //beginning of the list

    ArrayList<Material> sortedMaterials = sortByPriceAndDelivery(materials);

    ArrayList<Material> allOffers = new ArrayList<>();

    //get all offers of that product
    // that have the right melting point and the vendor is eco

    for (Material material : sortedMaterials)
    {
      if (material.getName().equals(name) && checkIfVendorIsEco(
          material.getVendorId(), vendors))
      {
        double temp = material.getMeltingPoint();

        if (!material.getTempUnit().equals("C"))
        {
          temp = (temp - 32) / 1.8;
        }

        if (temp <= 300 && temp >= 200)
        {
          allOffers.add(material);
        }
      }
    }

    //return the first one since it was sorted earlier and cheapest, fastest is
    //placed in the beginning

    return allOffers.get(0);
  }

  private static boolean checkIfVendorIsEco(int id, ArrayList<Vendor> vendors)
  {
    boolean isEco = false;
    for (Vendor vendor : vendors)
    {
      if (vendor.getId() == id)
      {
        isEco = vendor.isEcoFriendly();
      }
    }
    return isEco;
  }

  private static ArrayList<Material> sortByPriceAndDelivery(
      ArrayList<Material> materials)
  {

    Comparator<Material> comparator = Comparator.comparing(
        Material::getDeliveryTimeDays);
    comparator = comparator.thenComparing(PriceCalculations::calculatePrise);

    // Sort the stream:
    Stream<Material> materialStream = materials.stream().sorted(comparator);

    //return as an ArrayList
    return (ArrayList<Material>) materialStream.collect(Collectors.toList());
  }

}
