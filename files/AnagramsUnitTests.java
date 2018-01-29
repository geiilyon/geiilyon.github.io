

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnagramsUnitTests {

	@Test
	public void testIsAnagrams() {
		assertTrue(Anagrams.isAnagram("a", "a"));
		assertTrue(Anagrams.isAnagram("romain", "manoir"));
		assertTrue(Anagrams.isAnagram("ironique", "OniRique"));
		assertTrue(Anagrams.isAnagram("Romain", "manoir"));
		assertFalse(Anagrams.isAnagram("a", "b"));
	}

}
