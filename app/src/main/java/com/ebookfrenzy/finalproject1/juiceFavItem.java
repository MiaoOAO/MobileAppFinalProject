package com.ebookfrenzy.finalproject1;

public class juiceFavItem {

    private String itemTitle;
    private String key_id;
    private int item_image;
    private String item_category;
    private String item_country;

    public juiceFavItem() {
    }

    public juiceFavItem(String itemTitle, String key_id, int item_image, String item_category ,String item_country) {
        this.itemTitle = itemTitle;
        this.key_id = key_id;
        this.item_image = item_image;
        this.item_category = item_category;
        this.item_country = item_country;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getItem_country() {
        return item_country;
    }

    public void setItem_country(String item_country) {
        this.item_country = item_country;
    }
}
