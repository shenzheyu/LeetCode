import org.junit.Assert;
import org.junit.Test;

public class TrieTest {



    @Test
    public void insertTest() {
        Trie obj = new Trie();
        obj.insert("abc");
        obj.insert("start");
        obj.insert("test");
    }

    @Test
    public void searchTest() {
        Trie obj = new Trie();
        obj.insert("abc");
        obj.insert("start");
        obj.insert("test");
        Assert.assertTrue(obj.search("abc"));
        Assert.assertFalse(obj.search("ab"));
        Assert.assertFalse(obj.search("a"));
        Assert.assertFalse(obj.search("bed"));
        obj.insert("ab");
        Assert.assertTrue(obj.search("ab"));
    }

    @Test
    public void startsWithTest() {
        Trie obj = new Trie();
        obj.insert("abc");
        obj.insert("start");
        obj.insert("test");
        Assert.assertTrue(obj.startsWith("abc"));
        Assert.assertTrue(obj.startsWith("a"));
        Assert.assertFalse(obj.startsWith("bed"));
    }

}
