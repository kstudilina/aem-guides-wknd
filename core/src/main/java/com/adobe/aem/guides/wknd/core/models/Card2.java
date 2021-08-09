package com.adobe.aem.guides.wknd.core.models;

/**
* Represents the Card AEM Component for the WKND Site project.
**/
public interface Card2 {
    /***
    * @return a string to display as the title.
    */
    String getTitle();

    /***
    * @return a string to display as the title size.
    */
    String getTitlesize();


    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}