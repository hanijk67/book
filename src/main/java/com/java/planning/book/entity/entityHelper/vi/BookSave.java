package com.java.planning.book.entity.entityHelper.vi;

import com.java.planning.book.entity.Genre;

public record BookSave(
        String title,
        String author,
        int year,
        Genre genre,
        int pages,
        String description,
        String publisher,
        String language,
        String isbn,
        String url,
        String image,
        String thumbnail
) {


}
