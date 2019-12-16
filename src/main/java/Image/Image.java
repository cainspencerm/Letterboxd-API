package Image;

import org.json.JSONArray;
import org.json.JSONObject;

public class Image {

    // The available sizes for the image.
    private ImageSize[] sizes;

    public Image(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        // Define sizes.
        if (object.has("sizes")) {

            // Turn object into an array.
            JSONArray array = object.getJSONArray("sizes");

            sizes = new ImageSize[array.length()];
            for (int i = 0; i < sizes.length; i++) {
                sizes[i] = new ImageSize(array.get(i).toString());
            }
        } else {
            sizes = null;
        }

    }

    public ImageSize getImageSize(int position) {
        return sizes[position];
    }

    public ImageSize[] getImageSizes() {
        return sizes;
    }

}
