package eu.strasbourg.utils.exception;

public class SiteUpdaterException  extends Exception {
    public SiteUpdaterException(String message) {
        super(message);
    }

    public SiteUpdaterException(Exception e) {
        super(e);
    }
}
