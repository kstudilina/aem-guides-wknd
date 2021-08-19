
package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.Collections;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import com.adobe.aem.guides.wknd.core.models.Card3;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Card3.class},
        resourceType = {Card3Impl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Card3Impl implements Card3 {
    protected static final String RESOURCE_TYPE = "wknd/components/content/card3";

    //I18 i18n = new I18n(slingRequest);
    //Locale pageLang = currentPage.getLanguage(false);
    //ResourceBundle resourceBundle = slingRequest.getResourceBundle(pageLang);
    //I18 i18n = new I18n(resourceBundle);

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String buttontext;

    @ValueMapValue
    private String buttonlink;

    @Override
    public String getText() {
       // return i18n.get(text);
       return text;
    }

    @Override
    public String getButtontext() {
       // return i18n.get(buttontext);
       return buttontext;
    }

    @Override
    public String getButtonlink() {
        return buttonlink;
    }

    @Override
    public boolean isEmpty() {

        if (StringUtils.isBlank(text)) {
            // Text is missing, but required
            return true;
        }else if (StringUtils.isBlank(buttontext)) {
            // Button text missing, but required
            return true;
        }else if (StringUtils.isBlank(buttonlink)) {
            // Button link missing, but required
            return true;
        }
         else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }
}

