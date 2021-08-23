package com.adobe.aem.guides.wknd.core.models;

/**
* Represents the Card5 AEM Component for the WKND Site project.
**/
public interface Card5 {
    /***
    * @return a string to display as the title.
    */
    String getTitle();

    /***
    * @return a string to display as the link text.
    */
    String getLinktext();

    /***
    * @return a string to display as the link.
    */
    String getLink();

    /***
    * @return a string to display as the text.
    */
    String getText();

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