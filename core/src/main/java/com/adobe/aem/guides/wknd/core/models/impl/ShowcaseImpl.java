package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import com.adobe.aem.guides.wknd.core.models.Showcase;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Showcase.class},
        resourceType = {ShowcaseImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ShowcaseImpl implements Showcase {
    protected static final String RESOURCE_TYPE = "wknd/components/content/showcase";

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

    @Override
    public String getTitle() {
       // return i18n.get(title);
       return title;
    }

    @Override
    public boolean isEmpty() {

        if (StringUtils.isBlank(title)) {
            // Title is missing, but required
            return true;
        }
        else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }
}

