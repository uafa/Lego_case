package logic;

import loadData.Material;
import loadData.Vendor;

import java.util.ArrayList;

public class SortMaterials
{
  public static ArrayList<ArrayList<Material>> sortMaterialsWithVendors(
      ArrayList<Vendor> vendors, ArrayList<Material> materials)
  {
    ArrayList<ArrayList<Material>> sortedMaterials = new ArrayList<>();

    //for each vendor
    for (Vendor vendor : vendors)
    {
      ArrayList<Material> materialsVendor = new ArrayList();

      int target = vendor.getId();

      // get the start index of targeted number
      int startIndex = getStartIndexOfTarget(target, materials);


      // get the end index of target number
      int endIndex = getEndIndexOfTarget(target, materials);


      if (startIndex != -1 && endIndex != -1)
      {
        for (int i = 0; i + startIndex <= endIndex; i++)
        {
          materialsVendor.add(materials.get((i + startIndex)));
        }
      }
      sortedMaterials.add(materialsVendor);
    }

    return sortedMaterials;
  }

  private static int getStartIndexOfTarget(int target, ArrayList<Material> materials)
  {
    int low = 0, high = materials.size() - 1;

    // get the start index of targeted number
    int startIndex = -1;

    while (low <= high)
    {
      int mid = (high - low) / 2 + low;
      if (materials.get(mid).getVendorId() > target)
      {
        high = mid - 1;
      }
      else if (materials.get(mid).getVendorId() == target)
      {
        startIndex = mid;
        high = mid - 1;
      }
      else
        low = mid + 1;
    }
    return startIndex;

  }

  private static int getEndIndexOfTarget(int target, ArrayList<Material> materials)
  {
    int low = 0, high = materials.size() - 1;
    int endIndex = -1;

    while (low <= high)
    {
      int mid = (high - low) / 2 + low;
      if (materials.get(mid).getVendorId() > target)
      {
        high = mid - 1;
      }
      else if (materials.get(mid).getVendorId() == target)
      {
        endIndex = mid;
        low = mid + 1;
      }
      else
        low = mid + 1;
    }
    return endIndex;
  }




}
