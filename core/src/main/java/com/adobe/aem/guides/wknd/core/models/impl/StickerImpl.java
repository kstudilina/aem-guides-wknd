
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
import com.adobe.aem.guides.wknd.core.models.Sticker;
import com.adobe.cq.wcm.core.components.models.Container;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Sticker.class},
        resourceType = {StickerImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class StickerImpl implements Sticker {
    protected static final String RESOURCE_TYPE = "wknd/components/content/card2";

    //I18 i18n = new I18n(slingRequest);
    //Locale pageLang = currentPage.getLanguage(false);
    //ResourceBundle resourceBundle = slingRequest.getResourceBundle(pageLang);
    //I18 i18n = new I18n(resourceBundle);

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    @Override
    public String getTitle() {
       // return i18n.get(title);
       return title;
    }

    @Override
    public String getText() {
        //return i18n.get(description);
        return text;
    }

    @Override
    public boolean isEmpty() {

        if (StringUtils.isBlank(title)) {
            // Title is missing, but required
            return true;
        } else if (StringUtils.isBlank(text)) {
            // Text is missing, but required
            return true;
        }
          else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }
}

