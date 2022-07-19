package pojos;

public class BookingDatesPojo {

    // 1 ) Tum keyler icin private variable lar olusturuyoruz.
    private String checkin;
    private String checkout;

    //2) Tum parametrelerle ve parametresiz constructor olusturulur parmetresiz
    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //3 ) Getters ve setters lari olusturuyoruz
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    // 4) toString methodu olusturuyouz
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
