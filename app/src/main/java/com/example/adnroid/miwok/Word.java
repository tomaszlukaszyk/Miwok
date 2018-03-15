package com.example.adnroid.miwok;

/**
 * Holds two words (string objects), first is the miwok translation and other is default translation
 */

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    // default translation
    private String mDefaultTranslation;
    // Miwok translation word
    private String mMiwokTranslation;
    // resource ID for image depicting the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    // resource ID for audio file
    private int mAudioResourceId;

    /**
     * Create new Word object
     *
     * @param defaultTranslation is the word in language the user is using (such as English)
     * @param miwokTranslation   is the word in Miwok language
     * @param audioResourceId    is the resource ID for the file associated with this word
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create new Word object
     *
     * @param defaultTranslation is the word in language the user is using (such as English)
     * @param miwokTranslation   is the word in Miwok language
     * @param audioResourceId    is the resource ID for the file associated with this word
     * @param imageResourceId    is the resource ID for the image file associated with this word
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId, int imageResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    // get the default translation of the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    // get the Miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    // get the image resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //Returns whether or not there is an image for this word
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    // get the audio resource ID
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
