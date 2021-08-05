package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

/**
* Represents the Card AEM Component for the WKND Site project.
**/
public interface Card {
    /***
    * @return a string to display as the title.
    */
    String getTitle();

    /***
    * @return a string to display as the description.
    */
    String getDescription();

     /***
    * @return a string to display as the button text.
    */
    String getButtontext();

     /***
    * @return a string to display as the button link.
    */
    String getButtonlink();

    

    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}