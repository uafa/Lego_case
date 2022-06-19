package logic;

import loadData.Material;

import java.util.*;
import java.util.stream.Collectors;

public class CheapestOffer
{

  public static Map<String, List<Material>> separateMaterials(
      ArrayList<Material> materials)
  {
    return materials.stream().collect(Collectors.groupingBy(Material::getName));
  }

  public static ArrayList<String> extractNames(ArrayList<Material> materials)
  {
    ArrayList<String> names = new ArrayList<>();

    for (Material material : materials)
    {
      if (!names.contains(material.getName()))
      {
        names.add(material.getName());
      }
    }
    return names;
  }

  public static Map<String, Material> findCheapest(
      Map<String, List<Material>> materials, ArrayList<String> names)
  {
    Map<String, Material> cheapestOffers = new HashMap<>();
    for (String name : names)
    {
      //first we get the materials with that name
      List<Material> typeMaterial = materials.get(name);
      Map<Integer, Double> prices = new HashMap<>();

      //Calculate all prices and put them in an ArrayList
      for (Material material : typeMaterial)
      {
        double price = PriceCalculations.calculatePrise(material);
        prices.put(typeMaterial.indexOf(material), price);
      }

      //Find out which one is the lowest and according to the index add the
      //cheapest ot the map.
      int index = PriceCalculations.getLowestPrice(prices);
      cheapestOffers.put(typeMaterial.get(index).getName(),
          typeMaterial.get(index));

    }

    return cheapestOffers;
  }

}
