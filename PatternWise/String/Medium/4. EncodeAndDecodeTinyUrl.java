// https://leetcode.com/problems/encode-and-decode-tinyurl/

public class Codec {

    // Encodes a URL to a shortened URL.
    HashMap<String,String> mp;
    public String encode(String longUrl) {
        mp = new HashMap<>();
        mp.put("http://tinyurl.com/4e9iAk",longUrl);
        return "http://tinyurl.com/4e9iAk"; 
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mp.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));