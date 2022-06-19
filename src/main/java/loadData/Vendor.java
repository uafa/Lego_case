package loadData;

public class Vendor implements Comparable<Vendor>
{
  private int id;
  private String name;
  private int postalCode;
  private String address;
  private String contactPerson;
  private boolean isEcoFriendly;

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

  public int getPostalCode()
  {
    return postalCode;
  }

  public void setPostalCode(int postalCode)
  {
    this.postalCode = postalCode;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getContactPerson()
  {
    return contactPerson;
  }

  public void setContactPerson(String contactPerson)
  {
    this.contactPerson = contactPerson;
  }

  public boolean isEcoFriendly()
  {
    return isEcoFriendly;
  }

  public void setEcoFriendly(boolean ecoFriendly)
  {
    isEcoFriendly = ecoFriendly;
  }

  @Override public String toString()
  {
    return "Vendor{" + "id=" + id + ", name='" + name + '\'' + ", postalCode="
        + postalCode + ", address='" + address + '\'' + ", contactPerson='"
        + contactPerson + '\'' + ", isEcoFriendly=" + isEcoFriendly + '}'+ "\n";
  }

  @Override public int compareTo(Vendor o)
  {
    return Integer.compare(this.getId(), o.getId());
  }
}
