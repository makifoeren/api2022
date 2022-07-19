package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
// post yaptigimizda id atiyor onu assert te yoksaymasi icin kullaniliyor karsilastirmadaki fazlaliklari yok sayiyor
// Farkli key-value uyusmazligini @JsonIgnoreProperties(ignoreUnknown = true)
// anotation ini pojo classimizin basina yazarak cozebiliriz
public class JsonPlaceHolderPojo {

    /*
    1) Tum keyler icin private variable lar olusturuyoruz
    2) Tum parametrelerle ve parametresiz constructor olusturulur parmetresiz-- defaulf kalktigi icin bos u default yerine yapiyoruz
    3) Getters ve setters lari olusturuyoruz
    4) toString methodu olusturuyouz

     */

     // 1 ) Tum keyler icin private variable lar olusturuyoruz.
     private Integer userId;
     private String title;
     private Boolean completed;


    //2) Tum parametrelerle ve parametresiz constructor olusturulur parmetresiz

    public JsonPlaceHolderPojo() {

    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }


    //3 ) Getters ve setters lari olusturuyoruz


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4) toString methodu olusturuyouz


    @Override
    public String toString() { // string typin de okumamizi sagliyor
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

