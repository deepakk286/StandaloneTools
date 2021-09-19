package miscellaneous;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLLoop {

    static String urlToHit = "http://example.com";

    public static void main(String[] args) throws Exception {
        // write your code here
        //hitURLInLoopWithWaitTime(1000, 100, urlToHit);
        if(args[0] != null) {
            urlToHit = args[0];
        }
        hitURLinLoopAndPrintResponse(500, urlToHit);
    }

    private static void hitURLInLoopWithWaitTime(int sleepTime, int loopCount, String url) throws Exception {
        while(loopCount > 0) {
            loopCount--;
            hitURLinLoopAndPrintResponse(1, url);
            Thread.sleep(sleepTime);
        }
    }


    public static void hitURLinLoopAndPrintResponse(int loopCount, String url) throws Exception{
        while(loopCount > 0) {
            loopCount --;
            hitURLAndPrintResponse(url);
        }
    }

    public static void hitURLAndPrintResponse(String url) {
        try {
            URL yahoo = new URL(url);
            HttpURLConnection yc = (HttpURLConnection) yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            //while ((inputLine = in.readLine()) != null)
            //System.out.println("Resp code ==> " +  yc.getResponseCode());//NOI18N
            in.close();
        } catch ( Exception e ) {
            //System.out.println(" error " + e.getMessage());//NOI18N
        }
    }
}
