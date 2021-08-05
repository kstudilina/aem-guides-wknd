package com.adobe.aem.guides.wknd.core.models.impl;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import com.adobe.aem.guides.wknd.core.models.Card;
import com.adobe.cq.wcm.core.components.models.Image;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.apache.sling.api.resource.Resource;
import com.google.common.collect.ImmutableList;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class CardImplTest {

    private final AemContext ctx = new AemContext();

    @Mock
    private Image image;

    @Mock
    private ModelFactory modelFactory;

    @BeforeEach
    public void setUp() throws Exception {
        ctx.addModelsForClasses(CardImpl.class);

        ctx.load().json("/com/adobe/aem/guides/wknd/core/models/impl/CardImplTest.json", "/content");

        lenient().when(modelFactory.getModelFromWrappedRequest(eq(ctx.request()), any(Resource.class), eq(Image.class)))
                .thenReturn(image);

        ctx.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
    }

    //getTitle() test
    @Test
    public void testGetTitle() {
        final String expected = "Night in forest";

        ctx.currentResource("/content/card");
        Card card = ctx.request().adaptTo(Card.class);

        String actual = card.getTitle();

        assertEquals(expected, actual);
    }

    //getDescription() test
    @Test
    public void testGetDescription() {
        final String expected = "Stars,birds,trees";

        ctx.currentResource("/content/card");
        Card card = ctx.request().adaptTo(Card.class);

        String actual = card.getDescription();

        assertEquals(expected, actual);
    }

    //getButtontext() test
    @Test
    public void testGetButtontext() {
        final String expected = "More about birds";

        ctx.currentResource("/content/card");
        Card card = ctx.request().adaptTo(Card.class);

        String actual = card.getButtontext();

        assertEquals(expected, actual);
    }

    //getButtonlink() test
    @Test
    public void testGetButtonlink() {
        final String expected = "https://www.thoughtco.com/facts-about-birds-4069408#:~:text=%2010%20Essential%20Facts%20About%20Birds%20%201,is%20now%20incontestable%20that%20birds%20evolved...%20More%20";

        ctx.currentResource("/content/card");
        Card card = ctx.request().adaptTo(Card.class);

        String actual = card.getButtonlink();

        assertEquals(expected, actual);
    }
    

    @Test
    public void testIsEmpty() {
        ctx.currentResource("/content/empty");

        Card card = ctx.request().adaptTo(Card.class);

        assertTrue(card.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutTitle() {
        ctx.currentResource("/content/without-title");

        Card card = ctx.request().adaptTo(Card.class);

        assertTrue(card.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutDescription() {
        ctx.currentResource("/content/without-description");

        Card card = ctx.request().adaptTo(Card.class);

        assertTrue(card.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutButtontext() {
        ctx.currentResource("/content/without-buttontext");

        Card card = ctx.request().adaptTo(Card.class);

        assertTrue(card.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutButtonlink() {
        ctx.currentResource("/content/without-buttonlink");

        Card card = ctx.request().adaptTo(Card.class);

        assertTrue(card.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutImage() {
        ctx.currentResource("/content/card");

        lenient().when(modelFactory.getModelFromWrappedRequest(eq(ctx.request()),
            any(Resource.class),
            eq(Image.class))).thenReturn(null);

        Card card = ctx.request().adaptTo(Card.class);

        assertTrue(card.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutImageSrc() {
        ctx.currentResource("/content/card");

        when(image.getSrc()).thenReturn("");

        Card card = ctx.request().adaptTo(Card.class);

        assertTrue(card.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        ctx.currentResource("/content/card");
        when(image.getSrc()).thenReturn("/content/bio.png");

        Card card = ctx.request().adaptTo(Card.class);

        assertFalse(card.isEmpty());
    }
}
