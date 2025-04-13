package com.java.planning.book.entity.entityHelper.vi;

public record BookSearch(
        Integer from,
        Integer to,
        String title,
        Integer year
) {
    public BookSearch {
        from = from == null ? 0 : from;
        to = to == null ? 10 : to;
        title = title == null ? "" : title;
        year = year == null ? -1 : year;
    }
}
