import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Person {

    public enum Visibility {
        PUBLIC(0),
        PRIVATE(1),
        FRIENDS_ONLY(2);

        private final int number;

        Visibility(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public static Visibility forNumber(int value) {
            for (Visibility e : values()) {
                if (e.number == value) return e;
            }
            return null;
        }
    }

    public static class Address {

        private String street;
        private String city;
        private String state;
        private String zip_code;

        public Address() {}

        public String getStreet() {
            return this.street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return this.state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip_code() {
            return this.zip_code;
        }

        public void setZip_code(String zip_code) {
            this.zip_code = zip_code;
        }

        @Override
        public String toString() {
            return "Address{" +
                "street=" + street + ", " +
                "city=" + city + ", " +
                "state=" + state + ", " +
                "zip_code=" + zip_code +
                '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address that = (Address) o;
            return Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zip_code, that.zip_code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(street, city, state, zip_code);
        }
    }

    private String name;
    private int id;
    private String email;
    private List<PhoneNumber> phones;
    private String nickname;
    private Visibility visibility;
    private Address home_address;
    private Map<String, String> attributes = new HashMap<>();

    public enum Contact_methodCase {
        CONTACT_METHOD_NOT_SET,
        PHONE,
        EMAIL_ADDRESS,
    }

    private Contact_methodCase contact_methodCase = Contact_methodCase.CONTACT_METHOD_NOT_SET;
    private String phone;
    private String email_address;

    public Person() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhoneNumber> getPhones() {
        return this.phones;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Visibility getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Address getHome_address() {
        return this.home_address;
    }

    public void setHome_address(Address home_address) {
        this.home_address = home_address;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public void putAttributes(String key, String value) {
        this.attributes.put(key, value);
    }

    public Contact_methodCase getContact_methodCase() {
        return this.contact_methodCase;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = null;
        this.email_address = null;
        this.phone = phone;
        this.contact_methodCase = Contact_methodCase.PHONE;
    }

    public String getEmail_address() {
        return this.email_address;
    }

    public void setEmail_address(String email_address) {
        this.phone = null;
        this.email_address = null;
        this.email_address = email_address;
        this.contact_methodCase = Contact_methodCase.EMAIL_ADDRESS;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name=" + name + ", " +
            "id=" + id + ", " +
            "email=" + email + ", " +
            "phones=" + phones + ", " +
            "nickname=" + nickname + ", " +
            "visibility=" + visibility + ", " +
            "home_address=" + home_address +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(id, that.id) &&
            Objects.equals(email, that.email) &&
            Objects.equals(phones, that.phones) &&
            Objects.equals(nickname, that.nickname) &&
            Objects.equals(visibility, that.visibility) &&
            Objects.equals(home_address, that.home_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, email, phones, nickname, visibility, home_address);
    }
}
