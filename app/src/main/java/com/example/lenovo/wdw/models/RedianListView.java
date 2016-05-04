package com.example.lenovo.wdw.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dkk on 2016/4/11.
 */
public class RedianListView implements Parcelable {
    private int type;
    private String ltitle;
    private String digest;
    private String url;
    private String imgsrc;
    private String lmodify;
    private String source;

    protected RedianListView(Parcel in) {
        type = in.readInt();
        ltitle = in.readString();
        digest = in.readString();
        url = in.readString();
        imgsrc = in.readString();
        lmodify = in.readString();
        source = in.readString();
    }

    public static final Creator<RedianListView> CREATOR = new Creator<RedianListView>() {
        @Override
        public RedianListView createFromParcel(Parcel in) {
            return new RedianListView(in);
        }

        @Override
        public RedianListView[] newArray(int size) {
            return new RedianListView[size];
        }
    };

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeString(ltitle);
        dest.writeString(digest);
        dest.writeString(url);
        dest.writeString(imgsrc);
        dest.writeString(lmodify);
        dest.writeString(source);
    }
}
