package Main;


  /* TwitterClient Application
   * Uses Twitter4j library (java)
   * Uses Twitter API 1.1
   * Elisha - Simple Developer
   */
 
 
   import twitter4j.*;
   import twitter4j.auth.AccessToken;
 
   import java.io.IOException;
   import java.net.URL;
   import java.util.Arrays;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
 
   class TweetUsingTwitter4JExample {
 
     public static void main(String[] args) throws IOException, TwitterException {
 
        //Your Twitter App's Consumer Key
        String CONSUMER_KEY = "Mr1OkGd83QosHgHMSmMS7kTX4";
 
        //Your Twitter App's Consumer Secret
        String CONSUMER_SECRET = "ihqo2ajcz3ka72G4W533eR6oobfcOlBipahqsbP3nOqPaWc3Hg";
 
        //Your Twitter Access Token
       String ACCESS_TOKEN = "822684388366450688-fgPjlJCFxqHb914IkMv2x1nXkaDFRaO";
 
        //Your Twitter Access Token Secret
        String accessTokenSecret = "OqB9eJB4IfFPPnfZ5JdHCsVTkhuD24f8wJvE3emzE9tJQ";
 
ConfigurationBuilder builder = new ConfigurationBuilder();
builder.setOAuthConsumerKey(CONSUMER_KEY);
builder.setOAuthConsumerSecret(CONSUMER_SECRET);
Configuration configuration = builder.build();
TwitterFactory factory = new TwitterFactory(configuration);
Twitter twitter = factory.getInstance();
 twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN,accessTokenSecret));
        //Instantiate and initialize a new twitter status update
        StatusUpdate statusUpdate = new StatusUpdate(
                //your tweet or status message
                "3.14");
      
        //tweet or update status
        Status status = twitter.updateStatus(statusUpdate);
 
        //response from twitter server
        System.out.println("status.toString() = " + status.toString());
        System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
        System.out.println("status.getSource() = " + status.getSource());
        System.out.println("status.getText() = " + status.getText());
        
        System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
        System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));
    }
 
  }
 