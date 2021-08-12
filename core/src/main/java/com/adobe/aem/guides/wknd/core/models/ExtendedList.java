package com.adobe.aem.guides.wknd.core.models;

import com.adobe.cq.wcm.core.components.models.List;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface ExtendedList extends List {

    default boolean showThumbnail() {
        return false;
    }

}