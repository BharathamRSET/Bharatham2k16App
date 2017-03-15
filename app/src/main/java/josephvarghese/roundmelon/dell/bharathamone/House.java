package josephvarghese.roundmelon.dell.bharathamone;

/**
 * Created by DELL on 16-08-2016.
 */
public class House {


    //name and address string
    private String aryans;
    private String mughals;
    private String rajputs;
    private String spartans;
    private String vikings;

    public House() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters


    public String getAryans() {
        return aryans;
    }

    public void setAryans(String aryans) {
        this.aryans = aryans;
    }

    public String getMughals() {
        return mughals;
    }

    public String getAll() {
        return aryans+" "+mughals+" "+spartans+" "+mughals+" "+vikings;
    }
    public void setMughals(String mughals) {
        this.mughals = mughals;
    }

    public String getRajputs() {
        return rajputs;
    }

    public void setRajputs(String rajputs) {
        this.rajputs = rajputs;
    }

    public String getSpartans() {
        return spartans;
    }

    public void setSpartans(String spartans) {
        this.spartans = spartans;
    }

    public String getVikings() {
        return vikings;
    }

    public void setVikings(String vikings) {
        this.vikings = vikings;
    }
}

