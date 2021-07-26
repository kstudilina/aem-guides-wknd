/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.wknd.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import java.util.Optional;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HelloWorldModel {

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE)
    @Default(values="No resourceType")
    protected String resourceType;

    @OSGiService
    private SlingSettingsService settings;
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    //read value of title entered in dialog and stored in JCR
    //map value of title to Java variable named title
    @ValueMapValue
    private String title; //this name must match the name that was created in content.xml (title)

    @ValueMapValue
    private String text; //this name must match the name that was created in content.xml (text)

    @ValueMapValue
    private String subtitle; //this name must match the name that was created in content.xml (subtitle)

    private String message;

    @PostConstruct
    protected void init() {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        String currentPagePath = Optional.ofNullable(pageManager)
                .map(pm -> pm.getContainingPage(currentResource))
                .map(Page::getPath).orElse("");

        message = "Hello World!\n"
            + "Resource type is: " + resourceType + "\n"
            + "Current page is:  " + currentPagePath + "\n"
            + "This is instance: " + settings.getSlingId() + "\n";
    }

    //if we plan to call method from HTL script, then it should have no parameters
    public String getMessage() {
        return message;
    }
     //if we plan to call method from HTL script, then it should have no parameters
    public String getTitle() {
        return StringUtils.isNotBlank(title) ? title : "Default Value here!";
    }

     //if we plan to call method from HTL script, then it should have no parameters
     public String getText() {
        return StringUtils.isNotBlank(text) ? text.toUpperCase() : null;
    }

     //if we plan to call method from HTL script, then it should have no parameters
     public String getSubtitle() {
        return StringUtils.isNotBlank(subtitle) ? subtitle.toLowerCase() : "Subtitle value is empty";
    }

}
