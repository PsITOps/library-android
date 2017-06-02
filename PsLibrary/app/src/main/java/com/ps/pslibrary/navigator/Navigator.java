package com.ps.pslibrary.navigator;

import android.content.Context;

import pslibrary.api.books.model.Book;

public interface Navigator {

    void openRegisterActivity(Context context);

    void openBooksActivity(Context context);

    void openMyBooksActivity(Context context);

    void openBookInformationActivity(Context context, Book book, boolean isFromMyBooks);

    void openAddBookActivity(Context context);
}
