/**
 * 
 */
package com.systa.algo.designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mohsin
 * 
 * The pattern is formally defined as a one to many dependency between objects so that when one object changes state all the dependents are notified.
 *
 */

/*
 * NewsAgency is an observable, and when news gets updated, the state of NewsAgency changes. 
 * When the change happens, NewsAgency notifies the observers about this fact by calling their update() method.
 */
class NewsAgency{
	private List<Channel> channels = new ArrayList<>();
	
	public void addObserver(Channel channel) {
		for(Channel ch : channels) {
			if(ch.getChannelId() == channel.getChannelId()) {
				// channel cannot be added, since channel with same id already exists.
				return;
			}			
		}
		
		channels.add(channel);
	}
	
	public void removeObserver(Channel channel) {
		for(Channel ch : channels) {
			if(ch.getChannelId() == channel.getChannelId()) {
				channels.remove(channel); // only remove channel if it exists in the list
			}
		}
	}
	
	public void publishNews(String news) {
		channels.forEach(x -> x.update(news));
	}
	
}

/*
 * All classes which implements channel will Observers. 
 * It should have the update() method which is invoked when the state of NewsAgency changes, means when the news is added to news agency object
 */
interface Channel{
	
	public void update(String news);
	
	public long getChannelId();
	
	public String getChannelName();
}

class ChannelA implements Channel{

	@Override
	public void update(String news) {
		System.out.println("New for Channel A is " + news);
		// also perform actions specific to channel A.		
	}

	@Override
	public long getChannelId() {
		return 1l;
	}

	@Override
	public String getChannelName() {
		return "Channel A";		
	}
	
}

class ChannelB implements Channel{

	@Override
	public void update(String news) {
		System.out.println("New is for Channel B is " + news);
		// also perform actions specific to channel B.		
	}

	@Override
	public long getChannelId() {
		return 2l;
	}

	@Override
	public String getChannelName() {
		return "Channel B";		
	}	
}

public class ObserverPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NewsAgency agency = new NewsAgency();
		
		Channel channelA = new ChannelA();
		agency.addObserver(channelA);
		
		Channel channelB = new ChannelB();
		agency.addObserver(channelB);
		
		agency.publishNews("This is a demo");

	}

}
