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
    public ArrayList<String> getUrlsFromOlxPl(String searchQuery)
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
    public ArrayList<String> getUrlsFromGratkaPl(String searchQuery)
    {
        ArrayList<String> urls = new ArrayList<>();
        Document doc = null;
        Elements elements = null;
        
        try
        {
            doc = Jsoup.connect(searchQuery).get();
            elements = doc.getElementsByAttributeValueContaining("id","offer");
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
                if(url != null && !url.isEmpty() && url.contains("gratka.pl"));
                {
                    urls.add(url);
                }
            }
        }
        return urls;
    }
    public ArrayList<String> getUrlsFromOtodomPl(String searchQuery)
    {
        ArrayList<String> urls = new ArrayList<>();
        Document doc = null;
        Elements elements = null;
    
        try
        {
            doc = Jsoup.connect(searchQuery).get();
            elements = doc.getElementsByAttributeValueContaining("class","offer-item-details");
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
                if(url != null && !url.isEmpty() && url.contains("otodom.pl"))
                {
                    urls.add(url);
                }
            }
        }
        return urls;
    }
    public ArrayList<String> getUrlsFromGumtreePl(String searchQuery)
    {
        ArrayList<String> urls = new ArrayList<>();
        Document doc = null;
        Elements elements = null;
        String url = "https://www.gumtree.pl";
        
        try
        {
            doc = Jsoup.connect(searchQuery).get();
            elements = doc.getElementsByAttributeValue("class","result-link  ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if(!elements.isEmpty())
        {
            for(Element element: elements)
            {
                    url += element.getElementsByTag("a").attr("href");
                    if(url != null && !url.isEmpty() )
                    {
                        urls.add(url);
                    }
            }
        }
        return urls;
    }
}

