package findtheflat.bot.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Denis Berezanskiy on 31.07.2018.
 */
public class BotConfig
{
    public static final String BOT_CONFIGURATION_FILE = "./config/bot/bot.properties";
    
    public static String BOT_NAME;
    public static String BOT_TOKEN;
    public static String CHANNEL_NAME;
    
    public static void load()
    {
        Properties botSettings = new Properties();
        try (InputStream is = new FileInputStream(new File(BOT_CONFIGURATION_FILE)))
        {
            botSettings.load(is);
            is.close();
            System.out.println("Bot settings loaded successfully");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Bot settings loading failure");
        }
        //in case of empty values added default value
        BOT_NAME = botSettings.getProperty("botName", "FindOurFlatBot");
        BOT_TOKEN = botSettings.getProperty("botToken", "629832835:AAGXN1WRT2CE55xdi7-RpEtJ8RAq44tZKkA");
        CHANNEL_NAME = botSettings.getProperty("channelName", "@findourflat");
    }
}
