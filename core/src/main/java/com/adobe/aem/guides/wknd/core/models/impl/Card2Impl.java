
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
import com.adobe.aem.guides.wknd.core.models.Card2;
import com.adobe.cq.wcm.core.components.models.Image;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Card2.class},
        resourceType = {Card2Impl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Card2Impl implements Card2 {
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
    private String titlesize;

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
    public String getTitlesize() {
        //return i18n.get(description);
        return titlesize;
    }

    @Override
    public boolean isEmpty() {
        final Image componentImage = getImage();

        if (StringUtils.isBlank(title)) {
            // Title is missing, but required
            return true;
        } else if (StringUtils.isBlank(titlesize)) {
            // Description is missing, but required
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

