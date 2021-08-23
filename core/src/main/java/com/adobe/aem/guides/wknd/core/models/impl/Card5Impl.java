
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
import com.adobe.aem.guides.wknd.core.models.Card5;
import com.adobe.cq.wcm.core.components.models.Image;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Card5.class},
        resourceType = {Card5Impl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Card5Impl implements Card5 {
    protected static final String RESOURCE_TYPE = "wknd/components/content/card5";

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
    private String linktext;

    @ValueMapValue
    private String link;

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
       return title;
    }

    @Override
    public String getLinktext() {
        //return i18n.get(linktext);
        return linktext;
    }

    @Override
    public String getLink() {
        //return i18n.get(link);
        return link;
    }

    @Override
    public String getText() {
        //return i18n.get(text);
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

    public boolean showImage() {
        final Image componentImage = getImage();
        if (componentImage == null || StringUtils.isBlank(componentImage.getSrc())) {
            // don't show image
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        

     /*   if (StringUtils.isBlank(title)) {
            // Title is missing, but required
            return true;
        } else if (StringUtils.isBlank(description)) {
            // Description is missing, but required
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
            // Everything is populated, so this component is not considered empty */
            return false;
        //}
    }

    /**
    * @return the Image Sling Model of this resource, or null if the resource cannot create a valid Image Sling Model.
    */
    private Image getImage() {
        return image;
    }
}

