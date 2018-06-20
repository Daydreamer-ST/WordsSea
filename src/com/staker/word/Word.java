package com.staker.word;

import cn.bmob.v3.*;

public class Word extends BmobObject
{
	private String Word;
    private String Translate;
	private String Phrase;
	private String Stars;
	private String id;

	public void save(Object done)
	{
		// TODO: Implement this method
	}

    public String getWord() {
        return Word;
    }
    public void setWord(String Word) {
        this.Word = Word;
    }
    public String getTranslate() {
        return Translate;
    }
    public void setTranslate(String Translate) {
        this.Translate = Translate;
    }
	public String getPhrase() {
        return Phrase;
    }
    public void setPhrase(String Phrase) {
        this.Phrase = Phrase;
	}
	public String getStars() {
        return Stars;
    }
    public void setStars(String Stars) {
        this.Stars = Stars;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
