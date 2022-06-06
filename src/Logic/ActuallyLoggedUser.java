package Logic;

public class ActuallyLoggedUser {

    private static ActuallyLoggedUser actuallyLoggedUser;
    private String loggedUser;


    private ActuallyLoggedUser(String loggedUser){
        this.loggedUser = loggedUser;
    }

    public static ActuallyLoggedUser getInstance(String value) {
        if (actuallyLoggedUser == null) {
            actuallyLoggedUser = new ActuallyLoggedUser(value);
        }
        return actuallyLoggedUser;
    }
}
