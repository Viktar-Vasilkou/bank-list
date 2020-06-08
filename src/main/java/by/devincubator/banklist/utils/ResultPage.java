package by.devincubator.banklist.utils;

public class ResultPage {

    public static String getPage(String title, String context) {
        String page = "<!DOCTYPE html>" + '\n'
                + "<html><head><title>" + title + "</title></head><body>" + '\n'
                + "<h1>RESULT: " + context + " </h1>" + '\n'
                + "</body></html>";
        return page;
    }
}
