package com.talentscity.com.dto;


public class SearchRequestDTO {
    private String searchWord;

    public SearchRequestDTO(String searchWord) {
        this.searchWord = searchWord;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
