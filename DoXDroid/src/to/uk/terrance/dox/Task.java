package to.uk.terrance.dox;

import java.util.ArrayList;
import java.util.Arrays;

import android.graphics.Color;

public class Task {

    // Task priority values
    public static int PRI_LOW = 0;
    public static int PRI_MEDIUM = 1;
    public static int PRI_HIGH = 2;
    public static int PRI_CRITICAL = 3;

    // Task priority enumeration
    public static String[] PRI_NAMES = new String[]{"Low", "Medium", "High", "Critical"};
    public static int[] PRI_COLOURS = new int[]{Color.GRAY, Color.rgb(255, 171, 0), Color.rgb(255, 85, 0), Color.rgb(224, 0, 0)}; 

    // Task fields
    private String mId;
    private String mTitle;
    private String mDesc;
    private int mPri;
    private DueDate mDue;
    private Repeat mRepeat;
    private ArrayList<String> mTags;

    // Main constructor
    public Task(String id, String title, String desc, int pri, DueDate due, Repeat repeat, ArrayList<String> tags) {
        mId = id;
        mTitle = title;
        mDesc = desc;
        mPri = pri;
        mDue = due;
        mRepeat = repeat;
        mTags = tags;
    }
    // Empty constructor (to selectively add fields)
    public Task() {
        mPri = 0;
        mTags = new ArrayList<String>();
    }

    // Getters and setters
    public String getId() {
        return mId;
    }
    public void setId(String id) {
        mId = id;
    }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
    public String getDesc() {
        return mDesc;
    }
    public void setDesc(String desc) {
        mDesc = desc;
    }
    public int getPri() {
        return mPri;
    }
    public void setPri(int pri) {
        mPri = pri;
    }
    public DueDate getDue() {
        return mDue;
    }
    public void setDue(DueDate due) {
        mDue = due;
    }
    public Repeat getRepeat() {
        return mRepeat;
    }
    public void setRepeat(Repeat repeat) {
        mRepeat = repeat;
    }
    public ArrayList<String> getTags() {
        return mTags;
    }
    public void setTags(ArrayList<String> tags) {
        mTags = tags;
    }
    public void parseTags(String tagString) {
        mTags = new ArrayList<String>(Arrays.asList(tagString.split("/,/g")));
        for (int i = 0; i < mTags.size(); i++) {
            mTags.set(i, mTags.get(i).trim());
        }
    }

    // Task ID generator
    public static String newID() {
        String id = Integer.toHexString((int) Math.floor(Math.random() * 1048576));
        while (id.length() < 5) {
            id = "0" + id;
        }
        return id;
    }

    // Custom string representation
    @Override
    public String toString() {
        return mTitle;
    }

}
