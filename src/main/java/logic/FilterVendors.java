package logic;

import loadData.Vendor;

import java.util.ArrayList;

public class FilterVendors
{
  public static Vendor getVendorById(ArrayList<Vendor> vendors, int id)
  {
    for (Vendor vendor : vendors)
    {
      if (vendor.getId() == id)
      {
        return vendor;
      }
    }
    return null;
  }
}
