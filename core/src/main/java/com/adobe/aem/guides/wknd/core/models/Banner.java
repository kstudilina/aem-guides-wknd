package com.adobe.aem.guides.wknd.core.models;


/**
* Represents the Banner AEM Component for the WKND Site project.
**/
public interface Banner {
    /***
    * @return a string to display as the title.
    */
    String getTitle();

    /***
    *
    *
    * @return a subtitle.
    */
    String getSubtitle();

    /***
    * @return a string to display as the extra text.
    */
    String getText();

    /***
    * @return a string to display as the buttontext.
    */
    String getButtontext();

    /***
    * @return a string to display as the buttonlink.
    */
    String getButtonlink();

    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}
