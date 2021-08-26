package com.adobe.aem.guides.wknd.core.models;

/**
* Represents the Hyperlink AEM Component for project.
**/
public interface Hyperlink {
    /***
    * @return a string to display as the url.
    */
    String getUrl();


    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}