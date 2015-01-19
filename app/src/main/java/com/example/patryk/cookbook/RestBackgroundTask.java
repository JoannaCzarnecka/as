package com.example.patryk.cookbook;


import com.example.patryk.cookbook.data.CookBook;
import com.example.patryk.cookbook.data.Recipe;
import com.example.patryk.cookbook.data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

@EBean
public class RestBackgroundTask {

    @RootContext
    MainActivity activity;

    @RestService
    CookbookRestClient restClient;

    @Background
    void getCookBook() {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            CookBook cookBook = restClient.getCookBook();
            publishResult(cookBook);
        } catch (Exception e) {
            publishError(e);
        }
    }

//    @Background
//    void addCookBookEntry(Recipe recipe) {
//        try {
//            restClient.setHeader("X-Dreamfactory-Application-Name", "phonebook");
//            restClient.addCookBookEntry(recipe);
//            CookBook cookBook = restClient.getCookBook();
//            publishResult(cookBook);
//        } catch (Exception e) {
//            publishError(e);
//        }
//    }

    @UiThread
    void publishResult(CookBook cookBook) {
        activity.updateCookbook(cookBook);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
