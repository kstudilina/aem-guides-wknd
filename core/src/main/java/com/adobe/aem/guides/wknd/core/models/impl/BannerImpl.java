
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
import com.adobe.aem.guides.wknd.core.models.Banner;
import com.adobe.cq.wcm.core.components.models.Image;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Banner.class},
        resourceType = {BannerImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BannerImpl implements Banner {
    protected static final String RESOURCE_TYPE = "wknd/components/content/card";

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
    private String subtitle;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String buttontext;

    @ValueMapValue
    private String buttonlink;

    private Image image;

    @PostConstruct
    private void init() {
        image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
    }

    @Override
    public String getTitle() {
       // return i18n.get(title);
       return title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
    }

    @Override
    public String getSubtitle() {
        //return i18n.get(description);
        return subtitle.substring(0, 1).toUpperCase() + subtitle.substring(1).toLowerCase();
    }

    @Override
    public String getText() {
       // return i18n.get(buttontext);
       return text.toUpperCase();
    }

    @Override
    public String getButtontext() {
       // return i18n.get(buttontext);
       return buttontext.substring(0, 1).toUpperCase() + buttontext.substring(1).toLowerCase();
    }

    @Override
    public String getButtonlink() {
        return buttonlink;
    }

    @Override
    public boolean isEmpty() {
        final Image componentImage = getImage();

        if (StringUtils.isBlank(title)) {
            // Title is missing, but required
            return true;
        } else if (StringUtils.isBlank(subtitle)) {
            // Subtitle is missing, but required
            return true;
        }else if (StringUtils.isBlank(text)) {
            // Text is missing, but required
            return true;
        }else if (StringUtils.isBlank(buttontext)) {
            // Button text missing, but required
            return true;
        }else if (StringUtils.isBlank(buttonlink)) {
            // Button link missing, but required
            return true;
        }
         else if (componentImage == null || StringUtils.isBlank(componentImage.getSrc())) {
            // A valid image is required
            return true;
        } else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }

    /**
    * @return the Image Sling Model of this resource, or null if the resource cannot create a valid Image Sling Model.
    */
    private Image getImage() {
        return image;
    }
}

