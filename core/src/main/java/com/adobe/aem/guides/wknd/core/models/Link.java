package com.adobe.aem.guides.wknd.core.models;

/**
* Represents the Link AEM Component for project.
**/
public interface Link {
    /***
    * @return a string to display as the url.
    */
    String getUrl();


    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}