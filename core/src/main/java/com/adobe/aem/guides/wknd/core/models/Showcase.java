package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

/**
* Represents the Showcase AEM Component for the WKND Site project.
**/
public interface Showcase {
    /***
    * @return a string to display as the title.
    */
    String getTitle();

    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}