package com.gameexchange.gameexchange.service.dto.IGDB_API;

/**
 * Created by MARKT on 26/5/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cover {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("cloudinary_id")
    @Expose
    private String cloudinaryId;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;

    /**
     * No args constructor for use in serialization
     *
     */
    public Cover() {
    }

    /**
     *
     * @param cloudinaryId
     * @param height
     * @param width
     * @param url
     */
    public Cover(String url, String cloudinaryId, Integer width, Integer height) {
        super();
        this.url = url;
        this.cloudinaryId = cloudinaryId;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCloudinaryId() {
        return cloudinaryId;
    }

    public void setCloudinaryId(String cloudinaryId) {
        this.cloudinaryId = cloudinaryId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
