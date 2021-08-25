
package com.adobe.aem.guides.wknd.core.models.impl;


import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import com.adobe.aem.guides.wknd.core.models.Link;
import com.adobe.cq.wcm.core.components.models.Text;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Link.class},
        resourceType = {LinkImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class LinkImpl implements Link {
    protected static final String RESOURCE_TYPE = "wknd/components/content/link";

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String url;

    private Text text;

    @PostConstruct
    private void init() {
        text = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Text.class);
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public boolean isEmpty() {
        final Text componentText = getText();

        if (StringUtils.isBlank(url)) {
            // Url is missing, but required
            return true;
        } else if (componentText == null) {
            // Text is required
            return true;
        } else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }

    /**
    * @return the Text Sling Model of this resource, or null if the resource cannot create a valid Image Sling Model.
    */
    private Text getText() {
        return text;
    }
}

