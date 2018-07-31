package findtheflat.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Denis Berezanskiy on 31.07.2018.
 */
public class Parser
{
    public ArrayList<String> getUrlsFromOlx(String searchQuery)
    {
        ArrayList<String> urls = new ArrayList<>();
        Document doc = null;
        Elements elements = null;
        
        try
        {
            doc = Jsoup.connect(searchQuery).get();
            elements = doc.getElementsByAttributeValue("class","offer");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if(!elements.isEmpty())
        {
            for(Element element: elements)
            {
                String url = element.getElementsByTag("a").attr("href");
                if(url != null && !url.isEmpty() && url.contains("olx.pl"))
                {
                    urls.add(url);
                }
            }
        }
        return urls;
    }
}
