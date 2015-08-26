package com.sirafelagi.test.jpa.services;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import com.sirafelagi.test.jpa.entities.Item;
import com.sirafelagi.test.jpa.exception.RSSException;
import com.sirafelagi.test.jpa.rss.TRss;
import com.sirafelagi.test.jpa.rss.TRssChannel;
import com.sirafelagi.test.jpa.rss.TRssItem;

@Service
public class RssService {
	public List<Item> getItems(String url)throws RSSException{
		return getItems(new StreamSource(url));
	}
	public List<Item> getItems(File file)throws RSSException{
		return getItems(new StreamSource(file));
	}
	private List<Item> getItems(Source source) throws RSSException{
		ArrayList<Item> list=new ArrayList<Item>();
		try {
			JAXBContext jaxbContext= JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement=unmarshaller.unmarshal(source,TRss.class);
			TRss rss=jaxbElement.getValue();
			List<TRssChannel>channels=rss.getChannel();
			for(TRssChannel channel:channels){
				List<TRssItem>items=channel.getItem();
				for(TRssItem rssItem:items){
					Item item=new Item();
					item.setTitle(rssItem.getTitle());
					item.setDescription(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					Date pubDate;
						pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).parse(rssItem.getPubDate());
					item.setPublishedDate(pubDate);
					list.add(item);
				}
			}
		} catch (JAXBException e) {
			throw new RSSException(e);
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
