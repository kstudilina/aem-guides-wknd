
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
import com.adobe.aem.guides.wknd.core.models.ExtendedList;
import com.adobe.cq.wcm.core.components.models.List;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {ExtendedList.class},
        resourceType = {ExtendedListImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ExtendedListImpl implements ExtendedList {
    protected static final String RESOURCE_TYPE = "wknd/components/content/extendedlist";

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

    
}

