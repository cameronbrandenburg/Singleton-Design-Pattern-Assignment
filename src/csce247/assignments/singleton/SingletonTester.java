package csce247.assignments.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Cameron Brandenburg
 * JUnit test cases for the JukeBox class
 */
class SingletonTester {
	
	/**
	 * Tests that the JukeBox is instantiated correctly
	 */
	@Test
	public void testInstantiate() {
		assertNotNull(JukeBox.getInstance());
	}
	/**
	 * Tests that the JukeBox does not instantiate more than one JukeBox
	 */
	@Test
	public void testMultipleInstantiations() {
		JukeBox.getInstance();
		assertNotNull(JukeBox.getInstance());
	}

	/**
	 * Tests requesting a song
	 */
	@Test
	public void testAddSong() {
		JukeBox.getInstance().requestSong("Test Song 1");
		assertTrue(JukeBox.getInstance().hasMoreSongs());
	}
	
	/**
	 * Tests playing a song and makes sure that song gets removed from the song queue
	 */
	@Test
	public void testPlaySong() {
		JukeBox.getInstance().playNextSong();
		assertFalse(JukeBox.getInstance().hasMoreSongs());
	}
	
	/**
	 * Tests playing a song when the queue is empty
	 */
	@Test
	public void testPlayAll() {
		JukeBox.getInstance().playNextSong();
		JukeBox.getInstance().playNextSong();
		assertFalse(JukeBox.getInstance().hasMoreSongs());
	}
	
	/**
	 * Tests the hasMoreSongs method when there are no songs
	 */
	@Test void testHasMoreSongsEmpty() {
		JukeBox.getInstance().playNextSong();
		assertFalse(JukeBox.getInstance().hasMoreSongs());
	}
	
	/**
	 * Tests the hasMoreSongs method when there is a song
	 */
	@Test
	public void testHasMoreSongs() {
		JukeBox.getInstance().requestSong("Test Song 2");
		assertTrue(JukeBox.getInstance().hasMoreSongs());
	}
	
	

}
