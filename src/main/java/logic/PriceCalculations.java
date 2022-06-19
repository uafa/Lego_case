package logic;

import loadData.Material;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PriceCalculations
{
  public static double calculatePrise(Material material)
  {
    double price = 0;

    //calculated the price according to the currency
    switch (material.getCurrency())
    {
      case "DKK":
        price = material.getPricePerUnit();
        break;
      case "EURO":
        price = (material.getPricePerUnit() * 7.44);
        break;
      case "USD":
        price = (material.getPricePerUnit() * 7.09);
        break;
      case "POUND":
        price = (material.getPricePerUnit() * 8.67);
        break;
    }

    //calculate the price considering the unit (if lbs convert to kg)
    if(!material.getUnit().equals("kg"))
    {
      price *= 2.2;
    }
    return price;
  }

  public static Integer getLowestPrice( Map<Integer, Double> prices)
  {
    List<Map.Entry<Integer, Double> > list
        = new LinkedList<Map.Entry<Integer, Double> >(prices.entrySet());

    // Sort the list using lambda expression
    list.sort((i1, i2) -> i1.getValue().compareTo(i2.getValue()));

    return list.get(0).getKey();
  }
}
