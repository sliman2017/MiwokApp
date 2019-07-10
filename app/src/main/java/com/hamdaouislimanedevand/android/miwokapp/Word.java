package com.hamdaouislimanedevand.android.miwokapp;

/**
 * Created by slimane on 09/09/18.
 */

public class Word {

    private String englishWord;
    private String miwokWord;
    private int emojis = NO_IMAGE_PROVIDER;
    private int idResourceAudio;
    private static final int NO_IMAGE_PROVIDER = -1;

    public Word(){}
    public Word(String englishWord, String miwokWord, int audioID){
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.idResourceAudio = audioID;
    }
    public Word(String englishWord, String miwokWord, int d, int audioID){
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.emojis = d;
        this.idResourceAudio = audioID;
    }

    public String getEnglishWord(){
        return englishWord;
    }
    public void setEnglishWord(String englishWord){
        this.englishWord = englishWord;
    }

    /**
     *
     * @return string of miwok word
     */
    public String getMiwokWord(){
        return miwokWord;
    }
    public int getEmojis(){
        return emojis;
    }

    /**
     *
     * @param miwokWord
     * @author slimane hamdaoui
     */
    public void setMiwokWord(String miwokWord){
        this.miwokWord = miwokWord;
    }
    public boolean hasImage(){
        return emojis != NO_IMAGE_PROVIDER;
    }

    public int getIdResourceAudio() {
        return idResourceAudio;
    }

    public void setIdResourceAudio(int idResourceAudio) {
        this.idResourceAudio = idResourceAudio;
    }
}
