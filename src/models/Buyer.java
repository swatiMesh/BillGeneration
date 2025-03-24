package models;
public class Buyer {
    private String name;
    private String contractNumber;
    private String address;

    public Buyer(String name, String contractNumber, String address) {
        this.name = name;
        this.contractNumber = contractNumber;
        this.address = address;
    }

    public String getName() { return name; }
    public String getContractNumber() { return contractNumber; }
    public String getAddress() { return address; }
}
