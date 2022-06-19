package loadData;

public class Material implements Comparable<Material>
{
  private int id;
  private String name;
  private int vendorId;
  private String color;
  private double pricePerUnit;
  private String currency;
  private String unit;
  private double meltingPoint;
  private String tempUnit;
  private int deliveryTimeDays;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getVendorId()
  {
    return vendorId;
  }

  public void setVendorId(int vendorId)
  {
    this.vendorId = vendorId;
  }

  public void setColor(String color)
  {
    this.color = color;
  }

  public String getColor()
  {
    return color;
  }

  public double getPricePerUnit()
  {
    return pricePerUnit;
  }

  public void setPricePerUnit(double pricePerUnit)
  {
    this.pricePerUnit = pricePerUnit;
  }

  public String getCurrency()
  {
    return currency;
  }

  public void setCurrency(String currency)
  {
    this.currency = currency;
  }

  public String getUnit()
  {
    return unit;
  }

  public void setUnit(String unit)
  {
    this.unit = unit;
  }

  public double getMeltingPoint()
  {
    return meltingPoint;
  }

  public void setMeltingPoint(double meltingPoint)
  {
    this.meltingPoint = meltingPoint;
  }

  public String getTempUnit()
  {
    return tempUnit;
  }

  public void setTempUnit(String tempUnit)
  {
    this.tempUnit = tempUnit;
  }

  public int getDeliveryTimeDays()
  {
    return deliveryTimeDays;
  }

  public void setDeliveryTimeDays(int deliveryTimeDays)
  {
    this.deliveryTimeDays = deliveryTimeDays;
  }

  @Override public String toString()
  {
    return "\nMaterial{" + "id=" + id + ", name='" + name + '\'' + ", VendorId="
        + vendorId + ", pricePerUnit=" + pricePerUnit + ", currency='"
        + currency + '\'' + ", unit='" + unit + '\'' + ", meltingPoint="
        + meltingPoint + ", tempUnit=" + tempUnit + ", deliveryTimeDays="
        + deliveryTimeDays + '}';
  }

  @Override public int compareTo(Material o)
  {
    return Integer.compare(this.getVendorId(), o.getVendorId());
  }



}
