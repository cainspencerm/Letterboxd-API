package Image;

import org.json.JSONObject;

public class ImageSize {

    // The image width in pixels.
    private int width;

    // The image height in pixels.
    private int height;

    // The URL to the image file.
    private String url;

    public ImageSize(String json) {

        // Convert json string to a usable object.
        JSONObject object = new JSONObject(json);

        width = object.has("width") ? object.getInt("width") : 0;
        height = object.has("height") ? object.getInt("height") : 0;
        url = object.has("url") ? object.getString("url") : null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }
}
