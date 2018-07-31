package findtheflat.bot;

import findtheflat.bot.config.BotConfig;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Denis Berezanskiy on 31.07.2018.
 */
@Component
public class Bot extends TelegramLongPollingBot
{
    public static String searchQuery;
    
    @Override
    public void onUpdateReceived(Update update)
    {
        if(update.hasChannelPost() && update.getChannelPost().getText().contains("olx.pl"))
        {
            searchQuery = update.getChannelPost().getText();
        }
    }
    
    @Override
    public String getBotUsername()
    {
        return BotConfig.BOT_NAME;
    }
    
    @Override
    public String getBotToken()
    {
        return BotConfig.BOT_TOKEN;
    }
    
    //Here is scheduling interval
    @Scheduled(fixedRate = 1000)
    public void sendMessage()
    {
        //url with ad must be delegated here
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String message = dateFormat.format(new Date());
        String urlString = "https://api.telegram.org/bot" + BotConfig.BOT_TOKEN + "/sendMessage?chat_id=" + BotConfig.CHANNEL_NAME + "&text=" + message;
        
        try
        {
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            InputStream is = new BufferedInputStream(con.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
