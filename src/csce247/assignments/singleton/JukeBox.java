package csce247.assignments.singleton;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cameron Brandenburg
 * JukeBox that can play music, request music, and see the next songs
 */
public class JukeBox {

	/**
	 * A queue of strings for the song name built using the Queue interface
	 */
	private Queue<String> songQueue = new LinkedList<String>();
	
	/**
	 * A static instance of JukeBox
	 */
	private static JukeBox jukeBox;
	
	/**
	 * Empty constructor for the singleton method
	 */
	private JukeBox() {}
	
	/**
	 * Returns an instance of JukeBox. If there is no existing instance of JukeBox, one is created
	 * @return jukeBox the instance of JukeBox
	 */
	public static JukeBox getInstance() {
		if (jukeBox == null) {
			System.out.println("Initializing the JukeBox!!! Let's get Dancing");
			jukeBox = new JukeBox();
		}
		return jukeBox;
	}
	
	/**
	 * Prints the name of the song and then removes it from the queue.
	 * If there are no songs in the queue, then a message is printed to the console
	 */
	public void playNextSong() {
		if (this.hasMoreSongs()) {
			System.out.println("Let's jam to " + songQueue.peek());
			songQueue.remove();
		}
		else {
			System.out.println("You need to add songs to the list");
		}
	}
	
	/**
	 * Adds a new song to the queue and prints out what number it is in the queue
	 * @param songName A string of the song name
	 */
	public void requestSong(String songName) {
		System.out.println(songName + " is now number " + (songQueue.size()+1) + " on the list");
		songQueue.add(songName);
	}
	
	/**
	 * Returns true if the song queue has more songs and false otherwise
	 * @return a boolean value if the queue is (not) empty
	 */
	public boolean hasMoreSongs() {
		if (!songQueue.isEmpty())
			return true;
		else 
			return false;
	}
}
