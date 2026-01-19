package pagseguro.order;

import java.util.List;


public class OrderData {

    private String referenceId;
    private Customer customer;
    private List<Item> items;
    private List<QrCode> qrCodes;
    private Shipping shipping;
    private List<String> notificationUrls;

    public OrderData() {}

    public OrderData(
            String referenceId,
            Customer customer,
            List<Item> items,
            List<QrCode> qrCodes,
            Shipping shipping,
            List<String> notificationUrls
    ) {
        this.referenceId = referenceId;
        this.customer = customer;
        this.items = items;
        this.qrCodes = qrCodes;
        this.shipping = shipping;
        this.notificationUrls = notificationUrls;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<QrCode> getQrCodes() {
        return qrCodes;
    }

    public void setQrCodes(List<QrCode> qrCodes) {
        this.qrCodes = qrCodes;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public List<String> getNotificationUrls() {
        return notificationUrls;
    }

    public void setNotificationUrls(List<String> notificationUrls) {
        this.notificationUrls = notificationUrls;
    }

    public static class Customer {
        private String name;
        private String email;
        private String taxId;
        private List<Phone> phones;

        public Customer() {}

        public Customer(String name, String email, String taxId, List<Phone> phones) {
            this.name = name;
            this.email = email;
            this.taxId = taxId;
            this.phones = phones;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getTaxId() { return taxId; }
        public List<Phone> getPhones() { return phones; }
    }

    public static class Phone {
        private String country;
        private String area;
        private String number;
        private String type;

        public Phone() {}

        public Phone(String country, String area, String number, String type) {
            this.country = country;
            this.area = area;
            this.number = number;
            this.type = type;
        }

        public String getCountry() { return country; }
        public String getArea() { return area; }
        public String getNumber() { return number; }
        public String getType() { return type; }
    }

    public static class Item {
        private String name;
        private int quantity;
        private long unitAmount; // cents

        public Item() {}

        public Item(String name, int quantity, long unitAmount) {
            this.name = name;
            this.quantity = quantity;
            this.unitAmount = unitAmount;
        }

        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public long getUnitAmount() { return unitAmount; }
    }

    public static class QrCode {
        private Amount amount;
        private List<String> arrangements;
        private String expirationDate;

        public QrCode() {}

        public QrCode(Amount amount, List<String> arrangements, String expirationDate) {
            this.amount = amount;
            this.arrangements = arrangements;
            this.expirationDate = expirationDate;
        }

        public Amount getAmount() { return amount; }
        public List<String> getArrangements() { return arrangements; }
        public String getExpirationDate() { return expirationDate; }
    }

    public static class Amount {
        private long value; // cents

        public Amount() {}

        public Amount(long value) {
            this.value = value;
        }

        public long getValue() { return value; }
    }

    public static class Shipping {
        private Address address;

        public Shipping() {}

        public Shipping(Address address) {
            this.address = address;
        }

        public Address getAddress() { return address; }
    }

    public static class Address {
        private String street;
        private String number;
        private String complement;
        private String locality;
        private String city;
        private String regionCode;
        private String country;
        private String postalCode;

        public Address() {}

        public Address(
                String street,
                String number,
                String complement,
                String locality,
                String city,
                String regionCode,
                String country,
                String postalCode
        ) {
            this.street = street;
            this.number = number;
            this.complement = complement;
            this.locality = locality;
            this.city = city;
            this.regionCode = regionCode;
            this.country = country;
            this.postalCode = postalCode;
        }

        public String getStreet() { return street; }
        public String getNumber() { return number; }
        public String getComplement() { return complement; }
        public String getLocality() { return locality; }
        public String getCity() { return city; }
        public String getRegionCode() { return regionCode; }
        public String getCountry() { return country; }
        public String getPostalCode() { return postalCode; }
    }
}
