package com.adobe.aem.guides.wknd.core.models;

/**
* Represents the Sticker AEM Component for the WKND Site project.
**/
public interface Sticker {
    /***
    * @return a string to display as the title.
    */
    String getTitle();

    /***
    * @return a string to display as the text.
    */
    String getText();

    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}
