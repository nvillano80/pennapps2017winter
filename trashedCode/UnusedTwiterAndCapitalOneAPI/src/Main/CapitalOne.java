package Main;

//import org.JSONArray;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CapitalOne{
	public static class Post{
		public static void postCustomer(){
			try {
//			  HttpRequestWithBody request = Unirest.post("http://api.reimaginebanking.com/customers").body("");
				// configure request
//HttpRequestWithBody request = new HttpRequestWithBody(HttpMethod.POST, "http://api.reimaginebanking.com/customer");
	//			request.body("");
		HttpRequestWithBody request = Unirest.post("http://api.reimaginebanking.com/customers");		
		request.queryString("key", API_KEY);
		request.header("accept", "application/json");
		request.header("Content-Type", "application/json");
		request.body("{\"first_name\": \"Joe\",\"last_name\": \"Test\",\"address\": {\"street_number\": \"string\",\"street_name\": \"string\",\"city\": \"string\",\"state\": \"PA\",\"zip\": \"12345\"}}");
// send request
				HttpResponse<JsonNode> jsonResponse = request.asJson();
				jsonResponse.toString();
			System.out.println(jsonResponse.getBody().toString());
//				
//			//	HttpResponse<JsonNode> jsonResponse = Unirest.post("http://api.reimaginebanking.com/customers")
//				//	.header("accept", "application/json")
//					//.queryString("apiKey", API_KEY)
//					//.field("parameter", "value")
//					.field("foo", "bar")
//					.asJson();
			} catch (UnirestException ex) {
				Logger.getLogger(CapitalOne.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
public static final String API_KEY="b84d3a153e2842b8465bcc4fde3d1839";
	public static void main(String...args){
	//testing 
	HTMLGetter get = new HTMLGetter("https://api-sandbox.capitalone.com/branches?key=b84d3a153e2842b8465bcc4fde3d1839");
	//Post.postCustomer();
	get.printHTML();
}
/**
 * Gets HTML code from a web site. You must have access to the Internet to use
 * this class.
 *
 * @author Nick Villano
 * @version 0.0
 */
public static class HTMLGetter{
@Override
public String toString(){
	String s = "";
	for(String S:html){
		s+=S;
	}
	return s;
}
    /**
     * The String representation of URL that the HTML is coming from
     *
     * @since 0.0
     */
    private URL url;
    /**
     * The HTML pulled from the site
     *
     * @since 0.0
     */
    private ArrayList<String> html = new ArrayList<>();

    /**
     * Creates a new HTMLCode object and sets the URL and HTML.
     *
     * @since 0.0
     * @param inURL the URL to get the HTML code from this must contain the
     * http://www. or https://www. and the .com or similar things
     */
    public HTMLGetter(String inURL) {

        InputStream is = null;

        DataInputStream dis;

        String s;

        try {

            url = new URL(inURL);

            is = url.openStream();

            dis = new DataInputStream(new BufferedInputStream(is));
            int counter = 0;
            while ((s = dis.readLine()) != null) {
                html.add(s);
                //System.out.println(s);
                counter++;
            }

        } catch (MalformedURLException mue) {

            System.out.println("Ouch - a MalformedURLException happened.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Oops- an IOException happened.");
            System.exit(1);
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
            }
        }
    }

    /**
     * Gets the URL.
     *
     * @return the URL that the HTML code is came from=
     */
    public URL getURL() {
        return url;
    }

    /**
     * Gets the URL in String form.
     *
     * @return the URL in String form
     */
    public String getURLString() {
        return url.toString();
    }

    /**
     * Gets the HTML code for the URL
     *
     * @return the HTML code in the form of an ArrayList of type String with
     * each index containing one line of HTML code
     */
    public ArrayList<String> getHTML() {
        return html;
    }

    /**
     * Prints the URL
     */
    public void printURL() {
        url.toString();
    }

    /**
     * Prints the HTML code
     */
    public void printHTML() {
        for (String n : html) {
            System.out.println(n);
        }
    }
	}
}