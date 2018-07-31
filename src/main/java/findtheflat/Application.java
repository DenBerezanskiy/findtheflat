package findtheflat;

import findtheflat.bot.Bot;
import findtheflat.bot.config.BotConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by Denis Berezanskiy on 31.07.2018.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class Application
{
    public static void main(String[] args)
    {
        botInit();
        SpringApplication.run(Application.class,args);
    }
    
    private static void botInit()
    {
        BotConfig.load();
        ApiContextInitializer.init();
        System.out.println("Context initialized.");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try
        {
            telegramBotsApi.registerBot(new Bot());
            System.out.println("Bot registred successfully");
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }
}

